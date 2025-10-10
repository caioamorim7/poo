### Tratamento de Exceções

Nesta atividade você construirá um monitor interativo que recebe leituras de sensores via terminal, valida os dados e informa estatísticas enquanto comunica erros por meio de exceções personalizadas.

---

#### Cenário

O campus possui sensores que reportam temperatura. A equipe operacional digita manualmente as leituras em um console durante a manutenção. O monitor deve:

1. Receber leituras no formato `SENSOR_ID;TEMPERATURA_EM_CELSIUS` até que o operador digite `FIM`.
2. Validar cada leitura e armazenar apenas as válidas.
3. Permitir consulta da média de temperatura por sensor com tratamento adequado caso o sensor não exista.
4. Destacar leituras críticas (temperaturas muito altas) para ação imediata.

---

#### Especificação

1. Na inicialização, o programa exibe instruções e cria um `Scanner` para ler do `System.in`.
2. Em um loop, leia cada linha digitada:
   - Se o usuário informar `FIM`, encerre a coleta.
   - Quebre o texto em duas partes separadas por `;`. Ver [`split`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#split(java.lang.String))
   - Garanta que o `sensorId` **não** esteja vazio.
   - Converta a temperatura para `double` e valide se está entre **-30 °C e 55 °C**.
3. Caso alguma validação falhe, lance uma exceção **checada** `InvalidReadingException` contendo a mensagem de erro e o valor recebido. Capture a exceção no `main`, mostre uma mensagem amigável e continue o loop sem armazenar a leitura inválida.
4. Armazene as leituras válidas em uma coleção (lista ou `Map<String, List<SensorReading>>`).
5. Após encerrar a coleta, exiba:
   - Quantidade total de leituras aceitas.
   - Número de leituras descartadas por erro (conteúdo da exceção capturada).
   - Leituras críticas (`>= 45 °C`) com identificação do sensor.
6. Permita que o usuário consulte a média de temperatura informando um `sensorId`:
   - Caso o sensor exista, retorne a média com duas casas decimais.
   - Se não houver leituras para o sensor, lance a exceção **checada** `SensorNotFoundException`. Capture-a no `main` e informe que não há dados para o sensor solicitado.
7. Utilize multi-catch para tratar `InvalidReadingException`, `NumberFormatException` e outras exceções previsíveis em pontos apropriados.
8. Garanta que o programa sempre exiba `Programa encerrado.` no final, utilizando um bloco `finally` que será executado independente de sucesso ou falha.

---

#### Requisitos de Implementação
1. Crie as classes obrigatórias:
   - `SensorReading` com `sensorId` e `temperature`.
   - `InvalidReadingException extends Exception` com construtores que aceitem mensagem e valor inválido.
   - `SensorNotFoundException extends Exception`.
   - `SensorMonitor` com métodos:
     - `void addReading(String rawInput) throws InvalidReadingException`
     - `double averageFor(String sensorId) throws SensorNotFoundException`
     - `List<SensorReading> criticalReadings()`
   - `SensorMonitorApp` contendo o `main` com toda a interação de leitura e menu.
2. Faça uso explícito de:
   - Blocos `try-catch-finally` envolvendo o `Scanner`.
   - Multi-catch para diferenciar mensagens de erro ao usuário.
   - Lançamento manual de exceções customizadas (`throw new InvalidReadingException(...)`).
3. Evite deixar exceções checadas sem tratamento direto no `main`. Sempre traduza ou informe o contexto antes de mostrar a mensagem ao operador.
4. Escreva mensagens claras em português orientando a correção do dado inválido.
