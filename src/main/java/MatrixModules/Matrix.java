package MatrixModules;


import java.util.TreeSet;

public class Matrix<ElType extends INums> {
    private int columns = 0;
    private int rows = 0;
    private ElType[][] content;
    private ElType determinant;


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Matrix))
            return false;
        Matrix B = (Matrix) obj;
        if (rows == B.getRows() && columns == B.getColumns()) {
            int[][] b = B.getContent();
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {4
                    if (obj.getClass()==Integer.class)
                        if (content[i][j] != b[i][j]) {
                            return false;
                        }
                }
            }
        } else {
            return false;
        }

        return true;
         new TreeSet<String>();
    }


    public void setDeterminant(ElType determinant) {
        this.determinant = determinant;
    }

    public ElType getDeterminant() {
        return determinant;
    }

    public void setContent(ElType[][] content) {
        this.content = content;
    }

    public ElType[][] getContent() {
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

    private long determinant(ElType[][] a, int n) {

        long tempD = 0;
        if (n == 1) tempD = a[0][0];

        else if (n == 2) tempD = a[0][0] * a[1][1] - a[1][0] * a[0][1];
            // NxN matrix
        else {
            for (int j1 = 0; j1 < n; j1++) {
                int[][] t = deteminantMinor(a, n, j1);
                tempD += Math.pow(-1.0, 1.0 + j1 + 1.0) * a[0][j1] * determinant(t, n - 1);
            }
        }
        return tempD;
    }


    private ElType[][] deteminantMinor(ElType[][] A, int n, int j1) {
        ElType[][] t = new ElType[n - 1][n - 1];
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


    public void transposition(Matrix B) {
        if (columns != 0) {
            if (columns == rows) {
                int[][] b = new int[columns][rows];
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        b[j][i] = content[i][j];
                    }
                }
                B.setContent(b);
                B.setRows(rows);
                B.setColumns(columns);
            } else {
                System.out.print("Размерности матрицы не совпадают");
            }
        } else {
            System.out.print("Матрица не введена");
        }


    }

    public OldMatrixReal reverse() {
        OldMatrixReal C = new OldMatrixReal();
        if (columns != 0) {
            if (determinant == 0) {
                determinant();
            }
            double[][] c = new double[columns][rows];

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    c[i][j] = determinant(Minor(content, i, j), rows - 1) * Math.pow(-1.0, i + j) / determinant;
                }
                System.out.println();
            }


            C.setContent(c);
            C.setColumns(columns);
            C.setRows(rows);

            C = C.transposition();

        } else {
            System.out.print("Матрица не введена");
        }
        return C;

    }

    private int[][] Minor(int[][] a, int I, int J) {

        int[][] t = new int[columns - 1][rows - 1];
        for (int i = 0; i < columns; i++) {
            boolean isRowDeleted = I < i;
            int resultRowIndex = isRowDeleted ? i - 1 : i;
            for (int j = 0; j < rows; j++) {
                boolean isColDeleted = J < j;
                int resultColIndex = isColDeleted ? j - 1 : j;

                if (I != i && J != j)
                    t[resultRowIndex][resultColIndex] = a[i][j];
            }
        }
        return t;
    }


    public void print(String Name) {
        int[][] array = content;
        System.out.println("Матрица " + Name + ": ");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void print() {
        int[][] array = content;
        System.out.println("Матрица : ");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
