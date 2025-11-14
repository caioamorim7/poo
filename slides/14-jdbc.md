---
layout: frontcover
transition: none
title: IDP - POO
id: aula14
lesson: Acesso a banco de dados via JDBC
goals:
  - Revisar fundamentos de tabelas relacionais e comandos SQL
  - Conectar-se via driver JDBC conhecido e gerenciar recursos com segurança
  - Executar operações SQL (Statement, PreparedStatement, CallableStatement)
  - Processar resultados, extrair metadados e controlar transações
---

---
layout: default
lesson: Roteiro
---

- Por que bancos relacionais continuam relevantes no backend Java
- Fluxo JDBC: driver, `DriverManager`/`DataSource`, `Connection`
- Boas práticas para carregar propriedades e fechar recursos
- Criação e execução de statements (consulta, escrita, procedures)
- Customização de `ResultSet`, metadados e capacidades do SGBD
- Transações e consistência dos dados na prática (commit/rollback)

---
layout: default
lesson: Banco de dados e DBMS
---

- `database`: repositório estruturado que armazena dados relacionados e versionados
- `database management system (DBMS)`: software que controla armazenamento, segurança, concorrência e exposição dos dados
- Finalidade de bancos relacionais: controlar acessos, manter os dados íntegros/consistentes e permitir consultas flexíveis
- Tipos clássicos:
  - Hierarchical — dados em árvore (parent/child)
  - Network — registros conectados em grafo
  - Object — objetos persistidos com atributos e métodos
  - Relational — tabelas com chaves e restrições declarativas
- Os relacionais prevalecem por combinarem integridade referencial, linguagem padrão (SQL) e tooling maduro para auditoria e segurança

---
layout: default
lesson: Introdução ao modelo relacional
---

- Tabelas (`relations`) representam entidades; colunas (atributos) são tipadas e linhas (tuplas) guardam valores
- Restrições (`PRIMARY KEY`, `FOREIGN KEY`, `UNIQUE`, `CHECK`) preservam a integridade e descrevem relações
- Cada atributo possui domínio (tipo SQL) e regras de nulidade; ver diagrama `lectures/examples/14-jdbc/doc/postgresql-architecture.png`
- Structured Query Language (SQL) descreve o que precisamos recuperar/modificar; o otimizador escolhe o plano
- Operações CRUD em Java refletem comandos SQL executados via JDBC

---
layout: default
lesson: SQL em ação
---

```sql
SELECT f.film_id, f.title, c.name AS category
FROM film f
JOIN film_category fc ON fc.film_id = f.film_id
JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Comedy'
ORDER BY f.release_year DESC
LIMIT 5;
```

- ANSI (American National Standards Institute) mantém o SQL standard → maior portabilidade entre fornecedores
- Diagramas como `lectures/examples/14-jdbc/doc/postgresql-sequence.png` ajudam a enxergar o relacionamento antes de escrever consultas
- 👉 Dominar SQL padronizado torna mais simples mapear as operações para a JDBC API (próximo slide)

---
layout: default
lesson: SQL e categorizações
---

- **DML (Data Manipulation Language)**: `SELECT`, `INSERT`, `UPDATE`, `DELETE` — manipula linhas existentes
- **DDL (Data Definition Language)**: `CREATE TABLE`, `ALTER TABLE`, `DROP` — cria e altera estruturas
- **TCL (Transaction Control Language)**: `COMMIT`, `ROLLBACK`, `SAVEPOINT` — controla atomicidade
- Operações CRUD (`Create`, `Read`, `Update`, `Delete`) conectam a camada de serviço Java aos comandos DML correspondentes
- Scripts DDL versionados (Flyway, Liquibase) combinados com DML controlado permitem reproduzir ambientes de forma consistente
- Esses blocos se traduzem diretamente em métodos da JDBC API (DML ↔ `PreparedStatement.executeUpdate`, TCL ↔ `Connection.commit/rollback`)

---
layout: default
lesson: JDBC API
---

- JDBC (Java Database Connectivity) viabiliza develop Java applications that use a relational database
- Pacote `java.sql` define interfaces centrais: `DriverManager`, `Connection`, `Statement`, `PreparedStatement`, `CallableStatement`, `ResultSet`, `SQLException`
- JDBC drivers (PostgreSQL, Oracle, MySQL) são bibliotecas que traduzem chamadas JDBC para o protocolo nativo do SGBD
- Passos para conectar:
  1. Ensure that the relevant JDBC driver esteja no *classpath* ou *module path*
  2. Load the JDBC driver to memory (drivers modernos se registram automaticamente)
  3. Establish the database connection via `DriverManager.getConnection` ou um `DataSource`
- Após a conexão:
  1. Create SQL statements
  2. Execute SQL statements
  3. Process query results
  4. Close the JDBC resources
- Entender essa sequência ajuda a diagnosticar gargalos e a compor camadas de acesso a dados (DAO/Repository)

---
layout: default
lesson: Driver e fluxo de conexão
---

![Fluxo JDBC](../lectures/examples/14-jdbc/doc/connection-flow.png)

