package MatrixModules;

public class MyDouble implements Numeric<Double> {
    private Double value;

    public MyDouble(Double value) {
        this.value = value;
    }

    public MyDouble(Integer value) {
        double val = (double) value;
        this.value = val;
    }

    @Override
    public boolean equalsZero() {
        if (this.value == 0.0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
    @Override
    public boolean equals(Numeric<Double> a) {
        if (this.getValue() == null || a.getValue() == null)
            return false;
        if (Math.abs(this.getValue() - a.getValue()) < 0.000001)
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
    public Numeric<Double> div(Numeric<Double> a) {
        return new MyDouble(this.getValue() / a.getValue());
    }

    @Override
    public Double getValue() {
        return value;
    }
}
