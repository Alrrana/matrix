package web;


import MatrixModules.Matrix;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class OperationServlet extends HttpServlet {

    /**
     * Метод возвращает экземпляр интерфейса, поверяющего допустимость конкретной операции.
     *
     * @return экземпляр OperationPossibilityChecker
     */
    protected abstract OperationPossibilityChecker getChecker();

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer aCols = (Integer) session.getAttribute("matrixAcols");
        Integer aRows = (Integer) session.getAttribute("matrixArows");
        Integer bCols = (Integer) session.getAttribute("matrixBcols");
        Integer bRows = (Integer) session.getAttribute("matrixBrows");

        if (!(getChecker().isPossible(aCols, aRows, bCols, bRows))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        if (matrixNotNull(session)) {

            Matrix A = (Matrix) session.getAttribute("matrixA");
            Matrix B = (Matrix) session.getAttribute("matrixB");
//            System.out.println(A.getContent()+"    "+B.getContent());
            Matrix C = doOperation(A,B);

            returnRes(request, session, C );

        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void returnRes(HttpServletRequest request, HttpSession session, Matrix c) {
        request.setAttribute("MatrixRes", c);
        session.setAttribute("MatrixRes", c);
    }

    protected boolean matrixNotNull(HttpSession session) {
        return (session.getAttribute("matrixA") != null && session.getAttribute("matrixB") != null);
    }

    /**
     * Метод инкапсулирует бинарную операцию над матрицами
     *
     * @param A первый операнд
     * @param B второй операнд
     * @return результат выполнения операции в виде экземпляра Matrix
     */
    protected abstract Matrix doOperation(Matrix A, Matrix B);
}
