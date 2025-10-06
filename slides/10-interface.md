---
layout: frontcover
transition: none
title: IDP - POO
id: aula10
lesson: Interfaces e polimorfismo baseado em contratos
goals:
  - Definir interfaces para unificar classes não relacionadas
  - Implementar múltiplas formas de pagamento com `Payable`
  - Explorar métodos `default` e benefícios de contratos explícitos
---

---
layout: default
lesson: Conceito de interface
---

## Por que interfaces?

- Permitem agrupar comportamentos comuns sem herança múltipla
- Classes implementam os métodos declarados pela interface
- Objetos podem ser manipulados via tipo contrato (`Payable`)
- Facilita inversão de dependência e testes

---

## Interface `Payable`

```java
// Payable.java
public interface Payable {
    double getPaymentAmount();

    default String metodoDefault() {
        return "Usando implementação default da interface";
    }
}
```

- Método abstrato obriga implementação específica
- Método `default` fornece comportamento padrão reutilizável
- Pode incluir métodos `static` utilitários

---

## Implementação em classes distintas

```java
// Invoice.java
public class Invoice implements Payable {
    @Override
    public double getPaymentAmount() {
        return getQuantity() * getPricePerItem();
    }
}

// SalariedEmployee.java
public class SalariedEmployee extends Employee implements Payable {
    @Override
    public double getPaymentAmount() {
        return getWeeklySalary();
    }
}
```

- `Invoice` e funcionários compartilham o contrato `Payable`
- Ganho: coleção heterogênea de itens pagáveis

---

## Processando polimorficamente

```java
// Main.java (trecho)
Payable[] payableObjects = {
    new Invoice("01234", "seat", 2, 375.00),
    new SalariedEmployee("John", "Smith", "111-11-1111", 800.00)
};

for (Payable currentPayable : payableObjects) {
    System.out.printf("%n%s %npayment due: $%,.2f%n",
        currentPayable.toString(), currentPayable.getPaymentAmount());
    System.out.println(currentPayable.metodoDefault());
}
```

- Arrays de `Payable` tratam objetos distintos de forma uniforme
- Classes podem sobrescrever o método `default` para customizar mensagens
- `Employee` delega `getPaymentAmount()` para `earnings()`

---

## Quando preferir interfaces

- Quando classes já possuem superclasse diferente (`Invoice` não é `Employee`)
- Para conectar camadas (ex.: `PaymentProcessor` recebe `Payable`)
- Ao definir APIs públicas duráveis (contratos > implementações)
- Combine com imutabilidade para facilitar testes

---
layout: backcover
---
