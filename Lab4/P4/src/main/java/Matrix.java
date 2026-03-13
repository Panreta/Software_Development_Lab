import java.util.Random;

public class Matrix {
    private final int[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
        generateRandomValues();
    }

    public Matrix(int rows, int cols, boolean initialize) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
        if (initialize) {
            generateRandomValues();
        }
    }

    private void generateRandomValues() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = random.nextInt(10) + 1;
            }
        }
    }

    public int get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, int value) {
        data[row][col] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void print() {
        for (int i = 0; i < Math.min(5, rows); i++) {
            for (int j = 0; j < Math.min(5, cols); j++) {
                System.out.printf("%4d ", data[i][j]);
            }
            if (cols > 5) System.out.print("...");
            System.out.println();
        }
        if (rows > 5) System.out.println("...");
    }
}