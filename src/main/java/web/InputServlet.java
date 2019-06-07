package web;

import MatrixModules.Matrix;
import MatrixModules.InputHelperStub;
import MatrixModules.MatrixIntHelper;

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

//@WebServlet(name = "InputServlet", urlPatterns = "/input")

public class InputServlet extends HttpServlet {


    MatrixIntHelper matrixHelper = new MatrixIntHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputHelperStub inputHelper = new InputHelperStub();
        matrixHelper.setInputHelper(inputHelper);

        String matrix = request.getParameter("matrix");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputHelperStub inputHelper = new InputHelperStub();
        matrixHelper.setInputHelper(inputHelper);
        Matrix A;
//        PrintWriter out = response.getWriter();

        String matrix = request.getParameter("matrix");
        if(matrix==null){
            request.setAttribute("sizeEx", "123");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        String[] firstSplitByN;
        List<String> secondSplitBySpace = new ArrayList<>();
        String[] temp;
        String[] it3;
        try {
            firstSplitByN = matrix.split("\r\n");

// Первый сплит на массив и список
            for (int i = 0; i < firstSplitByN.length; i++) {
                temp = firstSplitByN[i].split(" ");

                for (int j = 0; j < temp.length; j++) {
                    secondSplitBySpace.add(temp[j]);
                }
            }
//            сбор в массив из списка
            it3 = new String[secondSplitBySpace.size()];
            for (int i = 0; i < secondSplitBySpace.size(); i++) {
                it3[i] = secondSplitBySpace.get(i);
            }
//            заглушка на ввод
            inputHelper.setIn(it3);
//            проверка размерностей
            if ((secondSplitBySpace.size() / firstSplitByN.length) % 1 != 0) {
                request.setAttribute("sizeEx", "123");
                request.getRequestDispatcher("index.jsp").forward(request, response);
               // throw new IOException("Длина строк введенного массива не совпадает" + secondSplitBySpace.size() / firstSplitByN.length);

            }

            A = matrixHelper.create(firstSplitByN.length, secondSplitBySpace.size() / firstSplitByN.length);
            A.print("A");


            request.setAttribute("success", "123");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
//

    }
}


//    String[] firstSplitByN;
//        String[] secondSplitBySpace;
//
//        try{
//            firstSplitByN=matrix.split("\n");
//            secondSplitBySpace= matrix.split(" ");
//            if((secondSplitBySpace.length/firstSplitByN.length)%1 !=0){
//                throw new IOException("Длина строк введенного массива не совпадает" + secondSplitBySpace.length/firstSplitByN.length);
//            }
//            inputHelper.setIn(secondSplitBySpace);
//            A = matrixHelper.create(firstSplitByN.length, secondSplitBySpace.length/firstSplitByN.length);
//            A.print("A");
//
//        }catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
