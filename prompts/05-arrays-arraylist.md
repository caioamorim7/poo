# Arrays e ArrayList em Java

## Arrays unidimensionais

* Explique como declarar, instanciar e inicializar arrays unidimensionais em Java, incluindo os valores padrão atribuídos pela JVM.
* Mostre como acessar elementos, percorrer com laços `for` e `enhanced for`, e evitar erros como `ArrayIndexOutOfBoundsException`.
* Crie exercícios para que o aluno manipule arrays (inversão, busca, contagem de ocorrências) usando apenas recursos básicos da linguagem.
* Simule um processo de depuração em que um array não é inicializado corretamente e oriente a correção passo a passo com `jshell`.
* Solicite a implementação de um algoritmo simples (ex.: cálculo de média) e peça para discutir como tratar arrays vazios ou nulos.
* Reflita: por que arrays continuam úteis em Java mesmo com a disponibilidade de coleções mais flexíveis?

---

## Arrays multidimensionais e utilitários

* Descreva a sintaxe de arrays multidimensionais (`int[][]`) e diferencie arrays retangulares de arrays irregulares.
* Peça exemplos que preencham e percorram matrizes, mapeando índices para posições lógicas (linhas, colunas).
* Demonstre o uso da classe `java.util.Arrays` (`sort`, `fill`, `copyOf`, `binarySearch`, `toString`) aplicando cada método em arrays reais.
* Crie exercícios onde o aluno transforma uma matriz em lista de valores e vice-versa, discutindo usos em algoritmos.
* Simule um caso de uso que calcule tabelas (ex.: notas de alunos) explorando métodos utilitários para análise.
* Reflita: quais armadilhas surgem ao trabalhar com arrays multidimensionais e como evitá-las em projetos maiores?

---

## ArrayList e Coleções Dinâmicas

* Explique o que é a classe `ArrayList`, como declará-la com generics e como ela armazena elementos internamente.
* Demonstre operações básicas (`add`, `get`, `set`, `remove`, `size`, `isEmpty`) e iteração usando laços e `Iterator`.
* Gere exercícios que peçam a simulação de listas dinâmicas (ex.: carrinho de compras) enfatizando validação de entradas.
* Mostre como lidar com `ArrayList` de objetos personalizados, incluindo sobrescrita de `equals` e `hashCode` quando relevante.
* Simule um cenário em que alterações concurrentes causam `ConcurrentModificationException` e apresente estratégias de prevenção.
* Reflita: como o `ArrayList` se integra ao restante do framework Collections em Java?

---

## Comparando Arrays e ArrayList

* Elabore uma tabela comparativa entre arrays e `ArrayList`, destacando diferenças de tamanho, tipos suportados, desempenho e flexibilidade.
* Demonstre como converter de array para `ArrayList` e vice-versa usando `Arrays.asList`, `List.of`, `toArray` e construtores apropriados.
* Crie exercícios em que o aluno escolha a estrutura adequada para diferentes requisitos (memória fixa, inserções frequentes, acesso randomico).
* Analise casos em que arrays primitivos são preferíveis por desempenho e situações em que a flexibilidade do `ArrayList` compensa.
* Simule uma refatoração que substitui arrays por `ArrayList` e discuta impactos em APIs públicas e compatibilidade.
* Reflita: quais critérios guiam a decisão entre arrays e listas no design de uma aplicação Java?

---

## Aplicações práticas e desempenho

* Proponha um mini projeto que utilize arrays e `ArrayList` em conjunto (ex.: processamento de notas e geração de relatórios).
* Explore técnicas de otimização de performance (pré-alocação de arrays, `ensureCapacity` em `ArrayList`, perfis de acesso a dados).
* Crie exercícios que avaliem a complexidade temporal de operações típicas em arrays e `ArrayList`.
* Simule testes unitários cobrindo casos de borda (listas vazias, inserções massivas, valores nulos) e discuta como assegurar robustez.
* Solicite a elaboração de um estudo de caso em que a escolha da estrutura incorreta gera gargalos e mostre como corrigi-los.
* Reflita: como medições empíricas (benchmarks) embasam decisões de estrutura de dados em aplicações Java reais?
