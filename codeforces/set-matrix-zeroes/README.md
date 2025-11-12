Problema: Zerar uma Matriz

Dada uma matriz, mat, se algum elemento da matriz for zero, defina essa linha e coluna como zero. As operações realizadas devem ser feitas diretamente na matriz original, ou seja, a matriz original deve ser modificada sem alocar outra matriz.

Restrições:

1 ≤ 1 ≤ mat.row, mat.col ≤ 20 ≤ 20

−231 ≤ −231 ≤ mat[i][j] ≤ 231 − 1 ≤ 231 − 1


* Criar diretório para armazenar as dependências
 ```bash
 mkdir -p lib
 ```
* Baixar o junit
```bash
 curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
```
* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.
```bash
 javac -cp "lib/*" -d bin src/*.java ../../test/*.java
 ```
 * Executar testes unitários e verificar o resultado no console
 ```bash
 java -jar lib/junit-platform-console-standalone-1.11.4.jar execute --class-path bin --scan-class-path
 ```