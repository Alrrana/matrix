package MatrixModules;

public class MyInt implements Numeric<Integer> {
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
    public String toString() {
        return this.getValue().toString();
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
    public Numeric<Integer> div(Numeric<Integer> a) {
        return new MyInt(this.getValue() / a.getValue());
    }

    @Override
    public Integer getValue() {
        return value;
    }

}
