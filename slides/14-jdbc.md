---
layout: frontcover
transition: none
title: IDP - POO
id: aula14
lesson: Integração com banco de dados via JDBC
goals:
  - Estabelecer conexões JDBC com propriedades externas
  - Executar consultas parametrizadas com `PreparedStatement`
  - Tratar exceções e fechar recursos com `try-with-resources`
---

---
layout: default
lesson: Conectando ao banco
---

## Carregando configurações

```java
// ConnectionDemo.java
Properties props = new Properties();
try (var inputStream = Files.newInputStream(Paths.get("db.properties"))) {
    props.load(inputStream);
}

String url = props.getProperty("url");
String user = props.getProperty("user");
String password = props.getProperty("password");

try (Connection conexao = DriverManager.getConnection(url, user, password)) {
    System.out.println("Conexão estabelecida com sucesso!");
}
```

- `db.properties` centraliza dados sensíveis
- `DriverManager` cria a conexão usando o JDBC driver apropriado
- JDBC é uma API baseada em interfaces (`Connection`, `Statement`, `ResultSet`)
- Utilize variáveis de ambiente ou cofres para proteger credenciais

---

## Consultas parametrizadas

```java
// PreparedStatementSelectDemo.java
String sql = "SELECT first_name, last_name FROM actor WHERE first_name = ?";

try (Connection conn = DriverManager.getConnection(url, user, password);
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, "Fred");
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        System.out.printf("%s %s%n", rs.getString("first_name"), rs.getString("last_name"));
    }
}
```

- `PreparedStatement` evita SQL injection e permite reuso do plano de execução
- Utilize `setInt`, `setDouble`, etc., conforme o tipo da coluna
- ResultSets podem ser percorridos linha a linha (`next()`)
- Conjuntos grandes demandam paginação (`setFetchSize`, `LIMIT/OFFSET`)

---

## Operações de escrita

- `PreparedStatementInsertDemo`, `PreparedStatementUpdateDemo`, `PreparedStatementDeleteDemo`
  - Parametrizam comandos `INSERT`, `UPDATE`, `DELETE`
  - Retornam quantidade de linhas afetadas (`executeUpdate`)
- `StatementSelectDemo` e `StatementSelectOrderByDemo`
  - Comparação entre `Statement` e `PreparedStatement`
- `SQLExceptionDemo` mostra como acessar `SQLState` e `errorCode`
- Use transações (`setAutoCommit(false)`) para executar múltiplas operações atômicas
- Conexões devem ser reutilizadas via pools (`HikariCP`, `Apache DBCP`)

---

## Ambiente de execução

- `docker-compose.yaml` provisiona banco PostgreSQL para testes locais
- Copie `db.properties.samples` para `db.properties` e ajuste credenciais
- Prefira data sources (`ConnectionDataSourceDemo`) em aplicações reais
- Feche recursos sempre em `try-with-resources` para evitar leaks
- Drivers JDBC específicos (PostgreSQL, MySQL) precisam estar no classpath
- Diagrama ER auxilia a compreender relações antes de escrever consultas

---
layout: backcover
---
