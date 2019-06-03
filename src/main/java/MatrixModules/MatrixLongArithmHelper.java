package MatrixModules;

import LongMath.LongArithmethic;
import LongMath.LongArithmethicImpl;

import java.util.ArrayList;
import java.util.List;

public class MatrixLongArithmHelper extends MatrixHelper {
    public void setInputHelper(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public Matrix create(int m, int n) {
        List<List<Numeric<LongArithmethic>>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Введите элемент массива: ");
                c.get(i).add(new MyLongArithmethic(new LongArithmethicImpl(inputHelper.parserLongArithm("Введено не число , попробуйте ещё раз \n"))));
            }
        }
        Matrix C = new Matrix(new MyLongArithmethic(new LongArithmethicImpl("0")));
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
        create(m, n);
    }

    public Matrix createRandom(int n, int m,int digitMaxLength) {
        List<List<Numeric<LongArithmethic>>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Введите элемент массива: ");
                c.get(i).add(new MyLongArithmethic(new LongArithmethicImpl(oneRandomDigitsString(digitMaxLength))));
            }
        }
        Matrix C = new Matrix(new MyLongArithmethic(null));
        C.setContent(c);
        C.setColumns(n);
        C.setRows(m);

        return C;
    }

    public void createRandom(int d) {
        System.out.print("Введите количество элементов массива N: ");
        int n = inputHelper.parserLength();
        System.out.print("Введите количество элементов массива M: ");
        int m = inputHelper.parserLength();
        createRandom(n, m,d);
    }

    public void createFullRandom() {
        int n = oneRandomInt(10);
        int m = oneRandomInt(10);
        int d = oneRandomInt(10);
        createRandom(n, m,d);
    }

}
