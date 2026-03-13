// Producer.java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class Producer implements Runnable {
    private final BlockingQueue<DataItem> queue;
    private final AtomicInteger producedCount;
    private final int itemsToProduce;
    private final int producerId;
    private final Random random;

    public Producer(BlockingQueue<DataItem> queue, AtomicInteger producedCount,
                    int producerId, int itemsToProduce) {
        this.queue = queue;
        this.producedCount = producedCount;
        this.producerId = producerId;
        this.itemsToProduce = itemsToProduce;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemsToProduce; i++) {
                // Generate item
                DataItem item = new DataItem(producedCount.incrementAndGet());

                // Put item in queue (blocks if queue is full)
                queue.put(item);
                System.out.printf("Producer-%d produced: %s (Queue size: %d)%n",
                        producerId, item, queue.size());

                // Sleep for 50-100ms
                Thread.sleep(50 + random.nextInt(51));
            }
            System.out.printf("Producer-%d finished producing %d items%n",
                    producerId, itemsToProduce);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Producer-%d interrupted%n", producerId);
        }
    }
}