import java.util.Scanner;

abstract class Account {
    private static int accountCounter = 1000;
    private int id;
    protected double balance;

    public Account() {
        this.id = ++accountCounter;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public abstract void applyMonthlyProcessing();

    @Override
    public String toString() {
        return "Número da Conta: " + id + "\n" +
               "Saldo: R$ " + String.format("%.2f", balance);
    }
}

class CheckingAccount extends Account {
    private static final double MAINTENANCE_FEE = 10.0;
    private static final double CREDIT_LIMIT = -500.0;

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= CREDIT_LIMIT) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyProcessing() {
        balance -= MAINTENANCE_FEE;
    }
}

class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.005;

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyProcessing() {
        balance += balance * INTEREST_RATE;
    }
}

class SalaryAccount extends Account {
    @Override
    public void deposit(double amount) {
        System.out.println("Depósitos manuais não são permitidos em contas salário.");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyProcessing() {
        // Não há processamento mensal para contas salário
    }
}

class Customer {
    private String firstName;
    private String lastName;
    private String cpf;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private SalaryAccount salaryAccount;

    public Customer(String firstName, String lastName, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public void addAccount(Account account) {
        if (account instanceof CheckingAccount) {
            this.checkingAccount = (CheckingAccount) account;
        } else if (account instanceof SavingsAccount) {
            this.savingsAccount = (SavingsAccount) account;
        } else if (account instanceof SalaryAccount) {
            this.salaryAccount = (SalaryAccount) account;
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String displayInformation() {
        StringBuilder info = new StringBuilder("\nNome: " + firstName + " " + lastName + "\n" +
                                               "CPF: " + cpf + "\n");

        if (checkingAccount != null) {
            info.append("Conta Corrente:\n").append(checkingAccount).append("\n");
        }
        if (savingsAccount != null) {
            info.append("Conta Poupança:\n").append(savingsAccount).append("\n");
        }
        if (salaryAccount != null) {
            info.append("Conta Salário:\n").append(salaryAccount).append("\n");
        }

        return info.toString();
    }

    public Account getAccount(int accountType) {
        switch (accountType) {
            case 1:
                return checkingAccount;
            case 2:
                return savingsAccount;
            case 3:
                return salaryAccount;
            default:
                return null;
        }
    }
}

class IDPBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;

        while (true) {
            System.out.println("\nSeja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");

            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    if (customer == null) {
                        System.out.println("\nDigite os dados para a abertura da conta.");
                        System.out.print("Primeiro nome: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Sobrenome: ");
                        String lastName = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        customer = new Customer(firstName, lastName, cpf);
                    }

                    System.out.println("\nQual tipo de conta deseja abrir?");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    System.out.println("3. Conta Salário");
                    System.out.print("Digite o número da opção desejada: ");

                    int accountType = scanner.nextInt();
                    scanner.nextLine();

                    Account newAccount = null;
                    switch (accountType) {
                        case 1:
                            newAccount = new CheckingAccount();
                            break;
                        case 2:
                            newAccount = new SavingsAccount();
                            break;
                        case 3:
                            newAccount = new SalaryAccount();
                            break;
                        default:
                            System.out.println("Tipo de conta inválido.");
                            break;
                    }

                    if (newAccount != null) {
                        customer.addAccount(newAccount);
                        System.out.println("\nConta criada com sucesso! Pressione Enter para continuar...");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    if (customer != null) {
                        System.out.println(customer.displayInformation());
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (customer != null) {
                        System.out.print("Digite o número da conta (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int accountTypeDeposit = scanner.nextInt();
                        scanner.nextLine();

                        Account account = customer.getAccount(accountTypeDeposit);
                        if (account != null) {
                            System.out.print("Digite o valor que deseja depositar: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            account.deposit(amount);
                            System.out.println("\nValor depositado com sucesso na conta do cliente " + customer.getFullName() + ".");
                            System.out.println(customer.displayInformation());
                        } else {
                            System.out.println("Conta inválida.");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    if (customer != null) {
                        System.out.print("Digite o número da conta (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int accountTypeWithdraw = scanner.nextInt();
                        scanner.nextLine();

                        Account account = customer.getAccount(accountTypeWithdraw);
                        if (account != null) {
                            System.out.print("Digite o valor que deseja sacar: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (account.withdraw(amount)) {
                                System.out.println("\nValor sacado com sucesso da conta do cliente " + customer.getFullName() + ".");
                                System.out.println(customer.displayInformation());
                            } else {
                                System.out.println("Saldo insuficiente ou valor inválido.");
                            }
                        } else {
                            System.out.println("Conta inválida.");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    if (customer != null) {
                        System.out.print("Digite o número da conta de origem (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int fromAccountType = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o número da conta de destino (1 - Corrente, 2 - Poupança, 3 - Salário): ");
                        int toAccountType = scanner.nextInt();
                        scanner.nextLine();

                        Account fromAccount = customer.getAccount(fromAccountType);
                        Account toAccount = customer.getAccount(toAccountType);

                        if (fromAccount != null && toAccount != null) {
                            System.out.print("Digite o valor que deseja transferir: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (fromAccount.withdraw(amount)) {
                                toAccount.deposit(amount);
                                System.out.println("\nTransferência realizada com sucesso.");
                                System.out.println(customer.displayInformation());
                            } else {
                                System.out.println("Saldo insuficiente ou valor inválido.");
                            }
                        } else {
                            System.out.println("Conta de origem ou destino inválida.");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    }
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;

                case 6:
                    System.out.println("Obrigado por usar o IDP Bank. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}