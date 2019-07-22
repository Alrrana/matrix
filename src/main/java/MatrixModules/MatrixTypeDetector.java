package MatrixModules;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

public class MatrixTypeDetector extends MatrixHelper {

    static int col;
    static int row;

    public static String[][] JSONparser(String input) {
//        JsonFactory factory = new JsonFactory();
//        try {
//            JsonParser jp = factory.createParser(input);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String[] parsed = input.split("\"");
//        col = Integer.valueOf(parsed[parsed.length - 2]) + 1;
//        row = Integer.valueOf(parsed[parsed.length - 6]) + 1;
//        String[][] res = new String[col][row];
//        for (int i = 3; i < parsed.length; i += 12) {
//            if (parsed[i].equals(""))
//                return null;
//            res[Integer.valueOf(parsed[i + 8])][Integer.valueOf(parsed[i + 4])] = parsed[i];
//        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<MatrixElement> parsed;
        try {
            parsed = objectMapper.readValue(input, new TypeReference<List<MatrixElement>>() {
            });
            col = parsed.get(parsed.size() - 1).col+1;
            row = parsed.get(parsed.size() - 1).row+1;
            String[][] res = new String[col][row];
            for (int i = 0; i < parsed.size(); i++) {
                if (parsed.get(i).value.equals(""))
                    return null;
                res[parsed.get(i).col][parsed.get(i).row] = parsed.get(i).value;

            }
            return res;
        } catch (IOException e) {
                e.printStackTrace();
        }
        return null;

    }

    public static int defineType(String[][] input) {
        if (input != null) {
            boolean itsInt = false;//1
            boolean itsLong = false;//3
            boolean itsDouble = false;//2
            try {
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row; j++) {
                        int temp = Integer.valueOf(input[i][j]);
                    }
                }
                itsInt = true;
            } catch (NumberFormatException ex) {
                try {
                    for (int i = 0; i < col; i++) {
                        for (int j = 0; j < row; j++) {
                            double temp = Double.valueOf(input[i][j]);
                        }
                    }
                    itsDouble = true;
                } catch (Exception ex1) {
                    try {
                        for (int i = 0; i < col; i++) {
                            for (int j = 0; j < row && InputHelper.isLong(input[i][j]); j++) {
                            }

                        }
                        itsLong = true;
                    } catch (Exception ex2) {
                        System.out.println(ex);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            if (itsInt) {
                return 1;
            }
            if (itsDouble) {
                return 2;
            }
            if (itsLong) {
                return 3;
            } else return 0;
        } else return 0;
    }

    MatrixIntHelper intHelper = new MatrixIntHelper();
    MatrixDblHelper dblHelper = new MatrixDblHelper();
    MatrixLongArithmHelper longHelper = new MatrixLongArithmHelper();


    public Matrix giveMeMatrix(String a) {
        return (gimmeMatrix(JSONparser(a)));
    }

    public Matrix gimmeMatrix(String a) {
        return gimmeMatrix(JSONparser(a));
    }

    public Matrix gimmeMatrix(String[][] res) {
        int n = defineType(res);
        Matrix A;
        switch (n) {
            case 1:
                A = intHelper.create(col, row, res);
                return A;

            case 2:
                A = dblHelper.create(col, row, res);
                return A;

            case 3:
                A = longHelper.create(col, row, res);
                return A;


        }
        return null; // Error
    }
}
