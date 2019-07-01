package web;

import MatrixModules.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

public class MultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer aCols = (Integer) session.getAttribute("matrixAcols");
        Integer aRows = (Integer) session.getAttribute("matrixArows");
        Integer bCols = (Integer) session.getAttribute("matrixBcols");
        Integer bRows = (Integer) session.getAttribute("matrixBrows");


        if ((aCols != null) && (bCols != null) && (aRows != null) && (bRows != null) &&
                ( (aCols.equals(bRows)) || (aRows.equals(bCols))
                || (aCols.equals(bCols) && aRows.equals(bRows)))
        ) {


            String answer = request.getParameter("mult");
            if ((session.getAttribute("matrixA") != null && session.getAttribute("matrixB") != null)
                    ) {
                Matrix A = (Matrix) session.getAttribute("matrixA");
                Matrix B = (Matrix) session.getAttribute("matrixB");
                Matrix C = A.mult(B);
                request.setAttribute("MatrixRes", C);
                session.setAttribute("MatrixRes", C);
            }
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
