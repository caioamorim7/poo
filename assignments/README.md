## Atividades práticas de programação em java

### Instruções gerais para entrega das atividades
* Realizar fork do repositório da disciplina
* Criar um diretório com seu nome e sobrenome dentro do diretório da atividade, conforme exemplo abaixo(o nome de último diretório por seu nome e sobrenome):
```
mkdir poo/assignments/00-hello/fabricio-santana  
```
* Desenvolver programa Java dentro do seu diretório
* Atender os resuitivos da especificação e os requisitos de implementação
* Enviar um pull request
* Observar se os testes do pull request foi bem sucedido nos testes
* Submeter link do pull request no [ambiente virtual](https://ambientevirtual.idp.edu.br/)
* Cumprir prazo de entrega

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
2. A classe deve ter 3 métodos públicos (_public_) e estáticos (_static_): *main*, *calcularIMC* e *classificarIMC*
3. O método *main* deve receber um parâmetro do tipo _String[]_ e não retornar nenhum valor (_void_)
4. O método *calcularIMC* deve receber dois parâmatros, *peso* e *altura*, ambos do tipo double e deve retornar um valor _double_
5. O método *classificarIMC* deve receber um parâmetro, valor do *imc*, do tipo double e deve retornar um valor do tipo _String_ com a classificação do IMC
6. Utilizar a classe [java.util.Scanner](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Scanner.html) para ler entrada do console
7. Utilizar a classe [System.out](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/System.html#out) para imprimir informações no console
</details>
