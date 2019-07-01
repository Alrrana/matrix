package web;

import MatrixModules.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

public class SumServlet extends OperationServlet {
    private OperationPossibilityChecker checker = new SumChecker();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    boolean operationIsPossible(Integer aCols, Integer aRows, Integer bCols, Integer bRows) {
        return checker.isPossible(aCols, aRows, bCols, bRows);
    }

    @Override
    Matrix doOperation(Matrix A, Matrix B) {
        return A.sum(B);
    }
}
