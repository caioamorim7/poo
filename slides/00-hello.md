---
layout: frontcover
transition: none
title: IDP - POO
id: aula00
lesson: Primeiro contato com Java e testes automatizados
goals:
  - Compilar e executar o programa HelloWorld no terminal
  - Verificar a saída do programa com um teste automatizado JUnit
  - Entender a estrutura mínima de um projeto Java simples
---

---
layout: default
lesson: HelloWorld via terminal
---

## Para começar

- O diretório `lectures/examples/00-hello` contém um projeto Java enxuto
- Arquivos principais:
  - `src/HelloWorld.java`: classe com método `main`
  - `test/HelloWorldTest.java`: teste automatizado com JUnit 5
- Objetivo: compilar, executar e garantir que a saída está correta

---

## Código-fonte principal

```java
// lectures/examples/00-hello/src/HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

- Compilar: `javac src/HelloWorld.java`
- Executar: `java -cp src HelloWorld`
- Saída esperada: `Hello, World!`

---

## Teste automatizado

```java
// lectures/examples/00-hello/test/HelloWorldTest.java
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final PrintStream originalOut = System.out;

@BeforeEach
void redirectStandardOutput() {
    System.setOut(new PrintStream(outContent));
}

@AfterEach
void restoreStandardOutput() {
    System.setOut(originalOut);
}

@Test
void testMain() {
    HelloWorld.main(null);
    assertEquals("Hello, World!\n", outContent.toString());
}
```

- Executar testes com `mvn test` ou ferramenta da IDE
- Técnica de redirecionamento captura `System.out`

---
layout: backcover
---
