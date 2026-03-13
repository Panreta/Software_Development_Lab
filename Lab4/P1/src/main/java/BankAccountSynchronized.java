// Version A: Using synchronized methods
public class BankAccountSynchronized {
    private double balance;

    public BankAccountSynchronized(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        System.out.println("Not enough money");
        return false;
    }

    public synchronized double getBalance() {
        return balance;
    }
}