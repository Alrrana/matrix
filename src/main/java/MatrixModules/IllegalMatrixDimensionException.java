package MatrixModules;

public class IllegalMatrixDimensionException extends IllegalArgumentException {
    private String msg;

    public IllegalMatrixDimensionException (String string) {
        this.msg = string;
        System.out.println("Exception IllegalMatrixDimensionException^ ");
    }

    public void Message() {
        System.err.println(msg);
    }
}
