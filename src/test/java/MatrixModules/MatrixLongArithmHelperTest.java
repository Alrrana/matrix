package MatrixModules;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class MatrixLongArithmHelperTest {
    InputHelperStub inputHelper = new InputHelperStub();
    MatrixLongArithmHelper matrixHelper = spy(new MatrixLongArithmHelper());

    @Test
    void create() {
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {"64365465454asdfrtgyhjudsfrgtrtgrfhfhy645645641",
                "64365465454645645641", "23", "6546789786789", "55", "97",
                "49", "47978987979787", "85", "3987897894", "5",
                "8", "74", "87896789789879", "98", "29",
                "575469789678977", "47", "9", "7789789897897896", "57",
                "52", "62", "47987985784960", "479541687969", "16",
        };

        inputHelper.setIn(t);
        Matrix A = matrixHelper.create(5, 5, 5);

        inputHelper.setI(-1);
        Matrix E = matrixHelper.create(5, 5, 5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
    }

    @Test
    void createRandom() {
        when(matrixHelper.oneRandomDigitsString(5)).thenReturn("12345");
        Matrix A = matrixHelper.createRandom(5, 5,5);

        Matrix E = matrixHelper.createRandom(5, 5,5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
    }

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
        Matrix A = matrixHelper.create(5, 5, 5);
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
        Matrix A = matrixHelper.create(5, 5, 5);


        String[] t1 = {
                "61", "49", "8", "57", "52",
                "23", "47", "74", "47", "62",
                "69", "85", "8", "9", "40",
                "55", "34", "98", "76", "49",
                "97", "5", "29", "57", "16"
        };

        inputHelper.setI(-1);
        inputHelper.setIn(t1);
        Matrix E = matrixHelper.create(5, 5, 5);

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
        Matrix A = matrixHelper.create(3, 3, 5);


        String[] second = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(second);
        Matrix B = matrixHelper.create(3, 3, 5);


        String[] expected = {
                "4", "4", "8",
                "8", "4", "8",
                "4", "4", "4"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        Matrix E = matrixHelper.create(3, 3, 5);

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
        Matrix A = matrixHelper.create(3, 3, 5);


        String[] second = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(second);
        Matrix B = matrixHelper.create(3, 3, 5);


        String[] expected = {
                "2", "2", "4",
                "4", "2", "4",
                "2", "2", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        Matrix E = matrixHelper.create(3, 3, 5);

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
        Matrix A = matrixHelper.create(3, 3, 5);


        String[] second = {
                "2", "0", "0",
                "0", "2", "0",
                "0", "0", "2"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(second);
        Matrix B = matrixHelper.create(3, 3, 5);


        String[] expected = {
                "4", "4", "8",
                "8", "4", "8",
                "4", "4", "4"
        };
        inputHelper.setI(-1);
        inputHelper.setIn(expected);
        Matrix E = matrixHelper.create(3, 3, 5);

        A.print("A");
        A.print("B");
        A = A.mult(B);
        A.print("A(after sum)");
        Assert.assertTrue(A.equals(E));
    }

    
    
    
}