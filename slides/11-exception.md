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
