// ProducerConsumerMain.java
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProducerConsumerMain {
    private static final int QUEUE_CAPACITY = 10;
    private static final int NUM_PRODUCERS = 3;
    private static final int NUM_CONSUMERS = 2;
    private static final int ITEMS_PER_PRODUCER = 20;
    private static final int TOTAL_ITEMS = NUM_PRODUCERS * ITEMS_PER_PRODUCER;

    public static void main(String[] args) {
        // Create bounded blocking queue
        BlockingQueue<DataItem> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // Monitoring counters
        AtomicInteger producedCount = new AtomicInteger(0);
        AtomicInteger consumedCount = new AtomicInteger(0);
        AtomicBoolean producersFinished = new AtomicBoolean(false);

        // Create thread pools
        ExecutorService producerExecutor = Executors.newFixedThreadPool(NUM_PRODUCERS);
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(NUM_CONSUMERS);
        ScheduledExecutorService statsExecutor = Executors.newScheduledThreadPool(1);

        System.out.println("=== Producer-Consumer System Starting ===");
        System.out.printf("Queue capacity: %d%n", QUEUE_CAPACITY);
        System.out.printf("Producers: %d (each producing %d items)%n",
                NUM_PRODUCERS, ITEMS_PER_PRODUCER);
        System.out.printf("Consumers: %d%n", NUM_CONSUMERS);
        System.out.printf("Total items to produce: %d%n%n", TOTAL_ITEMS);

        // Start statistics monitoring (print every second)
        ScheduledFuture<?> statsFuture = statsExecutor.scheduleAtFixedRate(() -> {
            int produced = producedCount.get();
            int consumed = consumedCount.get();
            int queueSize = queue.size();

            System.out.printf("%n[STATS] Produced: %d | Consumed: %d | Queue Size: %d | Remaining: %d%n%n",
                    produced, consumed, queueSize, (TOTAL_ITEMS - consumed));
        }, 1, 1, TimeUnit.SECONDS);

        // Start producers
        for (int i = 1; i <= NUM_PRODUCERS; i++) {
            producerExecutor.submit(new Producer(queue, producedCount, i, ITEMS_PER_PRODUCER));
        }

        // Start consumers
        for (int i = 1; i <= NUM_CONSUMERS; i++) {
            consumerExecutor.submit(new Consumer(queue, consumedCount, i, producersFinished));
        }

        // Shutdown producers executor and wait for completion
        producerExecutor.shutdown();
        try {
            producerExecutor.awaitTermination(1, TimeUnit.MINUTES);
            producersFinished.set(true);
            System.out.println("\n=== All producers finished ===\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error waiting for producers");
        }

        // Wait for all items to be consumed
        consumerExecutor.shutdown();
        try {
            consumerExecutor.awaitTermination(2, TimeUnit.MINUTES);
            System.out.println("\n=== All consumers finished ===\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error waiting for consumers");
        }

        // Stop statistics and shutdown
        statsFuture.cancel(false);
        statsExecutor.shutdown();

        // Print final statistics
        System.out.println("\n=== FINAL STATISTICS ===");
        System.out.printf("Total Produced: %d%n", producedCount.get());
        System.out.printf("Total Consumed: %d%n", consumedCount.get());
        System.out.printf("Final Queue Size: %d%n", queue.size());
        System.out.printf("Expected Total: %d%n", TOTAL_ITEMS);

        if (consumedCount.get() == TOTAL_ITEMS) {
            System.out.println("\nSUCCESS: All items were produced and consumed!");
        } else {
            System.out.println("\nERROR: Mismatch in item counts!");
        }
    }
}