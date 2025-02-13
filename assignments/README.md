## Atividades práticas de programação em java

### Instruções gerais para entrega das atividades
* Realizar fork do repositório da disciplina
* Criar um diretório com seu nome e sobrenome dentro do diretório da atividade, conforme exemplo abaixo(o nome do último diretório deve ser seu nome e sobrenome):
```bash
mkdir poo/assignments/00-hello/submissions/fabricio-santana/src  
```
* Desenvolver programa Java dentro do seu diretório
* Atender os resuitivos da especificação e os requisitos de implementação
* Enviar um pull request
* Observar se os testes do pull request rodaram com sucesso
* Submeter link do pull request no [ambiente virtual](https://ambientevirtual.idp.edu.br/)
* Cumprir prazo de entrega

### Instruções gerais para testes locais das atividades

 ada atividade é acompanhada de testes unitários. Para avaliar seu código antes de submetê-lo, execute os seguintes comandos a partir de seu diretório pessoal de cada atividade
 ```bash
 mkdir -p lib

 curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar

 javac -cp "lib/*" -d bin src/*.java ../../test/*.java
 
 java -jar lib/junit-platform-console-standalone-1.11.4.jar --class-path bin --scan-class-path
 ```

### Lista de atividades

<details>
<summary><h4>Hello, World!</h4></summary>
  
#### Especificação

1. O programa deve imprimir no console a expressão "Hello, World!".
```
Hello, World!
```
#### Requisitos de implementação
  
1. O programa deve contar uma classe com nome *HelloWorld*
2. A classe deve ter 1 método público (_public_) e estático (_static_): *main*
3. O método *main* deve receber um parâmetro do tipo _String[]_ e não retornar nenhum valor (_void_)
7. Utilizar a classe [System.out](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/System.html#out) para imprimir informações no console
</details>

</details>

<details>
<summary><h4>Calculadora de índice de massa corporal (IMC)</h4></summary>

Referência: **DEITEL, P.; DEITEL, H.** *Java: How to Program, Early Objects*. 11th ed. Pearson, 2017. ISBN 978-0-13-474335-6.

#### Especificação

1. O programa deve solicitar ao usuário peso (kg) e altura (m).
```
Digite seu peso em quilogramas: 80
Digite sua altura em metros: 1.85
```
2. O programa deve calcular o Índice de Massa Corporal (IMC) usando a fórmula:
```math
   IMC = {peso (kg) \over altura (m) ^2}
```
4. O programa deve classificar o IMC de acordo [classificação do Ministério da Saúde](https://linhasdecuidado.saude.gov.br/portal/obesidade-no-adulto/definicao-obesidade-no-adulto/indice-massa-corporal/):
* Abaixo do peso: IMC < 18.50
* Eutrófico: 18.5 ≤ IMC < 24.99
* Sobrepeso: 25.0 ≤ IMC < 29.99
* Obesidade grau I: 30.0 ≤ IMC < 34.99
* Obesidade grau II: 35.0 ≤ IMC < 39.99
* Obesidade grau III: IMC ≥ 40.0
5. O programa deve imprimir no console o resultado do cálculo e da classificação
```bash
Seu IMC é: 23.37
Classificação: Eutrófico
```
#### Requisitos de implementação

1. O programa deve contar uma classe com nome CalculadoraIMC
2. A classe deve ter 3 métodos públicos (`public`) e estáticos (`static`): `main`, `calcularIMC` e `classificarIMC`
3. O método *main* deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`)
4. O método `calcularIMC` deve receber dois parâmatros, `peso` e `altura`, ambos do tipo `double` e deve retornar um valor `double`
5. O método `classificarIMC` deve receber um parâmetro, valor do `imc`, do tipo `double` e deve retornar um valor do tipo `String` com a classificação do IMC
6. Utilizar a classe [java.util.Scanner](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Scanner.html) para ler entrada do console
7. Utilizar a classe [System.out](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/System.html#out) para imprimir informações no console
</details>


<details>
<summary>Cálculo da Área de um Polígono Regular</summary>

Referência: [Tarefa aplicada no curso Object-Oriented Programming and Data Structures (CS 2110) da CornellUniversity](https://www.cs.cornell.edu/courses/cs2110/2025sp/assignments/a1_handout.html)

##### Especificação

1. O programa deve calcular a área de um polígono regular
2. O programa deve solicitar ao usuário o número de lados (`n`) e o comprimento do lado (`s`) de um polígono regular, de acordo com o exemplo:

```bash
Digite o número de lados do polígono: 6
Digite o comprimento do lado em metros: 5.0
```
3. A área (`A`) de um polígono regular é calculada utilizando a seguinte fórmula:
\[
A = \frac{1}{4} \times s^2 \times n \times \frac{1}{\tan(\pi / n)}
\]
onde:
- `n` → número de lados do polígono;
- `s` → comprimento de um lado;
- `π` → constante matemática (π ≈ 3.14159), disponível na API do Java [java.lang.Math.PI](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#PI);
- `tan(x)` → função tangente, disponível API do Java [java.lang.Math.tan(double a)](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#tan-double-).
4. A unidade da área resultante será compatível com a unidade da entrada do comprimento do lado (**exemplo: se s for dado em metros, A será em metros quadrados**).
5. O programa deve imprimir no console o resultado do cálculo da área do polígono, conforme exemplo:
```bash
A área do polígono é: 64.95 metros quadrados
```
#### Requisitos de Implementação
1. O programa deve conter uma **classe chamada `CalculadoraPoligono`**.
2. A classe deve possuir **três métodos públicos (public) e estáticos (static)**: `main`, `calcularArea` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularArea`** deve receber dois parâmetros, `n` e `s`, ambos do tipo `double`, e deve retornar um valor `double` representando a área do polígono.
5. O **método `formatarSaida`** deve receber um valor `double` representando a área e retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. Deve-se utilizar a **classe `Math`** para cálculos matemáticos, incluindo a constante `Math.PI` e a função `Math.tan()`.

</details>

<details>
<summary>Mediana de Três</summary>

Referência: [Tarefa aplicada no curso Object-Oriented Programming and Data Structures (CS 2110) da Cornell University](https://www.cs.cornell.edu/courses/cs2110/2025sp/assignments/a1_handout.html)

##### Especificação

1. O programa deve determinar a **mediana** de três números inteiros informados pelo usuário.
2. A mediana de um conjunto de números é o valor que estaria no meio caso os números fossem ordenados. No caso específico da **mediana de três**, é usada em sistemas tolerantes a falhas para decidir qual valor confiar quando há discordância entre sensores ou componentes.
3. O programa deve solicitar ao usuário **três números inteiros**, de acordo com o exemplo:
```bash
Digite o primeiro número: 7
Digite o segundo número: 2
Digite o terceiro número: 5
```
4. O programa deve calcular a mediana utilizando uma **cadeia de declarações condicionais (`if`/`else`)**, possivelmente aninhadas, para determinar o valor central sem ordenar explicitamente os números.
5. O programa deve imprimir no console a mediana dos três números informados, conforme exemplo:
```bash
A mediana dos números é: 5
```

#### Requisitos de Implementação
1. O programa deve conter uma **classe chamada `MedianaDeTres`**.
2. A classe deve possuir **três métodos públicos (public) e estáticos (static)**: `main`, `calcularMediana` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularMediana`** deve receber três parâmetros, `a`, `b` e `c`, todos do tipo `int`, e deve retornar um valor `int` representando a mediana.
5. O **método `formatarSaida`** deve receber um valor `int` representando a mediana e retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. Deve-se utilizar **estruturas condicionais (`if`/`else`)**, sem ordenar explicitamente os números.

</details>


<details>
<summary>Número de Fibonacci</summary>

Referência: [Sequência de Fibonnaci](https://en.wikipedia.org/wiki/Fibonacci_sequence), ver também [Implementações da sequência de Fibonnaci](https://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Fibonacci_Number_Program)

##### Especificação

1. O programa deve calcular o **n-ésimo número da sequência de Fibonacci**.
2. A sequência de Fibonacci é definida da seguinte forma:
   - *`F(0) = 0`
   - `F(1) = 1`
   - `F(n) = F(n-1) + F(n-2)` para *n > 1*
3. O programa deve solicitar ao usuário um número inteiro não negativo (**n**), conforme o exemplo:
```bash
Digite um número inteiro não negativo: 7
```
4. O programa deve calcular o **n-ésimo número de Fibonacci** utilizando uma abordagem eficiente, como:
   - **Iterativa**: Utilizando um loop para calcular o valor.
   - **Recursiva com memoização**: Utilizando recursão e armazenando resultados intermediários para evitar cálculos redundantes.
5. O programa deve imprimir no console o resultado do cálculo, conforme exemplo:
```bash
   O 7º número de Fibonacci é: 13
```

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `Fibonacci`**.
2. A classe deve possuir **três métodos públicos (`public`) e estáticos (`static`)**: `main`, `calcularFibonacci` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularFibonacci`** deve receber um parâmetro `n` do tipo `int` e retornar um valor `long` representando o n-ésimo número de Fibonacci.
5. O **método `formatarSaida`** deve receber um valor `long` representando o número de Fibonacci calculado e retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. Deve-se implementar uma abordagem eficiente para o cálculo da sequência de Fibonacci, evitando a ineficiência da recursão simples.

</details>

```markdown
<details>
<summary>Elefante Visitando o Amigo</summary>

Referência: [Problema do Elefante e os Passos Mínimos](https://codeforces.com/problemset/problem/617/A)

##### Especificação

1. O programa deve calcular o **mínimo número de passos necessários** para um elefante viajar da posição **0** até a posição **x** na linha de coordenadas.
2. O elefante pode dar **passos de tamanho 1, 2, 3, 4 ou 5** em cada movimento.
3. O programa deve solicitar ao usuário um **inteiro positivo `x`** representando a posição da casa do amigo, conforme o exemplo:
```bash
Digite a posição da casa do amigo: 12
```
4. O programa deve calcular a **quantidade mínima de passos** necessários para alcançar `x`.
5. O programa deve imprimir no console o número mínimo de passos, conforme exemplo:
```bash
O número mínimo de passos necessários é: 3
```

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `PassosElefante`**.
2. A classe deve possuir **três métodos públicos (`public`) e estáticos (`static`)**: `main`, `calcularPassosMinimos` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularPassosMinimos`** deve receber um parâmetro `x` do tipo `int` e retornar um valor `int` representando o número mínimo de passos necessários.
5. O **método `formatarSaida`** deve receber um valor `int` representando a quantidade de passos calculada e retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. O programa deve garantir que `x` esteja dentro do intervalo permitido (**1 ≤ x ≤ 1.000.000**).

</details>

<details>
<summary>Senha forte</summary>

Referência: ["Stronger Password"](https://codeforces.com/problemset/problem/1997/A)

##### Especificação

1. O programa deve **fortalecer** a senha adicionando exatamente **uma letra minúscula** do alfabeto latino (`a-z`) em qualquer posição da string.
2. O objetivo é **maximizar o tempo necessário para digitar a senha**. O tempo de digitação é calculado da seguinte forma:
   - **O primeiro caractere leva 2 segundos** para ser digitado.
   - **Cada caractere subsequente** leva:
     - **1 segundo** se for **igual ao caractere anterior**.
     - **2 segundos** se for **diferente do caractere anterior**.
3. O programa deve solicitar ao usuário uma **senha**, conforme o exemplo:
```bash
Digite a senha: a
```
4. O programa deve **inserir uma letra minúscula em qualquer posição** para **maximizar o tempo total de digitação**.
5. O programa deve imprimir no console a **nova senha**, conforme exemplo:
```bash
Senha fortalecida: wa
```

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `FortalecerSenha`**.
2. A classe deve possuir **três métodos públicos (`public`) e estáticos (`static`)**: `main`, `fortalecerSenha` e `calcularTempoDigitacao`.
4. O **método `fortalecerSenha`** deve receber um parâmetro `s` do tipo `String` e retornar um `String` representando a senha fortalecida.
5. O **método `calcularTempoDigitacao`** deve receber uma senha e retornar um `int` representando o tempo de digitação.
6. O programa deve garantir que:
   - **1 ≤ |s| ≤ 10** (comprimento da senha original).
   - Apenas caracteres **minúsculos do alfabeto latino (`a-z`)** sejam inseridos.
7. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
8. O algoritmo deve **testar diferentes posições e caracteres** para encontrar a inserção ótima.

</details>