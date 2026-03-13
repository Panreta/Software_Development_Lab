public class SequentialMultiplier {

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException(
                    "Matrix dimensions incompatible for multiplication"
            );
        }

        int rows = a.getRows();
        int cols = b.getCols();
        int common = a.getCols();

        Matrix result = new Matrix(rows, cols, false);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < common; k++) {
                    sum += a.get(i, k) * b.get(k, j);
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }
}