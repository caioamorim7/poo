---
layout: frontcover
transition: none
title: IDP - POO
id: aula03
lesson: Elementos da linguagem Java
goals:
  - Reconhecer os elementos da linguagem Java
  - Ambientar com as ferramentas de desenvolvimento Java
  - Codificar o primeiro programa Java
---

---
layout: default
lesson: Plataforma e linguagem Java
---

## Elementos da linguagem Java

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- _operators​_

</div>

<div>
</div>

</div>

---

## Elementos da linguagem Java - _identifiers_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- **_identifiers​_**
- _keywords​_
- _literals​_
- _separators​_
- _operators​_

</div>

<div>

- composto por uma sequência de caracteres, letras ou números
- deve iniciar com letra
- case sensitive

<FigureWithCaption
    src="images/identifiers.png"
    alt="Java identifiers"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.8"
/>

</div>

</div>

---

## Elementos da linguagem Java - _keywords_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- **_keywords​_**
- _literals​_
- _separators​_
- _operators​_


</div>

<div>

- palavras reservadas: não podem ser usados como identificadores
- _literals_ pré-definidos: _true_, _false_, _null_

<FigureWithCaption
    src="images/keywords.png"
    alt="Java keywords"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.9"
/>

</div>

</div>

---

## Elementos da linguagem Java - _literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

- representa um valor constante, podendo ser:
    - número: inteiro ou decimal
    - caractere: 'A'
    - booleano: _true_ ou _false_
    - string (texto): "Abc"

<FigureWithCaption
    src="images/literals.png"
    alt="Java literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.10"
/>

</div>

</div>

---

## Elementos da linguagem Java - _literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
- _separators​_
- _operators​_

</div>

<div>

```bash
@fabriciosantana ➜ /workspaces/poo (2025.2)$ jshell
|  Welcome to JShell -- Version 21.0.2
|  For an introduction type: /help intro
jshell> 5
$1 ==> 5
jshell> 9.98
$2 ==> 9.98
jshell> 'a'
$3 ==> 'a'
jshell> "Olá, Mundo!"
$4 ==> "Olá, Mundo!"
jshell> true
$5 ==> true
jshell> false
$6 ==> false
jshell> null
$7 ==> null
```

</div>

</div>

---

## Elementos da linguagem Java - _separators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- **_separators​_**
- _operators​_

</div>

<div>

- _tokens_ que possuem significado de acordo com o contexto

<FigureWithCaption
    src="images/separators.png"
    alt="Java separators"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.11"
/>

</div>

</div>

---

## Elementos da linguagem Java - _separators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- **_separators​_**
- _operators​_

</div>

<div>

<FigureWithCaption
    src="images/separatorsDetails.png"
    alt="Java separators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>


---

## Elementos da linguagem Java - _operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**

</div>

<div>

- aritiméticos
- relacionais
- lógicos
- bitwise

<FigureWithCaption
    src="images/operators.png"
    alt="Java operators"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.12"
/>

</div>

</div>

---

## Elementos da linguagem Java - _arithmetic operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**

</div>

<div>

<FigureWithCaption
    src="images/operatorsArithmetic.png"
    alt="Java arithmetic operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _relational operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**

</div>

<div>

<FigureWithCaption
    src="images/operatorsRelational.png"
    alt="Java relational operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _logical operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**

</div>

<div>

<FigureWithCaption
    src="images/operatorsBooleanLogical.png"
    alt="Java boolean logical operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---

## Elementos da linguagem Java - _bitwise operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**

</div>

<div>

<FigureWithCaption
    src="images/operatorsBitwise.png"
    alt="Java bitwise operators"
    reference="SCHILDT, Herbert. Java: The Complete Reference. 12. ed. New York: McGraw-Hill Education, 2021. ISBN 978-1-26-046342-2.​"
/>

</div>

</div>

---
layout: backcover
---
