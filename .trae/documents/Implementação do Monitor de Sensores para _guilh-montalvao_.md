## Objetivo
Implementar uma solução completa seguindo o README, criando as classes e o app de console na pasta `submissions/guilh-montalvao`, com validações, exceções personalizadas e mensagens em português.

## Arquitetura e Arquivos
- `SensorReading`: representa uma leitura (`sensorId: String`, `temperature: double`).
- `InvalidReadingException extends Exception`: indica erro na entrada.
- `SensorNotFoundException extends Exception`: indica ausência de leituras para um sensor.
- `SensorMonitor`: valida e armazena leituras, calcula médias.
- `SensorMonitorApp`: `main` que interage via terminal.
- Armazenamento: `Map<String, List<Double>> readingsBySensor` para cálculo eficiente de médias por sensor.
- Contadores: `validCount` e `invalidCount` mantidos no `SensorMonitor`.

## Assinaturas
- `public void addReading(String line) throws InvalidReadingException`
- `public double averageFor(String sensorId) throws SensorNotFoundException`
- `public int getValidCount()`
- `public int getInvalidCount()`
- (Opcional) `public int getTotalReadings()` somando tamanhos das listas no `Map`.

## Regras de Validação em addReading
1. Separação: `String[] parts = line.split(";")` e `trim()` em cada parte.
2. Formato: `parts.length == 2`.
3. `sensorId` não vazio após `trim()`.
4. Temperatura: converter `tempStr` para `double` aceitando vírgula (`tempStr.replace(',', '.')`).
5. Faixa: valor dentro de `[-30.0, 55.0]` inclusivo.
6. Em caso de falha em qualquer regra, lançar `InvalidReadingException` com mensagem clara.
7. Em sucesso: armazenar em `readingsBySensor.computeIfAbsent(sensorId, ...)` e incrementar `validCount`.

## Cálculo de Média em averageFor
- Buscar lista por `sensorId` exatamente como foi inserido (sem alterar caixa).
- Se lista inexistente ou vazia, lançar `SensorNotFoundException` com mensagem clara.
- Caso exista, calcular média via soma/size.

## Fluxo do Console (SensorMonitorApp)
1. Criar `SensorMonitor` e `Scanner` em `try-with-resources`.
2. Loop de coleta: ler linhas até `"FIM"` (case-insensitive), ignorando vazias.
3. Para cada linha: `try { monitor.addReading(line); } catch (InvalidReadingException e) { imprimir motivo e seguir; }` (incremento de inválidas já ocorre dentro do monitor).
4. Após encerrar a coleta: exibir contagem de válidas e inválidas.
5. Consulta de média: perguntar um `sensorId`, chamar `monitor.averageFor(sensorId)` em `try/catch`.
6. `finally`: imprimir sempre `"Programa encerrado."`.

## Mensagens ao Usuário
- Erros de formato: `"Formato inválido. Use SENSOR_ID;TEMPERATURA_EM_CELSIUS."`
- ID vazio: `"Identificador do sensor não pode ser vazio."`
- Número inválido: `"Temperatura deve ser um número válido."`
- Faixa: `"Temperatura deve estar entre -30°C e 55°C."`
- Sensor sem leituras: `"Não há leituras para o sensor \"<id>\"."`
- Resumo: `"Leituras válidas: <n> | Leituras ignoradas por erro: <m>"`
- Encerramento: `"Programa encerrado."`

## Convenções
- `sensorId` tratado como `String` (padrão predominante nas submissões).
- Sem comentários no código, nomes claros e mensagens em português.
- Normalização mínima: `trim()` em entradas; não alterar caixa ao armazenar/buscar.

## Verificação
- Testes manuais: inserir linhas válidas e inválidas, limites `-30` e `55`, número com vírgula, e múltiplas leituras por mesmo sensor; confirmar contagens e médias.

## Próximo Passo
Posso implementar agora na pasta `submissions/guilh-montalvao` criando os arquivos acima, seguindo exatamente este plano?