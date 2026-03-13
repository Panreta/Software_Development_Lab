// WITHOUT synchronized - UNSAFE!
public class TrialA {
    private double balance = 1000;

    // NO SYNCHRONIZED - Race condition possible!
    public void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() +
                " checking balance: $" + balance);

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() +
                    " - Balance sufficient, proceeding to withdraw $" + amount);

            // Simulate some processing time to make race condition more likely
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " completed withdrawal. New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " - Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        TrialA account = new TrialA();

        System.out.println("=== UNSAFE VERSION (No Synchronization) ===");
        System.out.println("Initial balance: $" + account.getBalance());
        System.out.println("\nStarting two threads to withdraw $800 each...\n");

        // Create two threads that both try to withdraw $800
        Thread thread1 = new Thread(() -> {
            account.withdraw(800);
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            account.withdraw(800);
        }, "Thread-2");

        // Start both threads at nearly the same time
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        thread1.join();
        thread2.join();

        System.out.println("\n=== RESULT ===");
        System.out.println("Final balance: $" + account.getBalance());
        System.out.println("Expected balance: $200 (only one withdrawal should succeed)");

        if (account.getBalance() < 0) {
            System.out.println("❌ RACE CONDITION DETECTED! Balance is negative!");
        } else if (account.getBalance() == 200) {
            System.out.println("✓ Correct (but this might be luck without synchronization)");
        } else {
            System.out.println("⚠ Unexpected balance - race condition occurred!");
        }
    }
}