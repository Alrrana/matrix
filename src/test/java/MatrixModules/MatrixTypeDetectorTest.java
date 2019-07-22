package MatrixModules;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTypeDetectorTest {

    @Test
    void JSONparser() {
        String input1 = "[{\"value\":\"1.5\",\"row\":\"0\",\"col\":\"0\"},{\"value\":\"4\",\"row\":\"1\",\"col\":\"0\"},{\"value\":\"7\",\"row\":\"2\",\"col\":\"0\"},{\"value\":\"10\",\"row\":\"3\",\"col\":\"0\"},{\"value\":\"13\",\"row\":\"4\",\"col\":\"0\"},{\"value\":\"16\",\"row\":\"5\",\"col\":\"0\"},{\"value\":\"2\",\"row\":\"0\",\"col\":\"1\"},{\"value\":\"5\",\"row\":\"1\",\"col\":\"1\"},{\"value\":\"8\",\"row\":\"2\",\"col\":\"1\"},{\"value\":\"11\",\"row\":\"3\",\"col\":\"1\"},{\"value\":\"14\",\"row\":\"4\",\"col\":\"1\"},{\"value\":\"17\",\"row\":\"5\",\"col\":\"1\"},{\"value\":\"3\",\"row\":\"0\",\"col\":\"2\"},{\"value\":\"6\",\"row\":\"1\",\"col\":\"2\"},{\"value\":\"9\",\"row\":\"2\",\"col\":\"2\"},{\"value\":\"12\",\"row\":\"3\",\"col\":\"2\"},{\"value\":\"15\",\"row\":\"4\",\"col\":\"2\"},{\"value\":\"18\",\"row\":\"5\",\"col\":\"2\"}]\n" +
                "1";
        String input = "[{\"value\":\"1\",\"row\":\"0\",\"col\":\"0\"},{\"value\":\"3\",\"row\":\"1\",\"col\":\"0\"},{\"value\":\"5\",\"row\":\"2\",\"col\":\"0\"},{\"value\":\"2\",\"row\":\"0\",\"col\":\"1\"},{\"value\":\"4\",\"row\":\"1\",\"col\":\"1\"},{\"value\":\"6\",\"row\":\"2\",\"col\":\"1\"}]\n";


        String [][] A =( MatrixTypeDetector.JSONparser(input1));
        for (String[] i: A
             ) {
            for (String item:i
                 ) {
                System.out.println(item);
            }

        }
        A =( MatrixTypeDetector.JSONparser(input));
        for (String[] i: A
        ) {
            for (String item:i
            ) {
                System.out.println(item);
            }

        }


    }

    @Test
    void defineType() {
    }
}