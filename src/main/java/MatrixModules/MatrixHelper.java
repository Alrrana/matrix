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


}
