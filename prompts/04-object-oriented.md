# Orientação a Objetos em Java

## Classes e Objetos

* Explique o que são classes e objetos em Java e descreva o ciclo de vida de um objeto (criação, uso e descarte pelo garbage collector).
* Modele uma classe simples representando uma entidade real (ex.: `Aluno`), destacando atributos, métodos e construtores necessários.
* Gere um exemplo completo em Java que instancia objetos, chama métodos e imprime estados, justificando a escolha de cada membro da classe.
* Apresente más práticas (ex.: abuso de atributos `public`) e como evitá-las melhorias.
* Simule um cenário em que objetos representam registros de um sistema escolar e discuta como garantir consistência dos dados.
* Reflita: por que compreender o ciclo de vida e o estado de objetos é fundamental para evitar bugs em aplicações Java?

---

## Encapsulamento e Modificadores de Acesso

* Defina encapsulamento e explique o papel dos modificadores `public`, `private`, `protected` e o acesso padrão (package-private).
* Construa um exemplo de classe com atributos privados e métodos `get`/`set`, detalhando como validar dados antes de alterar o estado.
* Compare encapsulamento tradicional com o uso de `record` em Java moderno, discutindo benefícios e limitações.
* Apresente um exemplo de uma classe mal encapsulada e outra que faz uso correto de encapsulamento, aplicando princípios de imutabilidade quando apropriado.
* Simule uma auditoria de segurança que identifica vazamento de estado interno e peça a correção usando cópias defensivas.
* Como o encapsulamento colabora com a manutenção, testes e evolução de sistemas orientados a objetos?

---

## Herança e Polimorfismo

* Explique a relação "é-um" da herança em Java e como declarar classes base e derivadas.
* Diferencie sobrecarga (compile-time) e sobrescrita (runtime), fornecendo exemplos que imprimem traços para evidenciar o polimorfismo dinâmico.
* Apresente exemplo de implementação de hierarquias simples (ex.: `Veiculo`, `Carro`, `Moto`) com métodos sobrescritos e uso de `@Override`.
* Analise um caso de herança inadequada e proponha alternativas como composição, justificando a mudança.
* Simule um cenário onde polimorfismo permite tratar listas heterogêneas e discuta impactos em testes e manutenção.
* Quais sinais indicam que a hierarquia de classes precisa ser redesenhada para evitar fragilidade?

---

## Abstração e Interfaces

* Defina abstração e explique quando usar classes abstratas em contraste com interfaces.
* Mostre como declarar métodos abstratos e fornecer implementações concretas, incluindo uso de `abstract` e `final` corretamente.
* Apresente exemplos de interfaces com métodos padrão (`default`) e estáticos, discutindo como ampliam possibilidades sem quebrar compatibilidade.
* Simule um caso em que múltiplas interfaces são combinadas para descrever capacidades e explique como resolver conflitos de métodos padrão.
* Como abstração ajuda a reduzir acoplamento e facilita testes por meio de injeção de dependências?

---

## Design Orientado a Objetos e Boas Práticas

* Explique os pilares da POO (abstração, encapsulamento, herança, polimorfismo) e como eles interagem no design de sistemas Java.
* Introduza princípios SOLID, apresente exemplos para cada princípio e exemplos de violações em um trecho de código dado.
* Crie um estudo de caso de refatoração que utilize composição e interfaces para melhorar flexibilidade.
* Discuta estratégias de testes unitários em classes orientadas a objetos, incluindo uso de mocks e interfaces para isolar dependências.
* Que métricas e rituais de revisão ajudam a garantir que o design orientado a objetos permaneça sustentável ao longo do tempo?
