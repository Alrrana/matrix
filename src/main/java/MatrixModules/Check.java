package MatrixModules;

public class Check {
    public static void main(String[] args) {
        Matrix A = new Matrix(0,Numeric<Integer>);

        matrixHelper.createRandom(5);
        matrixHelper.print();
        A.determinant();

        Matrix B = new Matrix();

        matrixHelper.switchState();
        matrixHelper.createRandom(6);

        Matrix C = new Matrix();
        matrixHelper.mult(C);
        matrixHelper.print();
        C.print();

//        Matrix<Integer> matrix = new Matrix<>();

        System.out.println(A.getDeterminant());
        A.print();
        A.transposition(C);
        C.print();
        OldMatrixReal R = new OldMatrixReal();
        A.reverse(R);
        R.print();

        try {

            throw new ArithmeticException();
            // throw new IllegalAccessError();
        } catch (IllegalAccessError ex) {
            System.out.print("IllegalAccessError ex ");
        } catch (RuntimeException e) {
            System.out.print("RuntimeException e ");
//        } catch (ArithmeticException e) {
//            System.out.print("IllegalAccessError ex1 ");
        } finally {
            System.out.print("Finally block ");
        }


    }
}
