package MatrixModules;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;

class MatrixTest {

    InputHelperStub inputHelper = new InputHelperStub();
    MatrixIntHelper matrixHelper = spy(new MatrixIntHelper());
    MatrixDblHelper matrixHelperDbl = spy(new MatrixDblHelper());


    @Test
    void determinant() {
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {
                "61", "23", "69", "55", "97",
                "49", "47", "85", "34", "5",
                "8", "74", "8", "98", "29",
                "57", "47", "9", "76", "57",
                "52", "62", "40", "49", "16",
        };

        inputHelper.setIn(t);
        Matrix A = matrixHelper.create(5, 5);
        A.determinant();
        int d = (int) A.getDeterminant().getValue();

        A.print("A");
        System.out.println(d);

        Assert.assertEquals(d, 419765848);
    }

    @Test
    void transposition() {
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {
                "61", "23", "69", "55", "97",
                "49", "47", "85", "34", "5",
                "8", "74", "8", "98", "29",
                "57", "47", "9", "76", "57",
                "52", "62", "40", "49", "16"
        };

        inputHelper.setIn(t);
        Matrix A = matrixHelper.create(5, 5);


        String[] t1 = {
                "61", "49", "8", "57", "52",
                "23", "47", "74", "47", "62",
                "69", "85", "8", "9", "40",
                "55", "34", "98", "76", "49",
                "97", "5", "29", "57", "16"
        };

        inputHelper.setI(-1);
        inputHelper.setIn(t1);
        Matrix E = matrixHelper.create(5, 5);

        A = A.transposition();

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));

    }


    @Test
    void sum() {
        matrixHelper.setInputHelper(inputHelper);
        String[] first = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(first);
        Matrix A = matrixHelper.create(3, 3);


        String[] second = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(second);
        Matrix B = matrixHelper.create(3, 3);


        String[] expected = {
                "4", "4", "8",
                "8", "4", "8",
                "4", "4", "4"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        Matrix E = matrixHelper.create(3, 3);

        A.print("A");
        A.print("B");
        A = A.sum(B);
        A.print("A(after sum)");
        Assert.assertTrue(A.equals(E));

    }

    @Test
    void sub() {
        matrixHelper.setInputHelper(inputHelper);
        String[] first = {
                "4", "4", "8",
                "8", "4", "8",
                "4", "4", "4"

        };
        inputHelper.setI(-1);
        inputHelper.setIn(first);
        Matrix A = matrixHelper.create(3, 3);


        String[] second = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(second);
        Matrix B = matrixHelper.create(3, 3);


        String[] expected = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        Matrix E = matrixHelper.create(3, 3);

        A.print("A");
        A.print("B");
        A = A.sub(B);
        A.print("A(after sum)");
        Assert.assertTrue(A.equals(E));

    }

    @Test
    void mult() {
        matrixHelper.setInputHelper(inputHelper);
        String[] first = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"

        };
        inputHelper.setI(-1);
        inputHelper.setIn(first);
        Matrix A = matrixHelper.create(3, 3);


        String[] second = {
                "2", "0", "0",
                "0", "2", "0",
                "0", "0", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(second);
        Matrix B = matrixHelper.create(3, 3);


        String[] expected = {
                "4", "4", "8",
                "8", "4", "8",
                "4", "4", "4"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        Matrix E = matrixHelper.create(3, 3);

        A.print("A");
        A.print("B");
        A = A.mult(B);
        A.print("A(after sum)");
        Assert.assertTrue(A.equals(E));
    }

    @Test
    void reverse() {
        matrixHelperDbl.setInputHelper(inputHelper);
        String[] first = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(first);
        Matrix A = matrixHelperDbl.create(3, 3);


        String[] expected = {
                "-0.5", "0.5", "0.0",
                "0.0", "-0.5", "1.0",
                "0.5", "0", "-0.5"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        matrixHelperDbl.setInputHelper(inputHelper);
        Matrix E = matrixHelperDbl.create(3, 3);


        String[] one = {
                "1", "0", "0",
                "0", "1", "0",
                "0", "0", "1"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(one);
        Matrix One = matrixHelperDbl.create(3, 3);

        A.print("A(before reverse)");
        Matrix Reversed = A.reverse();
        Reversed.print("A(after reverse)");
        Assert.assertTrue(Reversed.equals(E));
//
//        A=A.mult(Reversed);
//        A.print("A(multed on reverse)");
//
//        Assert.assertTrue(A.equals(One));
    }


//    @Test
//    void determinant() {
//        int[][] first = {
//                {2, 6},
//                {4, 2}
//        };
//        Matrix A = new Matrix();
//        A.setContent(first);
//        A.setColumns(2);
//        A.setRows(2);
//
//        A.determinant();
//
//        double expected = -20;
//
//        Assert.assertEquals(expected, A.getDeterminant(), 0.001);
//
//    }
//
//    @Test
//    void reverse() { //
//        int[][] first = {
//                {2, 2},
//                {4, 2}
//        };
//        Matrix A = new Matrix();
//        A.setContent(first);
//        A.setColumns(2);
//        A.setRows(2);
//
//        OldMatrixReal B = A.reverse();
//
//        double[][] expected = {
//                {-0.5, 0.5},
//                {1, -0.5}
//        };
//        OldMatrixReal E = new OldMatrixReal();
//        E.setContent(expected);
//        E.setColumns(2);
//        E.setRows(2);
//
//
//        B.print("B");
//        E.print("E");
//
//        Assert.assertTrue(B.equals(E));
//
//    }
//
//    @Test
//    void reverse2() {
//        int[][] first = {
//                {2, 2, 4},
//                {4, 2, 4},
//                {2, 2, 2}
//        };
//        Matrix A = new Matrix();
//        A.setContent(first);
//        A.setColumns(3);
//        A.setRows(3);
//
//        OldMatrixReal B = A.reverse();
//
//        double[][] expected = {
//                {-0.5, 0.5, 0},
//                {0, -0.5, 1},
//                {0.5, 0, -0.5}
//        };
//        OldMatrixReal E = new OldMatrixReal();
//        E.setContent(expected);
//        E.setColumns(3);
//        E.setRows(3);
//
//        double[][] expected1 = {
//                {1, 0, 0},
//                {0, 1, 0},
//                {0, 0, 1}
//        };
//        OldMatrixReal E1 = new OldMatrixReal();
//        E1.setContent(expected1);
//        E1.setColumns(3);
//        E1.setRows(3);
//
//
//        B.print("B");
//        E.print("E");
//
//        OldMatrixReal C = new OldMatrixReal();
//        C.mult(A, B, C);
//
//        C.print("C");
//        Assert.assertTrue(B.equals(E));
//        Assert.assertTrue(C.equals(E1));
//    }
//
//
//    @Test
//    void transposition() {
//        int[][] first = {
//                {2, 2, 8},
//                {4, 2, 0},
//                {1, 5, 3}
//        };
//        Matrix A = new Matrix();
//        A.setContent(first);
//        A.setColumns(3);
//        A.setRows(3);
//
//        Matrix B = new Matrix();
//        A.transposition(B);
//
//        int[][] expected = {
//                {2, 4, 1},
//                {2, 2, 5},
//                {8, 0, 3}
//        };
//        Matrix E = new Matrix();
//        E.setContent(expected);
//        E.setColumns(3);
//        E.setRows(3);
//
//        B.print("B");
//        E.print("E");
//
//        Assert.assertTrue(B.equals(E));
//    }
//
//
//

}