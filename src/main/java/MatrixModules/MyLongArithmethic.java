package MatrixModules;

import LongMath.*;

public class MyLongArithmethic implements Numeric<LongArithmethic> {

    LongArithmethic value = new LongArithmethicImpl();

    public MyLongArithmethic(LongArithmethic value) {
        this.value = value;
    }

    @Override
    public boolean equals(Numeric<LongArithmethic> a) {
        if (this.getValue() == null || a.getValue() == null)
            return false;
        if (this.value.compareTo(a.getValue()) == 0)
            return true;
        else return false;
    }

    @Override
    public boolean equalsZero() {
        return false;

    }

    @Override
    public Numeric<LongArithmethic> sum(Numeric<LongArithmethic> a) {
//        return null;
        return new MyLongArithmethic(LongArithmeticMath.sum(value, a.getValue()));
    }
    @Override
    public String toString() {
        return this.getValue().toString();
    }
    @Override
    public Numeric<LongArithmethic> sub(Numeric<LongArithmethic> a) {
        return new MyLongArithmethic(LongArithmeticMath.sub(value, a.getValue()));
    }

    @Override
    public Numeric<LongArithmethic> mult(Numeric<LongArithmethic> a) {
        return new MyLongArithmethic(LongArithmeticMath.mul(value, a.getValue()));
    }

    @Override
    public Numeric<LongArithmethic> mult(double a) {
        return new MyLongArithmethic(LongArithmeticMath.mul(value,
                new LongArithmethicImpl(
                        Integer.toString(((Double) a).intValue())
                )));
    }

//    public static void main(String[] args) {
//        Double a = 2.0;
//        new LongArithmethicImpl(
//                Integer.toString(((Double) a).intValue())
//        );
//    }

    @Override
    public Numeric<LongArithmethic> div(Numeric<LongArithmethic> a) {
        return new MyLongArithmethic(LongArithmeticMath.div(value, a.getValue()));
    }

    @Override
    public LongArithmethic getValue() {
        return value;
    }


}
