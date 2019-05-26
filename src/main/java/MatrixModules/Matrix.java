package MatrixModules;

public class Matrix {
    private int columns;
    private int rows;
    private int[][] content;

    public void setContent(int[][] content) {
        this.content = content;
    }

    public int[][] getContent() {
        return content;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
