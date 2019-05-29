package MatrixModules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class MatrixHelperTest {
    InputHelperStub inputHelper = new InputHelperStub();
    MatrixHelper matrixHelper = spy(new MatrixHelper());

    int[][] a = {
            {61, 23, 69, 55, 97},
            {49, 47, 85, 34, 5},
            {8, 74, 8, 98, 29},
            {57, 47, 9, 76, 57},
            {52, 62, 40, 49, 16}
    };

    int[][] b = {
            {122, 46, 138, 110, 194},
            {98, 94, 170, 68, 10},
            {16, 148, 16, 196, 58},
            {114, 94, 18, 152, 114},
            {104, 124, 80, 98, 32}
    };

    @Before
    public void setExpected() {
        //Let all our random generated ints be 0
//        when(matrixHelper.oneRandomInt()).thenReturn(0);
    }

    @BeforeAll
    public static void setExpected3() {
    }

    @org.junit.jupiter.api.Test
    void createWithInputLength() {
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {"5",
                "61", "23", "69", "55", "97",
                "49", "47", "85", "34", "5",
                "8", "74", "8", "98", "29",
                "57", "47", "9", "76", "57",
                "52", "62", "40", "49", "16"
        };
        inputHelper.setIn(t);
        Matrix A = new Matrix();
        matrixHelper.setMatrixA(A);
        matrixHelper.create();

        Matrix E = new Matrix();
        E.setContent(a);
        E.setColumns(5);
        E.setRows(5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));

    }

    @org.junit.jupiter.api.Test
    void createWithPresetLength() {
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {
                "61", "23", "69", "55", "97",
                "49", "47", "85", "34", "5",
                "8", "74", "8", "98", "29",
                "57", "47", "9", "76", "57",
                "52", "62", "40", "49", "16"
        };
        inputHelper.setIn(t);
        Matrix A = new Matrix();
        matrixHelper.setMatrixA(A);
        matrixHelper.create(5);

        Matrix E = new Matrix();
        E.setContent(a);
        E.setColumns(5);
        E.setRows(5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));

    }

    @org.junit.jupiter.api.Test
    void createRandom() {
        when(matrixHelper.oneRandomInt()).thenReturn(2);
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {
                "5"
        };
        inputHelper.setIn(t);
        Matrix A = new Matrix();
        matrixHelper.setMatrixA(A);
        matrixHelper.createRandom();

        int[][] expected = {
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2}
        };
        Matrix E = new Matrix();
        E.setContent(expected);
        E.setColumns(5);
        E.setRows(5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
    }

    @org.junit.jupiter.api.Test
    void createRandom1() {
        when(matrixHelper.oneRandomInt()).thenReturn(2);
        Matrix A = new Matrix();
        matrixHelper.setMatrixA(A);
        matrixHelper.createRandom(5);

        int[][] expected = {
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2}
        };
        Matrix E = new Matrix();
        E.setContent(expected);
        E.setColumns(5);
        E.setRows(5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
    }


    @org.junit.jupiter.api.Test
    void sum() {
        //set start
        Matrix A = new Matrix();
        A.setContent(a);
        A.setColumns(5);
        A.setRows(5);
        matrixHelper.setMatrixA(A);
        Matrix B = new Matrix();
        B.setContent(a);
        B.setColumns(5);
        B.setRows(5);
        matrixHelper.setMatrixB(B);

        //set expect
        Matrix E = new Matrix();
        E.setContent(b);
        E.setColumns(5);
        E.setRows(5);


        Matrix C = matrixHelper.sum();

        C.print("C");
        E.print("E");

        Assert.assertTrue(C.equals(E));

    }

    @org.junit.jupiter.api.Test
    void sub() {
        Matrix A = new Matrix();
        A.setContent(b);
        A.setColumns(5);
        A.setRows(5);
        matrixHelper.setMatrixA(A);
        Matrix B = new Matrix();
        B.setContent(a);
        B.setColumns(5);
        B.setRows(5);
        matrixHelper.setMatrixB(B);

        //set expect
        Matrix E = new Matrix();
        E.setContent(a);
        E.setColumns(5);
        E.setRows(5);


        Matrix C = matrixHelper.sub();

        C.print("C");
        E.print("E");

        Assert.assertTrue(C.equals(E));

    }

    @org.junit.jupiter.api.Test
    void mult() {
        Matrix A = new Matrix();
        A.setContent(a);
        A.setColumns(5);
        A.setRows(5);
        matrixHelper.setMatrixA(A);
        int[][] second = {
                {2, 0, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 0, 2, 0},
                {0, 0, 0, 0, 2}
        };
        Matrix B = new Matrix();
        B.setContent(second);
        B.setColumns(5);
        B.setRows(5);
        matrixHelper.setMatrixB(B);

        //set expect

        Matrix E = new Matrix();
        E.setContent(b);
        E.setColumns(5);
        E.setRows(5);


        Matrix C = matrixHelper.mult();

        C.print("C");
        E.print("E");

        Assert.assertTrue(C.equals(E));

    }

    @org.junit.jupiter.api.Test
    void multByOne() {
        Matrix A = new Matrix();
        A.setContent(a);
        A.setColumns(5);
        A.setRows(5);
        matrixHelper.setMatrixA(A);
        int[][] second = {
                {1}
        };
        Matrix B = new Matrix();
        B.setContent(second);
        B.setColumns(1);
        B.setRows(1);
        matrixHelper.setMatrixB(B);

        //set expect

        Matrix E = new Matrix();
        E.setContent(a);
        E.setColumns(5);
        E.setRows(5);


        Matrix C = matrixHelper.mult();

        C.print("C");
        E.print("E");

        Assert.assertTrue(C.equals(E));

    }

    @org.junit.jupiter.api.Test
    void multDifferent() {
        int[][] first = {
                {2, 1},
                {4, 2}
        };
        Matrix A = new Matrix();
        A.setContent(first);
        A.setColumns(2);
        A.setRows(2);
        matrixHelper.setMatrixA(A);
        int[][] second = {
                {2},
                {0}
        };
        Matrix B = new Matrix();
        B.setContent(second);
        B.setColumns(2);
        B.setRows(1);
        matrixHelper.setMatrixB(B);

        //set expect
        int[][] expected = {
                {4},
                {8}
        };
        Matrix E = new Matrix();
        E.setContent(expected);
        E.setColumns(2);
        E.setRows(1);


        Matrix C = matrixHelper.mult();

        C.print("C");
        E.print("E");

        Assert.assertTrue(C.equals(E));

    }


    @Test
    void multDifferentFail() {
        int[][] first = {
                {2, 1},
                {4, 2}
        };
        Matrix A = new Matrix();
        A.setContent(first);
        A.setColumns(2);
        A.setRows(2);

        matrixHelper.setMatrixA(A);
        int[][] second = {
                {2},
                {0},
                {1}
        };
        Matrix B = new Matrix();
        B.setContent(second);
        B.setColumns(3);
        B.setRows(1);
        matrixHelper.setMatrixB(B);

        //set expect

        boolean flag = false;

        Matrix C;
        try {
            C = matrixHelper.mult();
        } catch (IllegalMatrixDimensionException ex) {
            ex.Message();
            flag = true;
        }

        Assert.assertTrue(flag);
//        C.print("C");
//        E.print("E");
//
//        Assert.assertFalse(C.equals(E));

    }


}