package MatrixModules;

import java.util.Random;

public class MatrixHelper {

    protected InputHelper inputHelper = new InputHelper();
    private final Random random = new Random();

    public void setInputHelper(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public int oneRandomInt() {
        return random.nextInt();
    }

    public void Create(int n) {

    }

    public void Create() {

    }


}
