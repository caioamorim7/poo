# poo
Repositório para projetos da disciplina Programação Orientada a Objetos


# Configuração do ambiente

## Instalar java
https://www.oracle.com/java/technologies/downloads/?er=221886
https://jdk.java.net/java-se-ri/21

sudo apt update

sudp apt install -y openjdk-21-jdk

## Verificar instalação do java

java -version

## Instalar sdkman (opcional)
https://sdkman.io/install

> curl -s "https://get.sdkman.io" | bash

> sdk update

> sdk list java

> sdk current java

> sdk install java 21.0.2-open

Downloading: java 21.0.2-open

In progress...

################################################################################################################################################ 100.0%

Repackaging Java 21.0.2-open...

Done repackaging...

Installing: java 21.0.2-open
Done installing!

Do you want java 21.0.2-open to be set as default? (Y/n): Y

Setting java 21.0.2-open as default.

## Executar JShell 

https://docs.oracle.com/en/java/javase/21/jshell/introduction-jshell.html
Instalado por padrão a partir do JDK 9
JShell = Read-Eval-Print-Loop (REPL)

> jshell

> jshell> \help

> jshell> \help intro

> jshell> \help list

## Executar primeiro código Java no JShell

> jshell

> jshell> System.out.println("Hello World!");

## Introdução a linguagem java

https://docs.oracle.com/javase/specs/jls/se21/html/index.html

### Compreender com variables, keywords, data type, declaration statement e expression

> jshell> int a = 1;
> jshell> int b = 1;
> jshell> int c = a + b;

> jshell> int x = (10 + 5) + (2 * 10);
> jshell> int y = 12;
> jshell> int z = 6;

> jshell> int w = x + y + z;

> jshell> /var

> jshell> /list

> jshell> int p = 1000 - w;

> jshell> System.out.print(p)

> jshell> { 
    int d = 1;
    int e = 1;
    int f = d + e;
}

> jshell> /exit



## Criar primeiro programa Java

> jshell

> jshell> System.out.println("Hello World!");

> jshell> System.out.println("Hello Fabricio!");

> jshell> String name = "Fabricio";

> jshell> System.out.println("Hello " + name + "!");

> jshell> public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello World!");
    }
}

> jshell> HelloWorld h = new HelloWorld();

> jshell> h.main(null);

## Executar programa java na linha de comando

java

## Compreender com tipos primitivos
