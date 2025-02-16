## Atividades práticas de programação em java

<details>
<summary>Instruções gerais para entrega das atividades</summary>

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

</details>

<details>
<summary>Instruções para testes locais das atividades</summary>

Cada atividade é acompanhada de testes unitários. Para avaliar seu código antes de submetê-lo, execute os seguintes comandos a partir de seu diretório pessoal de cada atividade
 ```bash
 mkdir -p lib

 curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar

 javac -cp "lib/*" -d bin src/*.java ../../test/*.java
 
 java -jar lib/junit-platform-console-standalone-1.11.4.jar --class-path bin --scan-class-path
 ```
</details>

<details>
<summary>Compilar, empacotar, decompilar e executar programa java na linha de comando</summary>

Execute os comandos abaixo para compilar, empacotar, decompilar e executar programa java na linha de comando 

```bash
javac -cp "lib/*" -d bin src/*.java test/*.java

java -cp bin/ HelloWorld

java -jar lib/junit-platform-console-standalone-1.11.4.jar execute --class-path target --scan-class-path

jar --create --file bin/HelloWorld.jar --main-class HelloWorld -C bin/ HelloWorld.class

java -jar bin/HelloWorld.jar

javap -cp bin/ -c HelloWorld
```

</details>

<details> 
<summary>Lista de atividades</summary>

|Semana| Atividades |
|---|---|
| 1 | [Hello, World!](./00-hello) |
| 2 | [Calculadora de índice de massa corporal (IMC)](./01-imc)|
|   | [Calculadora da Área de um Polígono Regular](./02-area) |
|   | [Sequência de Fibonnaci](./03-fibonacci) |
|   | [Elefante visitando amigo](./04-elephant) |
|   | [Senha forte](./05-password) |
| 3 | [Calculadora de frequência cardíaca alvo](./06-heart) |
|   | [Registro de saúde digital](./07-health) |
|   |  teste |
|   |   |
|   |   |

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