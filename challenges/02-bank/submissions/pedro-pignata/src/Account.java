class Account {
    private int id;
    private double balance;
    private static int accountCounter = 0;

    public Account(double balancem){
        this.balance = 0.0;
        this.id = ++accountCounter;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(){
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}