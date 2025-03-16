### Savings Account  

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

---

### Especificação

1. O programa deve criar duas contas poupança com saldo inicial `2000.00`e `3000.00`
1. O programa deve configurar a taxa de juros anual para 4%
1. O programa deve imprimir, calcular e exibir os saldos atualizados para cada mês ao longo de 12 meses.
```

```
1. O programa deve atualizar a taxa de juros anual para 5%
1. Após os 12 meses, o programa deve modificar a taxa de juros anual para `5%`, calcular o próximo mês de juros e imprimir os novos saldos de ambas as contas.
```

```

---

### Requisitos de Implementação

1. O programa deve conter uma classe chamada `SavingsAccount` e outra chamada `SavingsAccountApp`.
1. A classe `SavingsAccount` deve conter:
    - Um atributo privado `savingsBalance` (`double`): Representa o saldo atual do titular da conta.
    - Um atributo de classe (`static`) `annualInterestRate` (`double`): Representa a taxa de juros anual aplicada a todas as contas.
    - Um construtor que recebe `savingsBalance` como parâmetro e inicializa o saldo da conta.
        - Se o saldo informado for menor que zero, deve disparar uma exceção do tipo `IllegalArgumentException` com a mensagem "O saldo inicial não pode ser negativo."
    - Um método `calculateMonthlyInterest()`: Calcula os juros mensais e adiciona ao saldo da conta.
    - Métodos `get`e `set` que permita recuperar e modificar a taxa de juros anual`IllegalArgumentException` com a mensagem "A taxa de juros não pode ser negativa."
    - Um método `getSavingsBalance()`: Retorna o saldo atualizado da conta.
1. A classe (`SavingsAccountApp`) deve:
    - Criar duas instâncias de `SavingsAccount` chamadas `saver1` e `saver2`, inicializando-as com os valores `$2000.00` e `$3000.00`, respectivamente.
    - Definir a taxa de juros anual para `4%`.
    - Calcular e exibir os saldos de ambas as contas ao longo de `12 meses`.
    - Modificar a taxa de juros anual para `5%`.
    - Calcular e exibir o saldo das contas após mais um mês com a nova taxa de juros.
1. Utilizar a classe `System.out` para imprimir os valores no console.