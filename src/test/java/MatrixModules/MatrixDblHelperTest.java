package MatrixModules;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class MatrixDblHelperTest {
    InputHelperStub inputHelper = new InputHelperStub();
    MatrixDblHelper matrixHelper = spy(new MatrixDblHelper());
    private final Random random = new Random();

    public void setExpected() {
        //Let all our random generated ints be 0
        when(matrixHelper.oneRandomInt(100)).thenReturn(0);
    }


    @Test
    void create() {
        matrixHelper.setInputHelper(inputHelper);
        String[] t = {
                "61.3", "23.1", "69.345", "55.456", "97.567",
                "49.3645", "47.345", "85.345", "34.134", "5.134",
                "8.34", "74.23423", "8.234", "98.234", "29.1",
                "57.72", "47.2", "9.897", "76.2354", "57.9876",
                "52.456", "62.254", "40.42", "49.4632", "16.7425",
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
        when(matrixHelper.oneRandomDouble(anyInt(), anyInt())).thenReturn(0.0);

        Matrix A = matrixHelper.createRandom(5, 5);

        Matrix E = matrixHelper.createRandom(5, 5);

        A.print("A");
        E.print("E");

        Assert.assertTrue(A.equals(E));
    }
}