package MatrixModules;

import java.util.ArrayList;
import java.util.List;

public class MatrixIntHelper extends MatrixHelper {

    public void setInputHelper(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public Matrix create(int n, int m) {
        List<List<Numeric<Integer>>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Введите элемент массива: ");
                c.get(i).add(new MyInt(inputHelper.parserInt("Введено не число , попробуйте ещё раз \n")));
            }
        }
        Matrix C = new Matrix(new MyInt(0));
        C.setContent(c);
        C.setColumns(n);
        C.setRows(m);

        return C;

    }

    public void create() {
        System.out.print("Введите количество элементов массива N: ");
        int n = inputHelper.parserLength();
        System.out.print("Введите количество элементов массива M: ");
        int m = inputHelper.parserLength();
        create(n, m);
    }

    public Matrix createRandom(int n, int m) {
        List<List<Numeric<Integer>>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c.get(i).add(new MyInt(oneRandomInt(100)));
            }
        }

        Matrix C = new Matrix(new MyInt(0));
        C.setContent(c);
        C.setColumns(n);
        C.setRows(m);

        return C;
    }

    public void createRandom() {
        System.out.print("Введите количество элементов массива N: ");
        int n = inputHelper.parserLength();
        System.out.print("Введите количество элементов массива M: ");
        int m = inputHelper.parserLength();
        createRandom(n, m);
    }

    public void createFullRandom() {
        int n = oneRandomInt(10);
        int m = oneRandomInt(10);
        createRandom(n, m);
    }


}