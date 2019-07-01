package web;

import MatrixModules.Matrix;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ClearServletA extends HttpServlet {

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        request.setAttribute("matrixA", null);
        session.setAttribute("matrixA", null);

//        request.setAttribute("matrixAcols", null);
//        session.setAttribute("matrixAcols", null);
//
//        request.setAttribute("matrixArows", null);
//        session.setAttribute("matrixArows", null);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
