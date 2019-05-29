package MatrixModules;

import java.util.Random;

public class MatrixHelper {

    protected InputHelper inputHelper = new InputHelper();
    private final Random random = new Random();
    private Matrix matrixA = new Matrix();
    private Matrix matrixB = new Matrix();
    boolean stateA = true;

    public void switchState() {
        this.stateA = !stateA;
    }

    public void setMatrixA(Matrix matrix) {
        this.matrixA = matrix;
    }

    public void setMatrixB(Matrix matrix) {
        this.matrixB = matrix;
    }

    public void setInputHelper(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public int oneRandomInt() {
        return random.nextInt(100);
    }

    public void create(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Введите элемент массива: ");
                array[i][j] = inputHelper.parser("Введено не число , попробуйте ещё раз \n");
            }
        }
        set(n, array);
    }

    private void set(int n, int[][] array) {
        if (stateA) {
            matrixA.setContent(array);
            matrixA.setRows(n);
            matrixA.setColumns(n);
        } else {
            matrixB.setContent(array);
            matrixB.setRows(n);
            matrixB.setColumns(n);
        }
    }

    public void create() {
        System.out.print("Введите количество элементов массива: ");
        int n = inputHelper.parserLength();
        create(n);
    }

    public void createRandom(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = oneRandomInt();
            }
        }
        set(n, array);

    }

    public void createRandom() {
        int n = inputHelper.parserLength();
        createRandom(n);
    }

    public void print() {
        if (matrixA.getColumns() != 0) {
            matrixA.print("A");
        } else {
            System.out.print("Матрица А не введена\n");
        }
        if (matrixB.getColumns() != 0) {
            matrixB.print("B");
        } else {
            System.out.print("Матрица B не введена\n");
        }
    }

    public Matrix sum() {
        Matrix C = new Matrix();
        if (matrixA.getColumns() != 0 && matrixB.getColumns() != 0) {

            if (matrixA.getColumns() == matrixB.getColumns()) {

                int[][] a = matrixA.getContent();
                int[][] b = matrixB.getContent();
                int[][] c = new int[matrixB.getColumns()][matrixB.getColumns()];

                for (int i = 0; i < matrixB.getColumns(); i++) {
                    for (int j = 0; j < matrixB.getColumns(); j++) {
                        c[i][j] = a[i][j] + b[i][j];
                    }

                }

                C.setContent(c);
                C.setColumns(matrixB.getColumns());
                C.setRows(matrixB.getColumns());

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }
        return C;
    }

    public Matrix sub() {
        Matrix C = new Matrix();
        if (matrixA.getColumns() != 0 && matrixB.getColumns() != 0) {


            if (matrixA.getColumns() == matrixB.getColumns()) {

                int[][] a = matrixA.getContent();
                int[][] b = matrixB.getContent();
                int[][] c = new int[matrixB.getColumns()][matrixB.getColumns()];

                for (int i = 0; i < matrixB.getColumns(); i++) {
                    for (int j = 0; j < matrixB.getColumns(); j++) {
                        c[i][j] = a[i][j] - b[i][j];
                    }

                }

                C.setContent(c);
                C.setColumns(matrixB.getColumns());
                C.setRows(matrixB.getColumns());

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }
        return C;
    }

    public Matrix mult() {
        Matrix C = new Matrix();
        if (matrixA.getColumns() != 0 && matrixB.getColumns() != 0) {

            if ((matrixB.getColumns() == matrixB.getRows() &&
                    matrixB.getColumns() == 1)
                    ||
                    (matrixA.getColumns() == matrixA.getRows() &&
                            matrixA.getColumns() == 1)) {
                if (matrixB.getRows() == 1) {
                    C.setContent(matrixA.getContent());
                    C.setColumns(matrixA.getColumns());
                    C.setRows(matrixA.getRows());
                } else {
                    C.setContent(matrixB.getContent());
                    C.setColumns(matrixB.getColumns());
                    C.setRows(matrixB.getRows());
                }
            } else {

                if (matrixA.getColumns() == matrixB.getRows() ||
                        matrixA.getRows() == matrixB.getColumns()) {

                    int[][] a = matrixA.getContent();
                    int[][] b = matrixB.getContent();
                    int[][] c = new int[matrixB.getColumns()][matrixB.getRows()];

                    for (int i = 0; i < matrixA.getColumns(); ++i)
                        for (int j = 0; j < matrixB.getRows(); ++j)
                            for (int k = 0; k < matrixB.getColumns(); ++k)
                                c[i][j] += a[i][k] * b[k][j];

                    C.setContent(c);
                    C.setColumns(matrixA.getColumns());
                    C.setRows(matrixB.getRows());

                } else {
                    System.out.print("Размерность матриц не совпадает");
                    throw new IllegalMatrixDimensionException("Нельзя перемножать матрицы разного размера");
//                    throw new IllegalArgumentException();
                }
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }
        return C;
    }

}
