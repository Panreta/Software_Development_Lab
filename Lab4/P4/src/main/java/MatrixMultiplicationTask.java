import java.util.concurrent.Callable;

public class MatrixMultiplicationTask implements Callable<Void> {
    private final Matrix a;
    private final Matrix b;
    private final Matrix result;
    private final int startRow;
    private final int endRow;

    public MatrixMultiplicationTask(Matrix a, Matrix b, Matrix result,
                                    int startRow, int endRow) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public Void call() {
        int cols = b.getCols();
        int common = a.getCols();

        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < common; k++) {
                    sum += a.get(i, k) * b.get(k, j);
                }
                result.set(i, j, sum);
            }
        }

        return null;
    }
}