package MatrixModules;

public class MatrixTypeDetector extends MatrixHelper {

    static int col;
    static int row;

    public static String[][] JSONparser(String input) {
        String[] parsed = input.split("\"");
        col = Integer.valueOf(parsed[parsed.length - 2]) + 1;
        row = Integer.valueOf(parsed[parsed.length - 6]) + 1;
        String[][] res = new String[row][col];
        for (int i = 7; i < parsed.length; i += 12) {
            if(parsed[i]=="")
                return null;
            res[Integer.valueOf(parsed[i + 4])][Integer.valueOf(parsed[i + 8])] = parsed[i];
        }
        return res;
    }

    public static int defineType(String[][] input) {
        if(input!=null) {
            boolean itsInt = false;//1
            boolean itsLong = false;//3
            boolean itsDouble = false;//2
            try {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        int temp = Integer.valueOf(input[i][j]);
                    }
                }
                itsInt = true;
            } catch (NumberFormatException ex) {
                try {
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            double temp = Double.valueOf(input[i][j]);
                        }
                    }
                    itsDouble = true;
                } catch (Exception ex1) {
                    try {
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col && InputHelper.isLong(input[i][j]); j++) {
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
        }
        else return 0;
    }

    MatrixIntHelper intHelper = new MatrixIntHelper();
    MatrixDblHelper dblHelper = new MatrixDblHelper();
    MatrixLongArithmHelper longHelper = new MatrixLongArithmHelper();


    public Matrix gimmeMatrix(String a) {
        String[][] res = JSONparser(a);
        int n = defineType(res);
        Matrix A;
        switch (n) {
            case 1:
                A = intHelper.create(row, col, res);
                return A;

            case 2:
                A = dblHelper.create(row, col, res);
                return A;

            case 3:
                A = longHelper.create(row, col, res);
                return A;


        }
        return null; // Error
    }
}
