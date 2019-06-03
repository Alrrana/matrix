package MatrixModules;

public interface Numeric<T> {
    boolean equals(Numeric<T> a);
    boolean equalsZero();

    Numeric<T> sum(Numeric<T> a);

    Numeric<T> sub(Numeric<T> a);

    Numeric<T> mult(Numeric<T> a);
    Numeric<T> mult(double a);

    Numeric<T> div(Numeric<T> a);
    T getValue();

}
