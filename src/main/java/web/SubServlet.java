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

public class SubServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer Acols = (Integer) session.getAttribute("matrixAcols");
        Integer Arows = (Integer) session.getAttribute("matrixArows");
        Integer Bcols = (Integer) session.getAttribute("matrixBcols");
        Integer Brows = (Integer) session.getAttribute("matrixBrows");

        if ((Acols != null) && (Bcols != null) && (Arows != null) && (Brows != null) &&
                ((Acols == Bcols && Arows == Brows))) {


            if (session.getAttribute("matrixA") != null && session.getAttribute("matrixB") != null) {
                Matrix A = (Matrix) session.getAttribute("matrixA");
                Matrix B = (Matrix) session.getAttribute("matrixB");
                Matrix C = A.sub(B);
                request.setAttribute("MatrixRes", C);
                session.setAttribute("MatrixRes", C);
            }
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
