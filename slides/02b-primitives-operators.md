---
layout: frontcover
transition: none
title: IDP - POO
id: aula02b
lesson: Tipos primitivos e operadores em Java
goals:
  - Aplicar operadores aritméticos, relacionais e lógicos
  - Realizar conversões implícitas e explícitas entre tipos
  - Analisar escopo e tempo de vida de variáveis
---

---
layout: default
lesson: Operadores em ação
---

## Exemplos disponíveis

- Diretório: `lectures/examples/02b-primitives-operators`
- Destaques:
  - `PrimitiveTypeBasicMath`, `PrimitiveTypeArea`: operações aritméticas
  - `OperatorBooleanLogic`, `OperatorRelationalEqual`: operadores booleanos
  - `VariableScope` e `VariableScopeErr`: escopo e lifetime

---

## Casting explícito

```java
// PrimitiveTypeCasting.java
int i = 257;
byte b = (byte) i; // overflow: 257 -> 1

double d = 323.142;
i = (int) d; // perde parte fracionária
b = (byte) d; // combina truncamento com overflow
```

- Atenção à perda de dados e ao comportamento de overflow
- Java promove automaticamente tipos menores em expressões aritméticas

---

## Operadores lógicos e relacionais

```java
// OperatorRelationalLeapYear.java
boolean isLeapYear = (year % 4 == 0);
isLeapYear = isLeapYear && (year % 100 != 0);
isLeapYear = isLeapYear || (year % 400 == 0);
System.out.println(isLeapYear);
```

- Combinação de `%`, `==`, `&&` e `||`
- Curto-circuito evita cálculos desnecessários
- Use parênteses para deixar a ordem explícita

---

## Incremento e escopo

- `OperatorIncDec.java`: diferenças entre `i++` e `++i`
- `OperatorAssignmentLifeTime.java`: mostra tempo de vida de variáveis em blocos
- Exercício: modifique `VariableScopeErr` para compilar corretamente
- Valide cada comportamento executando `java Classe` pelo terminal

---
layout: backcover
---
