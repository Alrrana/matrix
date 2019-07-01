package web;


import MatrixModules.Matrix;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class OperationServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer aCols = (Integer) session.getAttribute("matrixAcols");
        Integer aRows = (Integer) session.getAttribute("matrixArows");
        Integer bCols = (Integer) session.getAttribute("matrixBcols");
        Integer bRows = (Integer) session.getAttribute("matrixBrows");

        if (!(operationIsPossible(aCols, aRows, bCols, bRows))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        if (matrixNotNull(session)) {

            Matrix A = (Matrix) session.getAttribute("matrixA");
            Matrix B = (Matrix) session.getAttribute("matrixB");
            System.out.println(A.getContent()+"    "+B.getContent());
            Matrix C = doOperation(A,B);
            request.setAttribute("MatrixRes", C);
            session.setAttribute("MatrixRes", C);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    abstract boolean operationIsPossible(Integer aCols, Integer aRows, Integer bCols, Integer bRows);

    boolean matrixNotNull(HttpSession session) {
        return (session.getAttribute("matrixA") != null && session.getAttribute("matrixB") != null);
    }
    abstract Matrix doOperation(Matrix A, Matrix B);


}
