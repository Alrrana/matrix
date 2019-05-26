package MatrixModules;

public class Matrix {
    private int columns = 0;
    private int rows = 0;
    private int[][] content;
    private long determinant;

    public void setDeterminant(long determinant) {
        this.determinant = determinant;
    }

    public double getDeterminant() {
        return determinant;
    }

    public void setContent(int[][] content) {
        this.content = content;
    }

    public int[][] getContent() {
        return content;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void determinant() {
        determinant = determinant(content, rows);
    }

    private long determinant(int[][] a, int n) {

        long tempD = 0;
        if (n == 1) tempD = a[0][0];

        else if (n == 2) tempD = a[0][0] * a[1][1] -a[1][0] * a[0][1];
            // NxN matrix
        else {
            for (int j1 = 0; j1 < n; j1++) {
                int[][] t = deteminantMinor(a, n, j1);
                tempD += Math.pow(-1.0, 1.0 + j1 + 1.0) * a[0][j1] * determinant(t, n - 1);
            }
        }
        return tempD;
    }


   private int[][] deteminantMinor(int[][] A, int n, int j1) {
        int[][] t = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int j2 = 0;
            for (int j = 0; j < n; j++) {
                if (j == j1)
                    continue;
                t[i - 1][j2] = A[i][j];
                j2++;
            }
        }
        return t;
    }

    public void reverse(Matrix C) {
        if (columns != 0 ) {
            if(determinant!=0){

                int[][] c = new int[columns][columns];

                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < columns; j++) {
                        c[i][j] = content[i][j]/(int)determinant;
                    }
                    System.out.println();
                }

                C.setContent(c);

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }

    }

}
