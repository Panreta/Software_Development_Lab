import java.util.concurrent.ExecutionException;

public class MatrixMultiplicationDemo {

    public static void main(String[] args) {
        final int SIZE = 500;
        final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

        System.out.println("=== Parallel Matrix Multiplication Demo ===");
        System.out.println("Matrix Size: " + SIZE + "x" + SIZE);
        System.out.println("Number of Threads: " + NUM_THREADS);
        System.out.println();

        System.out.println("Generating random matrices...");
        Matrix a = new Matrix(SIZE, SIZE);
        Matrix b = new Matrix(SIZE, SIZE);
        System.out.println("Matrices generated.");
        System.out.println();

        System.out.println("Sample from Matrix A:");
        a.print();
        System.out.println();

        System.out.println("Sample from Matrix B:");
        b.print();
        System.out.println();

        System.out.println("--- Sequential Multiplication ---");
        long startTime = System.nanoTime();
        Matrix sequentialResult = SequentialMultiplier.multiply(a, b);
        long endTime = System.nanoTime();
        double sequentialTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Execution Time: " + String.format("%.2f", sequentialTime) + " ms");
        System.out.println();

        System.out.println("Sample from Sequential Result:");
        sequentialResult.print();
        System.out.println();

        System.out.println("--- Parallel Multiplication ---");
        ParallelMultiplier parallelMultiplier = new ParallelMultiplier(NUM_THREADS);

        try {
            startTime = System.nanoTime();
            Matrix parallelResult = parallelMultiplier.multiply(a, b);
            endTime = System.nanoTime();
            double parallelTime = (endTime - startTime) / 1_000_000.0;
            System.out.println("Execution Time: " + String.format("%.2f", parallelTime) + " ms");
            System.out.println();

            System.out.println("Sample from Parallel Result:");
            parallelResult.print();
            System.out.println();

            System.out.println("--- Performance Comparison ---");
            System.out.println("Sequential Time: " + String.format("%.2f", sequentialTime) + " ms");
            System.out.println("Parallel Time:   " + String.format("%.2f", parallelTime) + " ms");
            double speedup = sequentialTime / parallelTime;
            System.out.println("Speedup:         " + String.format("%.2f", speedup) + "x");
            double improvement = ((sequentialTime - parallelTime) / sequentialTime) * 100;
            System.out.println("Improvement:     " + String.format("%.2f", improvement) + "%");
            System.out.println();

            boolean resultsMatch = verifyResults(sequentialResult, parallelResult);
            System.out.println("Results Match: " + (resultsMatch ? "YES" : "NO"));

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error during parallel multiplication: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean verifyResults(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            return false;
        }

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getCols(); j++) {
                if (a.get(i, j) != b.get(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}