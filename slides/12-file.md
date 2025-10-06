---
layout: frontcover
transition: none
title: IDP - POO
id: aula12
lesson: Manipulação de arquivos texto
goals:
  - Escrever conteúdo formatado em arquivos com `Formatter`
  - Ler arquivos usando `java.nio.file.Path` e `Scanner`
  - Tratar exceções comuns em operações de I/O
---

---
layout: default
lesson: Escrita de arquivos
---

## Criando `clients.txt`

```java
// CreateTextFile.java
try (Formatter output = new Formatter("clients.txt");
     Scanner input = new Scanner(System.in)) {
    System.out.printf("Enter account number, first name, last name and balance.%n");

    while (input.hasNext()) {
        output.format("%d %s %s %.2f%n",
            input.nextInt(), input.next(), input.next(), input.nextDouble());
        System.out.print("? ");
    }
}
catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
    e.printStackTrace();
}
```

- `try-with-resources` garante fechamento do arquivo
- `Formatter` permite formatar texto semelhante a `printf`

---

## Leitura formatada

```java
// ReadTextFile.java
try (Scanner input = new Scanner(Path.of("clients.txt"))) {
    System.out.printf("%-10s%-12s%-12s%10s%n",
        "Account", "First Name", "Last Name", "Balance");

    while (input.hasNext()) {
        int accountNumber = input.nextInt();
        String firstName = input.next();
        String lastName = input.next();
        double balance = input.nextDouble();
        System.out.printf("%-10d%-12s%-12s%10.2f%n",
            accountNumber, firstName, lastName, balance);
    }
}
catch (IOException | NoSuchElementException | IllegalStateException e) {
    e.printStackTrace();
}
```

- `Path.of` evita APIs antigas (`File`)
- Scanner segmenta tokens usando espaços em branco

---

## Boas práticas de I/O

- Valide se o arquivo existe antes de ler (`Files.exists`)
- Evite sobrescrever arquivos importantes (verifique permissões)
- Trate `NoSuchElementException` ao ler dados mal formatados
- Prefira `BufferedWriter/Reader` para arquivos grandes

---
layout: backcover
---
