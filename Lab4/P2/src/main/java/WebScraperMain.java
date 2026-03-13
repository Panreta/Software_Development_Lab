public class WebScraperMain {
    public static void main(String[] args) {
        final int NUM_URLS = 50;
        final int NUM_WORKERS = 5;

        // Create task queue
        TaskQueue taskQueue = new TaskQueue();

        // Add 50 URLs to the queue
        System.out.println("Adding " + NUM_URLS + " URLs to the queue...");
        for (int i = 1; i <= NUM_URLS; i++) {
            taskQueue.addTask("http://example.com/page" + i);
        }
        System.out.println("All URLs added to queue.\n");

        // Record start time
        long startTime = System.currentTimeMillis();

        // Create and start 5 worker threads
        Worker[] workers = new Worker[NUM_WORKERS];
        System.out.println("Starting " + NUM_WORKERS + " worker threads...\n");

        for (int i = 0; i < NUM_WORKERS; i++) {
            workers[i] = new Worker(i + 1, taskQueue);
            workers[i].start();
        }

        // Wait for all workers to finish
        try {
            for (Worker worker : workers) {
                worker.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted");
        }

        // Record end time
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        // Print final statistics
        System.out.println("\n========== FINAL STATISTICS ==========");
        System.out.println("Total tasks processed: " + taskQueue.getCompletedCount());
        System.out.println("Time taken: " + totalTime + " ms (" +
                String.format("%.2f", totalTime / 1000.0) + " seconds)");
        System.out.println("Average time per task: " +
                String.format("%.2f", totalTime / (double) taskQueue.getCompletedCount()) + " ms");
        System.out.println("======================================");
    }
}