// Consumer.java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Random;

public class Consumer implements Runnable {
    private final BlockingQueue<DataItem> queue;
    private final AtomicInteger consumedCount;
    private final int consumerId;
    private final Random random;
    private final AtomicBoolean producersFinished;

    public Consumer(BlockingQueue<DataItem> queue, AtomicInteger consumedCount,
                    int consumerId, AtomicBoolean producersFinished) {
        this.queue = queue;
        this.consumedCount = consumedCount;
        this.consumerId = consumerId;
        this.random = new Random();
        this.producersFinished = producersFinished;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Check if we should continue
                if (producersFinished.get() && queue.isEmpty()) {
                    break;
                }

                // Try to take item from queue (blocks if empty)
                DataItem item = queue.poll(100, java.util.concurrent.TimeUnit.MILLISECONDS);

                if (item != null) {
                    // Process item (simulate work)
                    Thread.sleep(100 + random.nextInt(101));

                    consumedCount.incrementAndGet();
                    long processingTime = System.currentTimeMillis() - item.getTimestamp();
                    System.out.printf("Consumer-%d consumed: %s (Processing time: %dms, Queue size: %d)%n",
                            consumerId, item, processingTime, queue.size());
                }
            }
            System.out.printf("Consumer-%d finished%n", consumerId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Consumer-%d interrupted%n", consumerId);
        }
    }
}