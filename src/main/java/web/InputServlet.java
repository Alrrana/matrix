package web;

import MatrixModules.Matrix;
import MatrixModules.InputHelperStub;
import MatrixModules.MatrixIntHelper;

//import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

public class InputServlet extends HttpServlet {


    MatrixIntHelper matrixHelper = new MatrixIntHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InputHelperStub inputHelper = new InputHelperStub();
        matrixHelper.setInputHelper(inputHelper);

        String inp = request.getParameter("matrixA");

       // String[] t = request.getParameter("matrixA").split(" ");


//        inputHelper.setIn(t);
//        Matrix A = matrixHelper.create((int)Math.sqrt( t.length), (int)Math.sqrt( t.length));
//
//        inputHelper.setI(-1);
//        Matrix E = matrixHelper.create(5, 5);
//
//        A.print("A");
//        E.print("E");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
