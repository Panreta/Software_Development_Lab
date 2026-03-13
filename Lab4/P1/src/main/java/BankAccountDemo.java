// Main class to test both versions
public class BankAccountDemo {
    public static void main(String[] args) {
        System.out.println("=== Thread-Safe Bank Account System ===\n");

        // Test Version A: Synchronized
        System.out.println("Version A: Using synchronized methods");
        testSynchronizedVersion();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test Version B: ReentrantLock
        System.out.println("Version B: Using ReentrantLock");
        testReentrantLockVersion();
    }

    private static void testSynchronizedVersion() {
        BankAccountSynchronized account = new BankAccountSynchronized(1000.0);
        TransactionProcessorSynchronized processor =
                new TransactionProcessorSynchronized(account, 10, 100);

        System.out.println("Initial balance: $" + account.getBalance());
        System.out.println("Starting 10 threads with 100 transactions each...");

        long startTime = System.currentTimeMillis();

        try {
            processor.processTransactions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("All transactions completed!");
        System.out.println("Final balance: $" + account.getBalance());
        System.out.println("Expected balance: $1000.0");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        System.out.println("Balance correct: " + (account.getBalance() == 1000.0));
    }

    private static void testReentrantLockVersion() {
        BankAccountReentrantLock account = new BankAccountReentrantLock(1000.0);
        TransactionProcessorReentrantLock processor =
                new TransactionProcessorReentrantLock(account, 10, 100);

        System.out.println("Initial balance: $" + account.getBalance());
        System.out.println("Starting 10 threads with 100 transactions each...");

        long startTime = System.currentTimeMillis();

        try {
            processor.processTransactions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("All transactions completed!");
        System.out.println("Final balance: $" + account.getBalance());
        System.out.println("Expected balance: $1000.0");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        System.out.println("Balance correct: " + (account.getBalance() == 1000.0));
    }
}