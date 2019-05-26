package MatrixModules;

public class InputHelperStub extends InputHelper {

    private int i = -1;
    private String[] in;

    void setIn(String[] in) {
        this.in = in;
    }

    public String input() {
        i++;
        return in[i];
    }


}