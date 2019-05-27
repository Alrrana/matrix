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

    public void transposition(MatrixReal B) {
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


    }
   }
