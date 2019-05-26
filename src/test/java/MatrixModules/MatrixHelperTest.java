package MatrixModules;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class MatrixHelperTest {

    int[][] a = {
            {61, 23, 69, 55, 97},
            {49, 47, 85, 34, 5},
            {8, 74, 8, 98, 29},
            {57, 47, 9, 76, 57},
            {52, 62, 40, 49, 16}
    };

    int[][] b = {
            {61, 23, 69, 55, 97},
            {49, 47, 85, 34, 5},
            {8, 74, 8, 98, 29},
            {57, 47, 9, 76, 57},
            {52, 62, 40, 49, 16}
    };
    MatrixHelper matrixHelper = new MatrixHelper();


    @BeforeAll
    public static void setExpected3() {
    }

    @org.junit.jupiter.api.Test
    void create() {
    }

    @org.junit.jupiter.api.Test
    void create1() {
    }

    @org.junit.jupiter.api.Test
    void createRandom() {
    }

    @org.junit.jupiter.api.Test
    void createRandom1() {
    }

    @org.junit.jupiter.api.Test
    void sum() {
        //set start
        Matrix A = new Matrix();
        A.setContent(a);
        matrixHelper.setMatrixA(A);
        Matrix B = new Matrix();
        B.setContent(b);
        matrixHelper.setMatrixB(B);

        //set expect
        int[][] expected = {
                {122, 46, 138, 110, 194},
                {98, 94, 170, 68, 10},
                {16, 148, 16, 196, 58},
                {114, 94, 18, 152, 114},
                {104, 124, 80, 98, 32}
        };
        Matrix C = new Matrix();
        matrixHelper.sum(C);

        Assert.assertArrayEquals(C,expected);
    }

    @org.junit.jupiter.api.Test
    void sub() {
    }

    @org.junit.jupiter.api.Test
    void mult() {
    }
}