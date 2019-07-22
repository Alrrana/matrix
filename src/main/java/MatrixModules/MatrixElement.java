package MatrixModules;

public class MatrixElement {
    public String value;
    public Integer row;
    public Integer col;

    public MatrixElement() {
        this.value = "";
        this.row = 0;
        this.col = 0;
    }

    public MatrixElement(String value, Integer row, Integer col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
