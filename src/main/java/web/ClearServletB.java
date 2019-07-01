package web;

import MatrixModules.Matrix;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ClearServletB extends HttpServlet {

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();



        request.setAttribute("matrixB", null);
        session.setAttribute("matrixB", null);

//        request.setAttribute("matrixBcols", null);
//        session.setAttribute("matrixBcols", null);
//
//        request.setAttribute("matrixBrows", null);
//        session.setAttribute("matrixBrows", null);


        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