1. A aplicação faz load do driver específico (PostgreSQL, MySQL, etc.)
2. `DriverManager` (ou um `DataSource` de pool) media a criação de `Connection`
3. A conexão entrega objetos `Statement`/`PreparedStatement` para executar SQL
4. O SGBD responde com `ResultSet` ou contagem de linhas

Boas práticas:
- Dependências JDBC no *classpath* (Maven/Gradle) + `db.properties` ou variáveis de ambiente para credenciais
- Teste de conectividade isolado antes de habilitar operações de escrita
- Documente requisitos (driver version, string de conexão) no repositório

---
layout: default
lesson: Connection, DriverManager e URL
---

- `java.sql.DriverManager`
  - `getConnection(String url, String user, String password)` e variações com `Properties`
  - Seleciona o driver registrado que reconhece o prefixo `jdbc:<sgbd>`
- `java.sql.Connection`
  - Métodos essenciais: `createStatement`, `prepareStatement`, `prepareCall`, `setAutoCommit`, `commit`, `rollback`, `setTransactionIsolation`, `close`
  - Pode expor recursos extras via `unwrap` para drivers específicos
- URL JDBC segue `protocol:provider:driver_type:database_specific_connection_details`
  - Ex.: `jdbc:postgresql://localhost:5432/dvdrental?currentSchema=public&sslmode=disable`
  - Configure parâmetros de timezone, schema e SSL conforme o ambiente
- Centralize a URL em `db.properties` ou variáveis de ambiente para evitar recompilações ao mudar hosts/credenciais

---
layout: default
lesson: Configuração segura
---

```java
// DvdRentalApp.java
Properties props = new Properties();
try (var input = Files.newInputStream(Paths.get("db.properties"))) {
    props.load(input);
}

String url = props.getProperty("url");
String user = props.getProperty("user");
String password = props.getProperty("password");

try (Connection conn = DriverManager.getConnection(url, user, password)) {
    System.out.println("Conectado!");
}
```

- `Properties` evita *hardcode* de segredos; versionar somente `db.properties.sample`
- Use `try-with-resources` desde a abertura da conexão → fechamento garantido
- Em produção, prefira `DataSource` com pool (HikariCP, DBCP) e segredos em cofre/ENV

---
layout: default
lesson: Gerenciando recursos
---

- JDBC expõe interfaces autocloseable (`Connection`, `Statement`, `ResultSet`)
- `try-with-resources` encadeado elimina *finally* verboso e previne *leaks*
- Em APIs com latência/volume, configure `setNetworkTimeout`, `setReadOnly`, `setAutoCommit`
- Sequência típica:
  1. Abre conexão
  2. Prepara statement
  3. Executa
  4. Processa `ResultSet`
  5. *Commit*/*rollback* se necessário

```java
try (Connection conn = dataSource.getConnection();
     PreparedStatement ps = conn.prepareStatement(SQL)) {
    // ...
} catch (SQLException ex) {
    log.error("Erro JDBC", ex);
}
```

---
layout: default
lesson: Tratamento de exceções
---

```java
try {
    /* execute JDBC operations */
} catch (SQLException e) {
    String state = e.getSQLState();
    int code = e.getErrorCode();
}
```

```java
try {
    /* establish database connection     */
    /* create and execute SQL statements */
    /* process results                   */
} catch (SQLException e) {
    /* handle any errors */
} finally {
    /* close result sets */
    /* close statements  */
    /* close connection  */
}
```

```java
try (/* establish database connection     */
     /* create and execute SQL statements */) {
    /* process results */
} catch (SQLException e) {
    /* handle any exceptions */
} // implicit finally block closes resources
```

- `SQLException` oferece `getSQLState`, `getErrorCode` e `getNextException` para identificar a origem do problema
- Converta exceções genéricas em erros de domínio e registre o `SQLState` para auditoria

---
layout: default
lesson: Statements no JDBC
---

| API                | Uso principal                                                    | Métodos-chave                                                 |
|--------------------|------------------------------------------------------------------|---------------------------------------------------------------|
| `Statement`        | Executar SQL estático (sem parâmetros)                           | `executeQuery`, `executeUpdate`, `execute`, `setFetchSize`    |
| `PreparedStatement`| SQL pré-compilado com placeholders (`?`), evita SQL injection     | `setString`, `setInt`, `setObject`, `addBatch`, `executeUpdate`|
| `CallableStatement`| Invocar stored procedures/functions com parâmetros IN/OUT        | `registerOutParameter`, `setObject`, `getObject`, `execute`   |
| `ResultSet`        | Cursor para percorrer dados retornados                           | Navegação `next/previous`, leitura `getString/getInt`, `close`|

- Escolha a API conforme o padrão de uso (consulta simples, comando parametrizado, procedure)
- `CallableStatement` também permite recuperar códigos de saída e status de procedimentos do SGBD

---
layout: default
lesson: PreparedStatement em ação
---

```java
// Trechos de PreparedStatementSelectDemo.java
String sql = """
    SELECT actor_id, first_name, last_name
    FROM actor
    WHERE last_name = ?
""";

