package MatrixModules;

import java.util.Random;

public class MatrixHelper {

    protected InputHelper inputHelper = new InputHelper();
    private final Random random = new Random();

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
    }

    public void createRandom() {
        int n = inputHelper.parserLength();
        createRandom(n);
    }


}
