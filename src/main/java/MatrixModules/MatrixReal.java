package MatrixModules;

public class MatrixReal {
    private int columns = 0;
    private int rows = 0;
    private double[][] content;
    private long determinant;

    @Override
    public boolean equals(Object obj) {
        return equals((MatrixReal) obj);
    }

    public boolean equals(MatrixReal B) {
        boolean eq = true;
        if (rows == B.getRows() && columns == B.getColumns()) {
            double[][] b = B.getContent();
            for (int i = 0; i < columns && eq; i++) {
                for (int j = 0; j < columns && eq; j++) {
                    if (content[i][j] - b[i][j]>0.001) {
                        eq = false;
                    }
                }
            }
        } else {
            eq = false;
        }

        return eq;
    }


    public void setDeterminant(long determinant) {
        this.determinant = determinant;
    }

    public double getDeterminant() {
        return determinant;
    }

    public void setContent(double[][] content) {
        this.content = content;
    }

    public double[][] getContent() {
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

    public void print(String Name) {
        double[][] array = content;
        System.out.println("Матрица " + Name + ": ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void print() {
        double[][] array = content;
        System.out.println("Матрица : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public MatrixReal transposition() {
        MatrixReal B = new MatrixReal();
        if (columns != 0) {
            if (columns == rows) {
                double[][] b = new double[columns][rows];
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

        return B;
    }
    public void mult(Matrix A,MatrixReal B,MatrixReal C){
        if (A.getColumns() != 0 && B.getColumns() != 0) {

            if ((B.getColumns() == B.getRows() &&
                    B.getColumns() == 1)
                    ||
                    (A.getColumns() == A.getRows() &&
                            A.getColumns() == 1)) {
                if (B.getRows() == 1) {
                    double[][] c = new double[A.getColumns()][A.getRows()];
                    int[][] a = A.getContent();
                    for (int i = 0; i < A.getColumns(); ++i)
                        for (int j = 0; j < A.getRows(); ++j){
                            c[i][j]=(double)a[i][j];
                        }
                    C.setContent(c);
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
                    double[][] b = B.getContent();
                    double[][] c = new double[B.getColumns()][B.getRows()];

                    for (int i = 0; i < A.getColumns(); ++i)
                        for (int j = 0; j < B.getRows(); ++j)
                            for (int k = 0; k < B.getColumns(); ++k)
                                c[i][j] +=(double) a[i][k] * b[k][j];

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

    }

   }
