# ☕ Programação Orientada a Objetos com Java

Seja bem-vindo(a)! 🤗

Este repositório reúne materiais, tarefas, projetos, leituras e referências bibliográficas da disciplina **Programação Orientada a Objetos**, oferecida no **[Instituto Brasileiro de Ensino, Desenvolvimento e Pesquisa](http://idp.edu.br)** e ministrada pelo professor **[Fabricio Santana](https://github.com/fabriciosantana/)** no **1º semestre de 2025**. 👨🏾‍🏫

Aqui, você encontrará conteúdos essenciais para seu aprendizado, incluindo slides, exemplos de código, tutoriais, referências e exercícios práticos, que ajudarão a aprofundar sua compreensão da programação orientada a objetos em Java. 📚

Durante o curso, serão abordados tópicos fundamentais, como introdução à programação, classes, objetos, herança, polimorfismo, encapsulamento e persistência, além de outros conceitos essenciais para a construção de aplicações robustas e escaláveis. 💻

Utilize este material como um recurso adicional para fortalecer seus conhecimentos e aprimorar suas habilidades na linguagem Java. 🌟

Vamos começar! 🎉

## 📚 Referências importantes
- [Plano de ensino](http://www.google.com) (oficial)
- [Aulas]()
- [Leituras]()
- [Atividades]()
- [Projetos]()
- [Referências]()

## 📌 Antes de começar

Para executar os códigos de exemplo, realizar as atividades práticas e desenvolver o projeto, é essencial ter um computador e configurá-lo com as ferramentas apropriadas.

A escolha do **[computador](https://en.wikipedia.org/wiki/Computer)** e do **[sistema operacional](https://en.wikipedia.org/wiki/Operating_system)** pode impactar significativamente sua experiência no desenvolvimento de softwares.

Para programar em **[Java](https://en.wikipedia.org/wiki/Java_(programming_language))**, não é necessário um computador de alto desempenho, mas recomenda-se um processador moderno, com pelo menos **16 GB de RAM** e um SSD para garantir melhor desempenho na compilação e execução dos programas. 

Quanto ao sistema operacional, o **[Linux](https://en.wikipedia.org/wiki/Linux)** é amplamente utilizado por desenvolvedores devido à sua compatibilidade com ferramentas open-source e ambientes de desenvolvimento, mas o **[Windows](https://en.wikipedia.org/wiki/Microsoft_Windows)** e **[macOS](https://en.wikipedia.org/wiki/MacOS)** também oferecem suporte completo para Java. 

Como será apresentado, independentemente do sistema operacional escolhido, seu código poderá ser executado em qualquer outro sistema operacional que possua um ambiente Java devidamente configurado com a **[Java Virtual Machine](https://en.wikipedia.org/wiki/Java_virtual_machine)** geralmente por meio do **[Java Development Kit (JDK)](https://en.wikipedia.org/wiki/Java_Development_Kit)**. Isso ocorre porque o **[Java é uma linguagem multiplataforma](https://en.wikipedia.org/wiki/Cross-platform_software)**, permitindo que programas escritos em Java sejam executados sem modificações em diferentes sistemas operacionais. 

Caso esteja utilizando o Windows, uma alternativa prática para desenvolver em um ambiente Linux é o **[Windows Subsystem for Linux (WSL)](https://en.wikipedia.org/wiki/Windows_Subsystem_for_Linux)**, que permite rodar distribuições Linux diretamente no Windows com desempenho quase nativo. Outra opção é utilizar um **container de desenvolvimento na nuvem**, como o **[GitHub Codespaces](https://docs.github.com/codespaces/overview)**, garantindo um ambiente isolado, portátil e fácil de configurar, sem a necessidade de instalar todas as dependências no sistema operacional principal.

Além de um computador e um sistema operacional, para desenvolvier software em Java, é necessário instalar uma distribuição do **[Java Development Kit (JDK)](https://en.wikipedia.org/wiki/Java_Development_Kit)**. Há várias distribuições do JDK disponíveis, este respositório utiliza **[OpenJDK](https://en.wikipedia.org/wiki/OpenJDK)**, versão 21.

Embora seja possível desenvolver programas em Java utilizando qualquer **[editor de texto](https://en.wikipedia.org/wiki/Text_editor)** e um **[terminal](https://en.wikipedia.org/wiki/Terminal_emulator)**, recomenda-se o uso de um **[Ambiente de Desenvolvimento Integrado (Integrated Development Environment - IDE)](https://en.wikipedia.org/wiki/Integrated_development_environment)**. As IDEs tornam o desenvolvimento mais eficiente ao oferecer funcionalidades como edição avançada de código, compilação, testes, depuração, geração de pactoes e uma interface gráfica intuitiva.

Existem diversas IDEs para programação em Java no mercado, todas compatíveis com o código deste repositório. No entanto, recomenda-se a utilização do **[Visual Studio Code (VS Code)](https://code.visualstudio.com/)** devido à sua simplicidade, flexibilidade, extensibilidade e possibilidade de execução online, sem necessidade de instalação. Além disso, o VS Code oferece integração nativa com o **[GitHub Codespaces](https://github.com/features/codespaces)**, tornando o ambiente de desenvolvimento ainda mais acessível e eficiente.

Desenvolver software é um processo contínuo que exige colaboração e organização, frequentemente envolvendo vários desenvolvedores ao longo do tempo. Para gerenciar versões do código, facilitar o trabalho em equipe e manter um histórico estruturado das alterações, este repositório adota o **[Git](https://git-scm.com/)**, um sistema de controle de versão distribuído amplamente adotado. O Git permite acompanhar mudanças no código, trabalhar em diferentes ramificações e sincronizar o projeto com repositórios remotos, como o **[GitHub](https://github.com/)**.

Finalizada as devidas introduções, vamos seguir para a instalação das ferramentas.

---

### 🐧 Instalação do OpenJDK 21 no Linux via apt-get

1. Acesse o site oficial:  
   🔗 [Download Java JDK 21 - Oracle](https://www.oracle.com/java/technologies/downloads/?er=221886)  
2. Escolha a versão compatível com seu sistema operacional (Windows, Mac, Linux).
3. Baixe e execute o instalador.
4. Após a instalação, verifique se está funcionando abrindo um terminal e digitando:  
   ```bash
   java -version




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

### Compreender com variables, keywords, data type, declaration statement, expression e tipos primitivos

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

## Compilar, empacotar, decompilar e executar programa java na linha de comando

javac -cp "lib/*" -d bin src/*.java test/*.java

java -cp bin/ HelloWorld

java -cp bin/ HelloStudent

java -jar lib/junit-platform-console-standalone-1.11.4.jar execute --class-path target --scan-class-path

jar --create --file bin/HelloWorld.jar --main-class HelloWorld -C bin/ HelloWorld.class

java -jar bin/HelloWorld.jar

javap -cp bin/ -c HelloWorld