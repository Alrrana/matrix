package MatrixModules;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Random;

public class Matrix<ElType> {


    private Numeric<ElType> ZERO;

    private int columns = 0;
    private int rows = 0;
    private List<List<Numeric<ElType>>> content;
    private Numeric<ElType> determinant;

    public Matrix(Numeric<ElType> ZERO) {
        this.ZERO = ZERO;
    }

    Matrix (){
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Matrix))
            return false;
        Matrix B = (Matrix) obj;
        if (rows == B.getRows() && columns == B.getColumns()) {
            List<List<Numeric<ElType>>> b = B.getContent();
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    if (!content.get(i).get(j).equals(b.get(i).get(j))) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public Numeric<ElType> getZERO() {
        return ZERO;
    }

    public void setZERO(Numeric<ElType> ZERO) {
        this.ZERO = ZERO;
    }




    public void setDeterminant(Numeric<ElType> determinant) {
        this.determinant = determinant;
    }

    public Numeric<ElType> getDeterminant() {
        return determinant;
    }

    public void setContent(List<List<Numeric<ElType>>> content) {
        this.content = content;
    }

    public List<List<Numeric<ElType>>> getContent() {
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


    private Numeric<ElType> determinant(List<List<Numeric<ElType>>> a, int n) {

        Numeric<ElType> tempD = this.ZERO;
        if (n == 1) {
            tempD = a.get(0).get(0);
        } else if (n == 2) {
            tempD = a.get(0).get(0).mult(a.get(1).get(1)).sub(a.get(1).get(0).mult(a.get(0).get(1)));
        } else { // NxN matrix
            for (int j1 = 0; j1 < n; j1++) {
                List<List<Numeric<ElType>>> t = deteminantMinor(a, n, j1);
                tempD = tempD.sum(a.get(0).get(j1).mult(Math.pow(-1.0, 1.0 + j1 + 1.0)).mult(determinant(t, n - 1)));
            }
        }
        return tempD;
    }

    @SuppressWarnings("unchecked")
    private List<List<Numeric<ElType>>> deteminantMinor(List<List<Numeric<ElType>>> A, int n, int j1) {

        List<List<Numeric<ElType>>> t = new ArrayList<>();
        for(int i = 0; i<columns;i++){
            t.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int j2 = 0;
            for (int j = 0; j < n; j++) {
                if (j == j1) {
                    continue;
                }
                t.get(i - 1).add(A.get(i).get(j));
                j2++;
            }
        }
        return t;
    }


    public Matrix transposition() {
        Matrix C = new Matrix(this.getZERO());
        if (columns != 0) {
            if (columns == rows) {
                List<List<Numeric<ElType>>> c = new ArrayList<>();
                for(int i = 0; i<columns;i++){
                    c.add(new ArrayList<>());
                }
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        c.get(j).add(content.get(i).get(j));
                    }
                }
                C.setContent(c);
                C.setRows(rows);
                C.setColumns(columns);
            } else {
                System.out.print("Размерности матрицы не совпадают");
            }
        } else {
            System.out.print("Матрица не введена");

        }
        return C;

    }

    public Matrix reverse() {
        Matrix C = new Matrix(this.getZERO());
        if (columns != 0) {
            determinant();
            if (determinant.equalsZero()) {
                // Нет определителя - нет обратной матрицы
                return C;
            }
            List<List<Numeric<ElType>>> c = new ArrayList<>();
            for(int i = 0; i<columns;i++){
                c.add(new ArrayList<>());
            }

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    c.get(i).add(determinant(Minor(content, i, j), rows - 1).mult(Math.pow(-1.0, i + j)).div(determinant));
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

    private List<List<Numeric<ElType>>> Minor(List<List<Numeric<ElType>>> a, int I, int J) {

        List<List<Numeric<ElType>>> t = new ArrayList<>();
        for(int i = 0; i<columns;i++){
            t.add(new ArrayList<>());
        }
        for (int i = 0; i < columns; i++) {
            boolean isRowDeleted = I < i;
            int resultRowIndex = isRowDeleted ? i - 1 : i;
            for (int j = 0; j < rows; j++) {
                boolean isColDeleted = J < j;
                int resultColIndex = isColDeleted ? j - 1 : j;

                if (I != i && J != j)
                    t.get(resultRowIndex).add(a.get(i).get(j));
            }
        }
        return t;
    }


    public void print(String Name) {
        System.out.println("Матрица " + Name + ": ");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(content.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public void print() {
        System.out.println("Матрица : ");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(content.get(i).get(j).getValue() + "\t");
            }
            System.out.println();
        }
    }


    public Matrix sum(Matrix A, Matrix B) {
        Matrix C = new Matrix(A.getZERO());
        if (A.getColumns() != 0 && B.getColumns() != 0) {

            if (A.getColumns() == B.getColumns()) {

                List<List<Numeric<ElType>>> a = A.getContent();
                List<List<Numeric<ElType>>> b = B.getContent();
                List<List<Numeric<ElType>>> c = new ArrayList<>();
                for(int i = 0; i<columns;i++){
                    c.add(new ArrayList<>());
                }


                for (int i = 0; i < B.getColumns(); i++) {
                    for (int j = 0; j < B.getColumns(); j++) {
                        c.get(i).add(a.get(i).get(j).sum(b.get(i).get(j))); //ToDo
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
        Matrix C = new Matrix(A.getZERO());
        if (A.getColumns() != 0 && B.getColumns() != 0) {


            if (A.getColumns() == B.getColumns()) {

                List<List<Numeric<ElType>>> a = A.getContent();
                List<List<Numeric<ElType>>> b = B.getContent();
                List<List<Numeric<ElType>>> c = new ArrayList<>();
                for(int i = 0; i<columns;i++){
                    c.add(new ArrayList<>());
                }
                for (int i = 0; i < B.getColumns(); i++) {
                    for (int j = 0; j < B.getColumns(); j++) {
                        c.get(i).add(a.get(i).get(j).sub(b.get(i).get(j)));
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
        Matrix C = new Matrix(A.getZERO());
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

                    List<List<Numeric<ElType>>> a = A.getContent();
                    List<List<Numeric<ElType>>> b = B.getContent();
                    List<List<Numeric<ElType>>> c = new ArrayList<>();
                    for(int i = 0; i<columns;i++){
                        c.add(new ArrayList<>());
                    }

                    Numeric<ElType> temp = ZERO;

                    for (int i = 0; i < A.getColumns(); ++i) {
                        for (int j = 0; j < B.getRows(); ++j) {
                            temp=ZERO;
                            for (int k = 0; k < B.getColumns(); ++k) {
                                temp = temp.sum(a.get(i).get(k).mult(b.get(k).get(j)));
                            }
                            c.get(i).add(temp);
                        }
                    }

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

    //////////////////////////////////////////////////////////////////////////////////////////////////////  

}
