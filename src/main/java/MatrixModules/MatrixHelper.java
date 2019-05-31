package MatrixModules;

import java.util.Random;

public class MatrixHelper extends Matrix {

    protected InputHelper inputHelper = new InputHelper();
    private final Random random = new Random();

    public void setInputHelper(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public int oneRandomInt(int n) {
        return random.nextInt(n);
    }

    public double oneRandomDouble(int znakiDoZap,int znakiPosleZap ){
        int n = oneRandomInt((int)Math.pow(10.0,(double) znakiDoZap)) ;
        int m = oneRandomInt((int)Math.pow(10.0,(double) znakiPosleZap));
        double f = n+m/Math.pow(10.0,(double) znakiPosleZap);
        return f;
    }

}
