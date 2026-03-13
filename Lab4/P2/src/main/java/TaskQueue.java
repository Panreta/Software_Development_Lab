import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskQueue {
    private final ConcurrentLinkedQueue<String> urlQueue;
    private final AtomicInteger completedCount;

    public TaskQueue() {
        this.urlQueue = new ConcurrentLinkedQueue<>();
        this.completedCount = new AtomicInteger(0);
    }

    public void addTask(String url) {
        urlQueue.offer(url);
    }

    public String getNextTask() {
        return urlQueue.poll();
    }

    public void incrementCompleted() {
        completedCount.incrementAndGet();
    }

    public int getCompletedCount() {
        return completedCount.get();
    }

    public boolean isEmpty() {
        return urlQueue.isEmpty();
    }
}