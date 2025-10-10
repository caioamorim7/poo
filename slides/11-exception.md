---
layout: frontcover
transition: none
title: IDP - POO
id: aula11
lesson: Tratamento de exceções
goals:
  - Detectar e tratar situações excepcionais com `try-catch`
  - Criar exceções personalizadas para regras de negócio
  - Utilizar `finally` e boas práticas de tratamento
---

---
layout: default
lesson: Hierarquia essencial
---

- `Throwable` divide-se em `Error` (falhas graves da JVM) e `Exception`
- `Exception` agrupa erros recuperáveis; `RuntimeException` e subclasses são não checadas
- Exceções checadas comuns: `IOException`, `SQLException`, `ClassNotFoundException`
- Pacotes especializados: `java.io` (I/O), `java.sql` (banco), `java.time` (data/hora)
- Consulte `lectures/examples/11-exception/doc/exceptions.puml` para o diagrama completo

---

## Checadas x não checadas

- **Checadas** (`Exception` fora de `RuntimeException`): compilador exige `try-catch` ou `throws`
- **Não checadas** (`RuntimeException`, `Error`): indicam bugs/condições inesperadas
- Trate checadas próximas à fronteira externa (UI, APIs, persistência)
- Envolva não checadas apenas para enriquecer contexto; evite ocultá-las
- Propague mantendo causa (`throw new MinhaExcecao("falha", e);`)

---

layout: default
lesson: Exceções aritméticas
---

## Divisão segura

```java
// DivideByZeroWithExceptionHandling.java
try {
    System.out.print("Please enter an integer numerator: ");
    int numerator = scanner.nextInt();
    System.out.print("Please enter an integer denominator: ");
    int denominator = scanner.nextInt();
    int result = quotient(numerator, denominator);
    continueLoop = false;
}
catch (InputMismatchException e) {
    System.err.println("You must enter integers. Please try again.");
    scanner.nextLine();
}
catch (ArithmeticException e) {
    System.err.println("Zero is an invalid denominator. Please try again.");
}
```

- Captura múltiplas exceções específicas
- Loop continua até entrada válida (`continueLoop`)
- `ArithmeticException` é não verificada (unchecked); `InputMismatchException` pertence a `java.util`
- A ordem dos blocos `catch` deve ir do mais específico ao mais genérico

---

## Exceção personalizada

```java
// MyException.java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

- Permite sinalizar regras de negócio
- Lançada em `quotient` (descomentando verificação)
- Sempre propague (`throws`) ou trate a exceção customizada
- Exceções checadas (`Exception`) exigem tratamento explícito
- Mantenha mensagens claras para facilitar troubleshooting

---

## Declaração e propagação

```java
// FileLoader.java
public String load(String path) throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
        return reader.readLine();
    }
}
```

- `throws` documenta exceções checadas propagadas pela API
- Métodos podem capturar e traduzir (`throw new BusinessException("...", e);`)
- Reavalie contratos após adicionar novas exceções; atualize documentação
- Use exceções específicas para sinalizar causa semântica ao consumidor

---

## Fluxo com `finally`

```java
// UsingExceptions.java
try {
    throwException();
}
catch (Exception exception) {
    System.err.println("Exception handled in main");
}

doesNotThrowException();
```

- `throwException` relança a exceção após tratamento
- Bloco `finally` executa independentemente de erros
- `doesNotThrowException` mostra `finally` mesmo sem exceção
- `finally` é ideal para liberar recursos (fechar arquivos, conexões)
- Propagação constrói *stack trace* revelando a cadeia de chamadas

---

## Try-with-resources

```java
// TryWithResourcesDemo.java
try (var reader = Files.newBufferedReader(path);
     var writer = Files.newBufferedWriter(out)) {
    writer.write(reader.readLine());
}
```

- Fecha recursos automaticamente ao sair do bloco
- Cada recurso deve implementar `AutoCloseable`
- Recursos são fechados em ordem inversa à declaração
- Captura `IOException` sem vazamento de descritores
- Blocos `catch` e `finally` ainda podem ser adicionados se necessário

---

## Multi-catch e rethrow

```java
try {
    process(request);
}
catch (IOException | SQLException e) {
    throw new ServiceException("Falha de infraestrutura", e);
}
```

- Multi-catch evita duplicação de tratamento para exceções relacionadas
- Variável `e` é efetivamente final dentro do bloco
- Use `throw` simples para repropagar mantendo o `stack trace`
- Ao criar nova exceção, passe a causa original (`new ...(..., e)`)
- Adicione contexto (ex.: parâmetros relevantes) antes de repropagar

---

## Encadeamento e suprimidas

```java
try {
    runTask();
}
catch (OperationException e) {
    e.getSuppressed(); // exceções fechadas em try-with-resources
    throw e.initCause(new IllegalStateException("scheduler"));
}
```

- `initCause` ou construtores permitem encadear causas
- `getSuppressed()` captura exceções ocultadas por `try-with-resources`
- Faça log das suprimidas para diagnosticar desalocações falhas
- Exceções encadeadas facilitam rastrear origem real do erro
- Evite sobrescrever causa original sem necessidade

---

## Boas práticas

- Trate apenas exceções recuperáveis; deixe falhas graves subirem
- Registre (`logger.error`) detalhes antes de repropagar
- Não silencie exceções vazias (`catch (Exception e) {}`)
- Utilize mensagens claras para ajudar no diagnóstico
- Prefira exceções específicas (`IllegalArgumentException`, `IllegalStateException`)
- Evite usar exceções para controle de fluxo normal

---
layout: backcover
---
