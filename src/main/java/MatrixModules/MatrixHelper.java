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
        int[][] array = matrixA.getContent();
        System.out.println("Матрица: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void sum(Matrix C) {
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

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }

    }

    public void sub(Matrix C) {
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

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }

    }

    public void mult(Matrix C) {
        if (matrixA.getColumns() != 0 && matrixB.getColumns() != 0) {

            if (matrixA.getColumns() == matrixB.getColumns()) {

                int[][] a = matrixA.getContent();
                int[][] b = matrixB.getContent();
                int[][] c = new int[matrixB.getColumns()][matrixB.getColumns()];

                for (int i = 0; i < matrixB.getColumns(); i++) {
                    for (int j = 0; j < matrixB.getColumns(); j++) {
                        c[i][j] = a[i][j] * b[i][j];
                    }

                }

                C.setContent(c);

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }

    }

}
