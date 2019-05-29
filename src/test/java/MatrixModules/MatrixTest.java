package MatrixModules;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {


    @Test
    void determinant() {
        int[][] first = {
                {2, 6},
                {4, 2}
        };
        Matrix A = new Matrix();
        A.setContent(first);
        A.setColumns(2);
        A.setRows(2);

        A.determinant();

        double expected = -20;

        Assert.assertEquals(expected, A.getDeterminant(), 0.001);

    }

    @Test
    void reverse() { // ToDo Matrix x MatrixReal
        int[][] first = {
                {2, 2},
                {4, 2}
        };
        Matrix A = new Matrix();
        A.setContent(first);
        A.setColumns(2);
        A.setRows(2);

        MatrixReal B = new MatrixReal();
        A.reverse(B);

        double[][] expected = {
                {-0.5, 0.5},
                {1, -0.5}
        };
        MatrixReal E = new MatrixReal();
        E.setContent(expected);
        E.setColumns(2);
        E.setRows(2);



        B.print("B");
        E.print("E");

        Assert.assertTrue(B.equals(E));

    }

    @Test
    void reverse2() {
        int[][] first = {
                {2, 2, 4},
                {4, 2, 4},
                {2, 2, 2}
        };
        Matrix A = new Matrix();
        A.setContent(first);
        A.setColumns(3);
        A.setRows(3);

        MatrixReal B = new MatrixReal();
        A.reverse(B);

        double[][] expected = {
                {-0.5, 0.5,0},
                {0, -0.5,1},
                {0.5,0,-0.5}
        };
        MatrixReal E = new MatrixReal();
        E.setContent(expected);
        E.setColumns(3);
        E.setRows(3);

        B.print("B");
        E.print("E");

        MatrixReal C = new MatrixReal();
        C.mult(A,B,C);

        C.print("C");
        Assert.assertTrue(B.equals(E));

    }


    @Test
    void transposition() {
        int[][] first = {
                {2, 2, 8},
                {4, 2, 0},
                {1, 5, 3}
        };
        Matrix A = new Matrix();
        A.setContent(first);
        A.setColumns(3);
        A.setRows(3);

        Matrix B = new Matrix();
        A.transposition(B);

        int[][] expected = {
                {2, 4, 1},
                {2, 2, 5},
                {8, 0, 3}
        };
        Matrix E = new Matrix();
        E.setContent(expected);
        E.setColumns(3);
        E.setRows(3);

        B.print("B");
        E.print("E");

        Assert.assertTrue(B.equals(E));
    }
}