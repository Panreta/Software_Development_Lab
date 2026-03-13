import java.util.Random;

public class Worker extends Thread {
    private final int workerId;
    private final TaskQueue taskQueue;
    private final Random random;

    public Worker(int workerId, TaskQueue taskQueue) {
        this.workerId = workerId;
        this.taskQueue = taskQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            String url = taskQueue.getNextTask();

            if (url == null) {
                // Queue is empty, stop processing
                break;
            }

            try {
                // Simulate web scraping with random delay between 100-300ms
                int sleepTime = 100 + random.nextInt(201);
                Thread.sleep(sleepTime);

                System.out.println("Worker " + workerId + " processed: " + url);

                taskQueue.incrementCompleted();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Worker " + workerId + " interrupted");
                break;
            }
        }

        System.out.println("Worker " + workerId + " finished");
    }
}