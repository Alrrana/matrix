package MatrixModules;

import LongMath.LongArithmeticImpl;

public class MyLongArithmethic implements Numeric<LongArithmeticImpl> {

    @Override
    public boolean equals(Numeric<LongArithmeticImpl> a) {
        return false;
    }

    @Override
    public boolean equalsZero() {
        return false;
    }

    @Override
    public Numeric<LongArithmeticImpl> sum(Numeric<LongArithmeticImpl> a) {
        return null;
    }

    @Override
    public Numeric<LongArithmeticImpl> sub(Numeric<LongArithmeticImpl> a) {
        return null;
    }

    @Override
    public Numeric<LongArithmeticImpl> mult(Numeric<LongArithmeticImpl> a) {
        return null;
    }

    @Override
    public Numeric<LongArithmeticImpl> mult(double a) {
        return null;
    }

    @Override
    public Numeric<LongArithmeticImpl> div(Numeric<LongArithmeticImpl> a) {
        return null;
    }

    @Override
    public LongArithmeticImpl getValue() {
        return null;
    }
}
