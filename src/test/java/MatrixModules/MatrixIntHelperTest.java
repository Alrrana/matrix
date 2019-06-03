package MatrixModules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class MatrixIntHelperTest {
    InputHelperStub inputHelper = new InputHelperStub();
    MatrixIntHelper matrixHelper = spy(new MatrixIntHelper());

    @Before
    public void setExpected() {
        //Let all our random generated ints be 0


    }

    @Test
    void create() {
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

        inputHelper.setI(-1);
        Matrix E = matrixHelper.create(5, 5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
//
    }

    @Test
    void createRandom() {
        when(matrixHelper.oneRandomInt(100)).thenReturn(0);

        Matrix A = matrixHelper.createRandom(5, 5);

        Matrix E = matrixHelper.createRandom(5, 5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
    }
}