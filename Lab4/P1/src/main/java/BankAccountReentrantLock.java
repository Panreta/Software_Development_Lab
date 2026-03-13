import java.util.concurrent.locks.ReentrantLock;

// Version B: Using ReentrantLock
public class BankAccountReentrantLock {
    private double balance;
    private final ReentrantLock lock;

    public BankAccountReentrantLock(double initialBalance) {
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                balance += amount;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}