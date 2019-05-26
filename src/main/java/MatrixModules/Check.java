package MatrixModules;

public class Check {
    public static void main(String[] args) {
        Matrix A= new Matrix();
        MatrixHelper matrixHelper = new MatrixHelper();
        matrixHelper.setMatrixA(A);

        matrixHelper.createRandom(5);
        matrixHelper.print();
        A.determinant();
        System.out.println(A.getDeterminant());
    }
}
