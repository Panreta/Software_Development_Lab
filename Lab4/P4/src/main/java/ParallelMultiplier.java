import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelMultiplier {
    private final int numThreads;

    public ParallelMultiplier(int numThreads) {
        this.numThreads = numThreads;
    }

    public Matrix multiply(Matrix a, Matrix b) throws InterruptedException, ExecutionException {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException(
                    "Matrix dimensions incompatible for multiplication"
            );
        }

        int rows = a.getRows();
        int cols = b.getCols();

        Matrix result = new Matrix(rows, cols, false);

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Void>> futures = new ArrayList<>();

        int rowsPerThread = rows / numThreads;
        int remainingRows = rows % numThreads;

        int startRow = 0;
        for (int i = 0; i < numThreads; i++) {
            int endRow = startRow + rowsPerThread;
            if (i < remainingRows) {
                endRow++;
            }

            MatrixMultiplicationTask task = new MatrixMultiplicationTask(
                    a, b, result, startRow, endRow
            );
            futures.add(executor.submit(task));

            startRow = endRow;
        }

        for (Future<Void> future : futures) {
            future.get();
        }

        executor.shutdown();

        return result;
    }
}