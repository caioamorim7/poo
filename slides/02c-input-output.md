---
layout: frontcover
transition: none
title: IDP - POO
id: aula02c
lesson: Entrada e saída de dados no console
goals:
  - Ler dados do teclado com `Scanner` e `BufferedReader`
  - Formatar saídas usando `System.out.printf`
  - Entender tratamento básico de recursos de I/O
---

---
layout: default
lesson: Leitura com Scanner
---

## Exemplo `ScannerSample`

```java
Scanner input = new Scanner(System.in);

System.out.print("Informe um inteiro: ");
int i = input.nextInt();
System.out.printf("Valor informado: %d%n", i);

System.out.print("Informe um texto: ");
String s = input.next();
System.out.printf("Valor informado: %s%n", s);
```

- `nextInt`, `nextDouble`, `nextBoolean`, `next`, `nextLine`
- Após `nextInt`, use `nextLine` para consumir `\n`
- Sempre chame `input.close()` ao final

---

## Com `BufferedReader`

```java
// BufferedReaderSample.java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Nome: ");
String nome = reader.readLine();
System.out.println("Olá, " + nome + "!");
```

- Lança `IOException`: use `try-with-resources` ou trate o `throws`
- Apropriado quando precisamos ler linhas completas sem parsing automático

---

## Formatando saída

- `System.out.printf` aceita especificadores como `%d`, `%.2f`, `%s`, `%b`
- `System.out.println` imprime e adiciona `\n`
- `System.out.printf("%-10s", valor)` alinha colunas
- Caminho dos exemplos: `lectures/examples/02c-input-output`

---

## Exercícios sugeridos

- Adaptar `ScannerSample2` para validar entrada inválida com `hasNextInt`
- Criar menu interativo combinando leitura numérica e textual
- Medir impacto de `Locale` na leitura de números decimais

---
layout: backcover
---
