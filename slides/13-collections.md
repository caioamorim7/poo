---
layout: frontcover
transition: none
title: IDP - POO
id: aula13
lesson: Coleções da biblioteca padrão
goals:
  - Escolher coleções adequadas para mapas, conjuntos, filas e listas
  - Explorar algoritmos utilitários em `Collections`
  - Iterar elementos usando `Iterator`, `forEach` e `Spliterator`
---

---
layout: default
lesson: Mapas e conjuntos
---

## `Map` e `Set`

```java
// HashMapDemo.java
Map<String, Double> accounts = new HashMap<>();
accounts.put("John Doe", 3434.34);
accounts.put("Jane Baker", 1378.00);

for (Map.Entry<String, Double> entry : accounts.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
double balance = accounts.get("John Doe");
accounts.put("John Doe", balance + 1000);
```

- `HashMap`: acesso `O(1)` médio, ordem não garantida
- `TreeSet` mantém elementos ordenados automaticamente (`TreeSetDemo`)
- `SetHashSetDemo`, `SetLinkedHashSetDemo` mostram diferenças de ordenação
- Interfaces principais: `Collection`, `List`, `Set`, `Map`, `Queue`
- Escolha baseia-se em ordenação, unicidade e custo de operações

---

## Filas e pilhas

```java
// PriorityQueueTest.java
PriorityQueue<Double> queue = new PriorityQueue<>();
queue.offer(3.2);
queue.offer(9.8);
queue.offer(5.4);

while (!queue.isEmpty()) {
    System.out.printf("%.1f ", queue.poll());
}
```

- `PriorityQueue` devolve o menor elemento primeiro (ordem natural)
- `ArrayDequeDemo` compara deque com pilha/fila
- Escolha estrutura conforme necessidade de prioridade ou dupla extremidade
- Filas seguem política FIFO; pilhas usam LIFO
- Prefira `Deque` para pilhas modernas ao invés de `Stack`

---

## Algoritmos utilitários

```java
// CollectionsAlgorithmsDemo.java
LinkedList<Integer> numbers = new LinkedList<>();
numbers.add(-8);
numbers.add(20);
numbers.add(-20);
numbers.add(8);

Collections.sort(numbers, Collections.reverseOrder());
Collections.shuffle(numbers);
System.out.println("Minimum: " + Collections.min(numbers));
System.out.println("Maximum: " + Collections.max(numbers));
```

- `Collections.binarySearch` exige lista ordenada
- `Collections.frequency`, `disjoint`, `addAll` simplificam operações comuns
- Explore `CollectionsReverseCopyFillMaxMinTest` para copiar, preencher e inverter listas
- `Comparator` customiza critérios; `Comparable` define ordem natural
- Métodos utilitários operam sobre interfaces, não implementações concretas

---

## Iteradores e streams

- `IteratorDemo`, `IteratorForEachDemo`: mostram uso explícito de `Iterator`
- `ListLinkedListIteratorTest`: demonstra `ListIterator` bidirecional
- `SpliteratorDemo`: divide a coleção para processamento paralelo
- Prefira `forEach` ou streams quando a legibilidade for melhor
- *Fail-fast iterators* disparam `ConcurrentModificationException` em alterações indevidas
- Streams permitem operações declarativas (`filter`, `map`, `reduce`) sobre coleções

---
layout: backcover
---
