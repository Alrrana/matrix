package LongMath;

enum LongConst {
    ZERO(new LongArithmethicImpl("0")),
    ONE(new LongArithmethicImpl("1")),
    TWO(new LongArithmethicImpl("2")) ;

    private LongArithmethic value;

    public LongArithmethic getValue() {
        return value;
    }

    LongConst(LongArithmethic value) {
        this.value = value;
    }

}
