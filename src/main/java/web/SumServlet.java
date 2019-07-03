package web;

import MatrixModules.Matrix;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

public class SumServlet extends OperationServlet {
    private OperationPossibilityChecker checker = new SumChecker();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected OperationPossibilityChecker getChecker() {
        return checker;
    }

    @Override
    protected Matrix doOperation(Matrix A, Matrix B) {

        return A.sum(B);
    }

}
