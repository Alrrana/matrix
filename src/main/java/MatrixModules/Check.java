package MatrixModules;

public class Check {
    public static void main(String[] args) {

        Matrix A = new Matrix(new MyInt(0));
        MatrixIntHelper matrixIntHelper = new MatrixIntHelper();
        A = matrixIntHelper.createRandom(5, 5);
        A.print();

        A.determinant();
        System.out.println( A.getDeterminant().getValue());


        Matrix B = matrixIntHelper.createRandom(5,5);

        Matrix C = new Matrix(new MyInt(0));
        C.sum(A, B);
        C.print();

//        Matrix<Integer> matrix = new Matrix<>();

        MatrixDblHelper matrixDblHelper = new MatrixDblHelper();
        Matrix R = matrixDblHelper.createRandom(3,4);
        R.print();




    }
}
