import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Transaction Processor for ReentrantLock version
public class TransactionProcessorReentrantLock {
    private final BankAccountReentrantLock account;
    private final int numThreads;
    private final int transactionsPerThread;

    public TransactionProcessorReentrantLock(BankAccountReentrantLock account,
                                             int numThreads,
                                             int transactionsPerThread) {
        this.account = account;
        this.numThreads = numThreads;
        this.transactionsPerThread = transactionsPerThread;
    }

    public void processTransactions() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new TransactionWorker(account, transactionsPerThread));
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static class TransactionWorker implements Runnable {
        private final BankAccountReentrantLock account;
        private final int numTransactions;
        private final Random random;

        public TransactionWorker(BankAccountReentrantLock account, int numTransactions) {
            this.account = account;
            this.numTransactions = numTransactions;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < numTransactions; i++) {
                if (i < numTransactions / 2) {
                    // First half: deposits
                    account.deposit(10.0);
                } else {
                    // Second half: withdrawals
                    account.withdraw(10.0);
                }
            }
        }
    }
}