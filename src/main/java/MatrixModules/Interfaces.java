package MatrixModules;

interface Numeric<T> {
    boolean equals(Numeric<T> a);
    boolean equalsZero();

    Numeric<T> sum(Numeric<T> a);

    Numeric<T> sub(Numeric<T> a);

    Numeric<T> mult(Numeric<T> a);
    Numeric<T> mult(double a);

    T getValue();

}

class MyInt implements Numeric<Integer> {
    private Integer value;

    public MyInt(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Numeric<Integer> a) {
        if(this.getValue()==null || a.getValue() ==null)
        return false;
        if(this.getValue()==a.getValue())
            return true;
        else
            return false;
    }

    @Override
    public boolean equalsZero() {
        if(this.value==0)
            return true;
        return false;
    }

    @Override
    public Numeric<Integer> sum(Numeric<Integer> a) {
        return new MyInt(this.getValue() + a.getValue());
    }

    @Override
    public Numeric<Integer> sub(Numeric<Integer> a) {
        return new MyInt(this.getValue() - a.getValue());
    }

    @Override
    public Numeric<Integer> mult(Numeric<Integer> a) {
        return new MyInt(this.getValue() * a.getValue());
    }

    public Numeric<Integer> mult(double a) {
        return new MyInt(this.getValue() * (int)a);
    }

    @Override
    public Integer getValue() {
        return value;
    }

}

class MyDouble implements Numeric<Double> {
    private Double value;

    public MyDouble(Double value) {
        this.value = value;
    }
    @Override
    public boolean equalsZero() {
        if(this.value==0.0)
            return true;
        return false;
    }


    @Override
    public boolean equals(Numeric<Double> a) {
        if(this.getValue()==null || a.getValue() ==null)
            return false;
        if(this.getValue()-a.getValue()<0.000001)
            return true;
        else
            return false;
    }

    @Override
    public Numeric<Double> sum(Numeric<Double> a) {
        return new MyDouble(this.getValue() + a.getValue());
    }

    @Override
    public Numeric<Double> sub(Numeric<Double> a) {
        return new MyDouble(this.getValue() - a.getValue());
    }

    @Override
    public Numeric<Double> mult(Numeric<Double> a) {
        return new MyDouble(this.getValue() * a.getValue());
    }

    public Numeric<Double> mult(double a) {
        return new MyDouble(this.getValue() * a);
    }

    @Override
    public Double getValue() {
        return value;
    }
}




interface Integers extends Numeric<Integer> {

}

interface Doubles extends Numeric<Double> {

}


//public class ForInts<T extends Number> implements Integers1<Integer> {
//    @Override
//    public boolean equals(Integer a, Integer b) {
//        if (a == null || b == null)
//            return false;
//        if (a - b != 0)
//            return false;
//        else return true;
//    }
//
//    @Override
//    public Integer sum(Integer a, Integer b) {
//        return a + b;
//    }
//
//    @Override
//    public Integer mult(Integer a, Integer b) {
//        return a * b;
//    }
//
//    @Override
//    public Integer sub(Integer a, Integer b) {
//        return a - b;
//    }
//}