try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, "Chase");
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            System.out.printf("%s %s%n",
                rs.getString("first_name"),
                rs.getString("last_name"));
        }
    }
}
```

- Parâmetros tipados (`setString`, `setInt`, `setBigDecimal`) protegem contra SQL injection
- O driver pode reutilizar o plano preparado, reduzindo custo em consultas repetitivas

---
layout: default
lesson: Statement básico passo a passo
---

```java
try (Connection connection = DriverManager.getConnection(jdbcURL); // (1)
     Statement statement = connection.createStatement()) {          // (2)
    String sql = "SELECT * FROM film ORDER BY title";               // (3)
    statement.executeQuery(sql);                                    // (4)
} catch (SQLException e) {
    e.printStackTrace();
}
```

1. `DriverManager.getConnection()` cria a `Connection`
2. `connection.createStatement()` fornece o `Statement`
3. Formule o SQL (strings constantes ou construídas dinamicamente)
4. Execute com `executeQuery`, `executeUpdate` ou `execute`

::callout
Use `PreparedStatement` sempre que houver parâmetros externos; `Statement` é reservado a comandos fixos.
:::

---
layout: default
lesson: Processando ResultSet
---

- `ResultSet` representa o cursor retornado; métodos principais:
  - Navegação: `next`, `previous`, `absolute`, `afterLast`, `beforeFirst`
  - Leitura: `getString`, `getInt`, `getBigDecimal`, `getObject`
  - Atualização (quando suportado): `updateString`, `updateInt`, `updateRow`
- Customize o cursor ao criar o statement:
  - `ResultSet.TYPE_SCROLL_INSENSITIVE` para navegar (`previous`, `absolute`)
  - `ResultSet.CONCUR_UPDATABLE` para atualizar linhas diretamente
- Paginação eficiente: `stmt.setFetchSize(50)` + `LIMIT/OFFSET` na consulta

```java
try (PreparedStatement ps = conn.prepareStatement(
        sql,
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY)) {
    ps.setString(1, categoria);
    try (ResultSet rs = ps.executeQuery()) {
        rs.afterLast();
        while (rs.previous()) {
            // leitura invertida
        }
    }
}
```

- `JdbcRowSet` (exemplo `RowSetJdbcRowSetTest.java`) encapsula `ResultSet` desconectado e serializável

---
layout: default
lesson: Metadados e capacidades
---

![JDBC API](../lectures/examples/14-jdbc/doc/jdbc-api.png)

```java
try (Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT * FROM film LIMIT 1")) {

    ResultSetMetaData meta = rs.getMetaData();
    int columns = meta.getColumnCount();
    for (int i = 1; i <= columns; i++) {
        System.out.printf("%s (%s)%n",
            meta.getColumnName(i),
            meta.getColumnTypeName(i));
    }
}
```

- `ResultSetMetaData`: nomes, tipos SQL, nulabilidade → útil para gerar tabelas dinâmicas ou logs
- `DatabaseMetaData`: capacidades do driver/SGBD (transações suportadas, palavras reservadas, catálogos)
- `ParameterMetaData`: útil ao construir SQL dinâmico validando tipos antes de setar parâmetros

---
layout: default
lesson: Transações e atomicidade
---

```java
try (Connection conn = DriverManager.getConnection(url, user, password)) {
    conn.setAutoCommit(false);

    atualizarEstoque(conn);
    registrarHistorico(conn);

    conn.commit();
} catch (SQLException ex) {
    conn.rollback(); // garantir consistência
}
```

- `autoCommit=true` (padrão) executa cada statement como transação isolada → desative quando precisar agrupar
- Sempre realize `commit` explícito ou `rollback` no `catch`/`finally`
- Defina nível de isolamento conforme necessidade (`READ COMMITTED`, `SERIALIZABLE`)
- Log de auditoria (`demo/dvdrentalapp/audit.log`) ajuda a validar se operações múltiplas foram persistidas corretamente

---
layout: default
lesson: Hands-on sugerido
---

1. `cd lectures/examples/14-jdbc/src/demo/dvdrentalapp && docker compose up`
2. Copie `db.properties.sample` → `db.properties` ajustando URL, usuário e senha
3. Rode `mvn exec:java -Dexec.mainClass=DvdRentalApp` para percorrer consultas, inserts e rollback
4. Execute `RowSetJdbcRowSetTest.java` para analisar `JdbcRowSet` desconectado
5. Mostre os diagramas `jdbc-api.png` e `postgresql-sequence.png` durante a execução para relacionar código e arquitetura

---
layout: default
lesson: Checklist e referências
---

**Checklist**
- [ ] Connection string e driver no classpath
- [ ] `db.properties` (ou variáveis) carregado via `Properties`
- [ ] Statements parametrizados e resultados tratados
- [ ] Recursos fechados e transações controladas
- [ ] Metadados e capacidades documentados para o time

**Referências**
- Oracle. *JDBC Developer Guide*, 2024.
- PostgreSQL Global Development Group. *JDBC Driver Manual*, versão 42.
- Exemplos completos em `lectures/examples/14-jdbc/src` e diagramas em `lectures/examples/14-jdbc/doc`.

---
layout: backcover
---
