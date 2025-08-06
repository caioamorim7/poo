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

## Elementos da linguagem Java - _integer literals_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos
- _identifiers​_
- _keywords​_
- **_literals​_**
    - **_integer literals_**
    - **_
- _separators​_
- _operators​_

</div>

<div>

- base decimal
- base hexadecimal
- base octal
- base binária

<FigureWithCaption
    src="images/literalsInteger.png"
    alt="Java integer literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.10"
/>


</div>

</div>

---

## Elementos da linguagem Java - _integer literals_

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

<FigureWithCaption
    src="images/literalsInteger.png"
    alt="Java integer literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-IntegerLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _integer literals_

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
jshell> 10 // decimal integer literal
$1 ==> 10

jshell> 0X10 // hexadecimal integer literal
$2 ==> 16

jshell> 010 // octal integer literal
$3 ==> 8

jshell> 0B10 // binary integer literal
$4 ==> 2
```

</div>

</div>

---

## Elementos da linguagem Java - _floating point literals_

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

<FigureWithCaption
    src="images/literalsFloating.png"
    alt="Java floating point literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-3.10.2"
/>

</div>

</div>

---

## Elementos da linguagem Java - _floating point literals_

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
jshell> 10F // decimal float literal
$1 ==> 10.0

jshell> 10E2F // decimal float literal
$2 ==> 1000.0

jshell> 10.0F // decimal float literal
$3 ==> 10.0

jshell> 10.0 // decimal double literal
$4 ==> 10.0

jshell> 10D // decimal double literal
$5 ==> 10.0

jshell> 10E2 // decimal double literal
$6 ==> 1000.0
```

</div>

</div>

---

## Elementos da linguagem Java - _boolean literals_

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

<FigureWithCaption
    src="images/literalsBoolean.png"
    alt="Java boolean literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-BooleanLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _boolean literals_

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
jshell> true // boolean literal
$1 ==> true

jshell> false // boolean literal
$2 ==> false
```

</div>

</div>

---

## Elementos da linguagem Java - _character literals_

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

<FigureWithCaption
    src="images/literalsCharacter.png"
    alt="Java character literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-CharacterLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _character literals_

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
jshell> 'A'
$1 ==> 'A'

jshell> 'a'
$2 ==> 'a'

jshell> '$'
$3 ==> '$'

jshell> '\u0024'
$4 ==> '$'
```

</div>

</div>

---

## Elementos da linguagem Java - _String literals_

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

<FigureWithCaption
    src="images/literalsString.png"
    alt="Java string literals"
    link="https://docs.oracle.com/javase/specs/jls/se21/html/jls-3.html#jls-StringLiteral"
/>

</div>

</div>

---

## Elementos da linguagem Java - _String literals_

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
jshell> ""
$1 ==> ""

jshell> "Programação Orientada a Objetos"
$2 ==> "Programação Orientada a Objetos"

jshell> "Programação " + 
   ...> "Orientada a " +
   ...> "Objetos" +
$3 ==> "Programação Orientada a Objetos"
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
    - **_arithmetic_**
    - _relacional_
    - _logical_
    - _bitwise_

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

## Elementos da linguagem Java - _arithmetic operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - **_arithmetic_**
    - _relacional_
    - _logical_
    - _bitwise_

</div>

<div>

```bash
jshell> 10 + 10 // adição
$1 ==> 20

jshell> 10 - 10 // subtração
$2 ==> 0

jshell> 10 * 10 // multiplicação
$3 ==> 100

jshell> 10 / 10 // divisão
$4 ==> 1

jshell> 23 % 10 // módulo
$5 ==> 3

jshell> 10 + 0B1010 + 012 + 0XA // bases diferentes
$6 ==> 40
```

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
    - _arithmetic_
    - **_relacional_**
    - _logical_
    - _bitwise_


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

## Elementos da linguagem Java - _relational operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - **_relacional_**
    - _logical_
    - _bitwise_

</div>

<div>

```bash
jshell> 1 + 1 == 2 // igual a
$1 ==> true

jshell> 1 + 1 != 3 // diferente de
$2 ==> true

jshell> 1 + 1 > 3 // maior que
$3 ==> false

jshell> 1 + 1 < 3 // menor que
$4 ==> true

jshell> 1 + 1 >= 2 // maior ou igual que
$5 ==> true

jshell> 1 + 1 <= 2 // menor ou igual que
$6 ==> true
```

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
    - _arithmetic_
    - _relacional_
    - **_logical_**
    - _bitwise_

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

## Elementos da linguagem Java - _logical operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - _relacional_
    - **_logical_**
    - _bitwise_

</div>

<div>

```bash
jshell> 1 + 1 == 2 && 1 - 1 != 2 // E
$1 ==> true

jshell> 1 + 1 == 2 || 1 - 1 > 2 // OU
$2 ==> true

jshell> 1 + 1 == 2 && 1 - 1 > 2
$3 ==> false

jshell> 1 + 1 == 2 ^ 1 - 1 > 2 // OU exclusivo
$4 ==> true

jshell> 1 + 1 == 2 ^ 1 - 1 < 2 // igual a 
$5 ==> false

jshell> 1 + 1 == 2 ? true : false // op. ternário
$6 ==> true
```

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
    - _arithmetic_
    - _relacional_
    - _logical_
    - **_bitwise_**

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

## Elementos da linguagem Java - _bitwise operators_

<div class="mt-4 grid grid-cols-2">
<div>

Elementos básicos

- _identifiers​_
- _keywords​_
- _literals​_
- _separators​_
- **_operators​_**
    - _arithmetic_
    - _relacional_
    - _logical_
    - **_bitwise_**

</div>

<div>

```bash
jshell> 0B10  // 0B00000000000000000000000000000010
$1 ==> 2 

jshell> ~0B10 // 0B11111111111111111111111111111101
$2 ==> -3 

jshell> 0B101 & 0B100 // 0B100
$3 ==> 4

jshell> 0B101 ^ 0B100 //0B001
$4 ==> 1

jshell> 0B101 | 0B100 //0B101
$5 ==> 5

jshell> 0B101>>1 // 0B10
$6 ==> 2

jshell> 0B101<<1 // 0B1010
$7 ==> 10
```


</div>

</div>

---
layout: backcover
---
