### Tratamento de Exceções em Java

#### Introdução ao Tratamento de Exceções
```
Explique o que é uma exceção em Java e por que o tratamento de exceções é considerado uma abordagem eficaz para lidar com problemas em tempo de execução.  
  
Em seguida, mostre um exemplo prático de um código Java que gera uma exceção (como divisão por zero) e explique como o programa se comporta sem tratamento.
```

#### Uso do bloco `try`
```
Mostre como usar o bloco `try` para delimitar um trecho de código que pode gerar uma exceção em Java.  

Apresente um exemplo prático onde se tenta abrir um arquivo para leitura usando `FileReader` dentro de um bloco `try`.
```

#### Uso da palavra-chave `throw`
```
Explique como e por que usamos a palavra-chave `throw` em Java.  
  
Dê um exemplo prático onde um método verifica se uma idade é negativa e, nesse caso, **lança** uma `IllegalArgumentException` usando `throw`.
```

#### Uso do bloco `catch`
```
Mostre como usar o bloco `catch` para capturar e tratar exceções em Java.  
  
Apresente um exemplo prático que simule uma divisão por zero, capture a exceção `ArithmeticException`, e exiba uma mensagem amigável para o usuário.
```

#### Quando usar tratamento de exceções
```
Explique em que situações o tratamento de exceções é apropriado, e quando **não** é a melhor escolha (por exemplo, em erros de lógica que deveriam ser evitados em tempo de compilação).  
  
Apresente dois exemplos em Java: um cenário correto de uso de exceções, e um cenário onde seria melhor prevenir o erro ao invés de capturar uma exceção.
```

#### Hierarquia de Classes de Exceção
```
Descreva a hierarquia de classes de exceção em Java, explicando a diferença entre `Exception`, `RuntimeException` e `Error`.  
 
Mostre exemplos práticos de cada um desses tipos para ilustrar seu uso.
```

#### Uso do bloco `finally`
```
Explique o propósito do bloco `finally` em Java.  
 
Apresente um exemplo prático onde um arquivo é aberto para leitura e o bloco `finally` é usado para garantir que o arquivo seja fechado, independentemente de ocorrer uma exceção.
```

#### Encadeamento de Exceções (Chaining)
```
Explique como capturar uma exceção e lançar outra exceção diferente em Java, mantendo a causa original (encadeamento de exceções).  
  
Mostre um exemplo prático onde uma `NumberFormatException` capturada gera uma nova `IllegalArgumentException`, encadeando as exceções.
```

#### Criação de Exceções Definidas pelo Usuário
```
Explique como criar uma exceção personalizada (user-defined exception) em Java, estendendo a classe `Exception`.  
  
Apresente um exemplo prático de uma exceção chamada `SaldoInsuficienteException` que é lançada quando um método de saque detecta saldo insuficiente.
```

#### Uso de `assert`
```
Explique a funcionalidade da palavra-chave `assert` em Java.  
  
Mostre um exemplo prático em que um método utiliza `assert` para verificar se um parâmetro não é nulo, e explique como habilitar a execução de assertivas na JVM.
```

#### `try-with-resources`
```
Explique o que é o recurso `try-with-resources` em Java e em que situações ele deve ser utilizado.  
  
Apresente um exemplo prático que use `try-with-resources` para abrir um arquivo de texto usando `BufferedReader` e garantir o fechamento automático do recurso.
```