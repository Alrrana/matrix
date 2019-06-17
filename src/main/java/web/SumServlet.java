package web;

import MatrixModules.*;

//import javax.servlet.annotation.WebServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

public class SumServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("matrixA") != null && session.getAttribute("matrixB") != null) {
            Matrix A = (Matrix) session.getAttribute("matrixA");
            Matrix B = (Matrix) session.getAttribute("matrixB");
            Matrix C = A.sum(B);
            request.setAttribute("MatrixRes", C);
            session.setAttribute("MatrixRes", C);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
