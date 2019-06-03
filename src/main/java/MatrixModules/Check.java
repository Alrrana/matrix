package MatrixModules;

public class Check {
    public static void main(String[] args) {

        Matrix A = new Matrix(new MyInt(0));
        MatrixIntHelper matrixIntHelper = new MatrixIntHelper();
        MatrixDblHelper caster = new MatrixDblHelper();
        A = matrixIntHelper.createRandom(5, 5);
        A.print("A");

        Matrix R = caster.cast(A);
        R.print("R");

        A.determinant();
        System.out.println(A.getDeterminant().getValue());


//        Matrix B = matrixIntHelper.createRandom(5, 5);
//        B.print("B");
//
//        Matrix C = new Matrix(new MyInt(0));
//        C = A.sum(B);
//        C.print("Sum of A and B");
//
//        C = A.sub(B);
//        C.print("A minus B");
//
//        C = A.mult(B);
//        C.print("A mult B");

//        Matrix<Integer> matrix = new Matrix<>();

//        MatrixDblHelper matrixDblHelper = new MatrixDblHelper();
//        R = matrixDblHelper.createRandom(3, 4);
//        R.print();


    }
}
