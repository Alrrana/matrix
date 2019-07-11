package web;

import MatrixModules.Matrix;
import MatrixModules.MatrixTypeDetector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PlusOneToB extends OperationServlet {
    private OperationPossibilityChecker checker = new  SingleChecker("B");
    MatrixTypeDetector matrixTypeDetector = new MatrixTypeDetector();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected OperationPossibilityChecker getChecker() {
        return checker;
    }

    @Override
    protected Matrix doOperation(Matrix A, Matrix B) {
        //1. Создай матрицу нужной размерногсти из единичек
        int col = B.getColumns();
        int row = B.getRows();
        String[][] content = new String[col][row];
        for (int i = 0; i < col; i++)
            for (int j = 0; j < row; j++) {
                content[i][j] = "1";
            }

        //2. A + новая матрица
        Matrix A_New = matrixTypeDetector.gimmeMatrix(content);
        //3. Верни то, что получилось на шаге 2
        return B.sum(A_New);
    }

    @Override
    protected boolean matrixNotNull(HttpSession session) {
        return (session.getAttribute("MatrixB") != null);
    }


    @Override
    protected void returnRes(HttpServletRequest request, HttpSession session, Matrix c) {
        request.setAttribute("MatrixB", c);
        session.setAttribute("MatrixB", c);
    }

}
