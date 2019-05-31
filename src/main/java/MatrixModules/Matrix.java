package MatrixModules;


import java.lang.reflect.Array;
import java.util.TreeSet;

public class Matrix<ElType> {
    private Numeric<ElType> ZERO;
    private Class<Numeric<ElType>> clazz;

    private int columns = 0;
    private int rows = 0;
    private Numeric<ElType>[][] content;
    private Numeric<ElType> determinant;

    public Matrix(Numeric<ElType> ZERO, Class<Numeric<ElType>> clazz) {
        this.ZERO = ZERO;
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Matrix))
            return false;
        Matrix B = (Matrix) obj;
        if (rows == B.getRows() && columns == B.getColumns()) {
            Numeric<ElType>[][] b = B.getContent();
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    if (!content[i][j].equals(b[i][j])) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }


    public void setDeterminant(Numeric<ElType> determinant) {
        this.determinant = determinant;
    }

    public Numeric<ElType> getDeterminant() {
        return determinant;
    }

    public void setContent(Numeric<ElType>[][] content) {
        this.content = content;
    }

    public Numeric<ElType>[][] getContent() {
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


    private Numeric<ElType> determinant(Numeric<ElType>[][] a, int n) {

        Numeric<ElType> tempD = this.ZERO;
        if (n == 1) {
            tempD = a[0][0];
        } else if (n == 2) {
            tempD = a[0][0].mult(a[1][1]).sub(a[1][0].mult(a[0][1]));
        } else { // NxN matrix
            for (int j1 = 0; j1 < n; j1++) {
                Numeric<ElType>[][] t = deteminantMinor(a, n, j1);
                tempD = tempD.sum(a[0][j1].mult(Math.pow(-1.0, 1.0 + j1 + 1.0)).mult(determinant(t, n - 1)));
            }
        }
        return tempD;
    }

    @SuppressWarnings("unchecked")
    private Numeric<ElType>[][] deteminantMinor(Numeric<ElType>[][] A, int n, int j1) {

        Numeric<ElType>[][] t = (Numeric<ElType>[][]) Array.newInstance(this.clazz, n, n);
        for (int i = 1; i < n; i++) {
            int j2 = 0;
            for (int j = 0; j < n; j++) {
                if (j == j1){
                    continue;
                }
                t[i - 1][j2] = A[i][j];
                j2++;
            }
        }
        Array.newInstance();
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
            determinant();
            if (determinant.equalsZero()) {
                // Нет определителя - нет обратной матрицы
                return C;
            }
            Numeric<ElType>[][] c = new Numeric<ElType>[columns][rows];

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
        System.out.println("Матрица " + Name + ": ");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(content[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void print() {
        System.out.println("Матрица : ");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(content[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public Matrix sum(Matrix A, Matrix B) {
        Matrix C = new Matrix();
        if (A.getColumns() != 0 && B.getColumns() != 0) {

            if (A.getColumns() == B.getColumns()) {

                Numeric<ElType>[][] a = A.getContent();
                Numeric<ElType>[][] b = B.getContent();
                Numeric<ElType>[][] c = new Numeric<ElType>[B.getColumns()][B.getColumns()];

                for (int i = 0; i < B.getColumns(); i++) {
                    for (int j = 0; j < B.getColumns(); j++) {
                        c[i][j] = a[i][j].sum(b[i][j]);
                    }

                }

                C.setContent(c);
                C.setColumns(B.getColumns());
                C.setRows(B.getColumns());

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }
        return C;
    }

    public Matrix sub(Matrix A, Matrix B) {
        Matrix C = new Matrix();
        if (A.getColumns() != 0 && B.getColumns() != 0) {


            if (A.getColumns() == B.getColumns()) {

                Numeric<ElType>[][] a = A.getContent();
                Numeric<ElType>[][] b = B.getContent();
                Numeric<ElType>[][] c = new Numeric<ElType>[B.getColumns()][B.getColumns()];

                for (int i = 0; i < B.getColumns(); i++) {
                    for (int j = 0; j < B.getColumns(); j++) {
                        c[i][j] = a[i][j].sub(b[i][j]);
                    }

                }

                C.setContent(c);
                C.setColumns(B.getColumns());
                C.setRows(B.getColumns());

            } else {
                System.out.print("Размерность матриц не совпадает");
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }
        return C;
    }

    public Matrix mult(Matrix A, Matrix B) {
        Matrix C = new Matrix();
        if (A.getColumns() != 0 && B.getColumns() != 0) {

            if ((B.getColumns() == B.getRows() &&
                    B.getColumns() == 1)
                    ||
                    (A.getColumns() == A.getRows() &&
                            A.getColumns() == 1)) {
                if (B.getRows() == 1) {
                    C.setContent(A.getContent());
                    C.setColumns(A.getColumns());
                    C.setRows(A.getRows());
                } else {
                    C.setContent(B.getContent());
                    C.setColumns(B.getColumns());
                    C.setRows(B.getRows());
                }
            } else {

                if (A.getColumns() == B.getRows() ||
                        A.getRows() == B.getColumns()) {

                    int[][] a = A.getContent();
                    int[][] b = B.getContent();
                    int[][] c = new int[B.getColumns()][B.getRows()];

                    for (int i = 0; i < A.getColumns(); ++i)
                        for (int j = 0; j < B.getRows(); ++j)
                            for (int k = 0; k < B.getColumns(); ++k)
                                c[i][j] += a[i][k] * b[k][j];

                    C.setContent(c);
                    C.setColumns(A.getColumns());
                    C.setRows(B.getRows());

                } else {
                    System.out.print("Размерность матриц не совпадает");
                    throw new IllegalMatrixDimensionException("Нельзя перемножать матрицы разного размера");
//                    throw new IllegalArgumentException();
                }
            }


        } else {
            System.out.print("Одна из матриц не введена");
        }
        return C;
    }


}
