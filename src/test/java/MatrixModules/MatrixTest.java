//package MatrixModules;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//class MatrixTest {
//
//
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
//}