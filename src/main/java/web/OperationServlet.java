package web;


import MatrixModules.Matrix;
import MatrixModules.MatrixTypeDetector;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public abstract class OperationServlet extends HttpServlet {

    /**
     * Метод возвращает экземпляр интерфейса, поверяющего допустимость конкретной операции.
     *
     * @return экземпляр OperationPossibilityChecker
     */
    protected abstract OperationPossibilityChecker getChecker();

    MatrixTypeDetector matrixTypeDetector = new MatrixTypeDetector();


    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer aCols = (Integer) session.getAttribute("matrixAcols");
        Integer aRows = (Integer) session.getAttribute("matrixArows");
        Integer bCols = (Integer) session.getAttribute("matrixBcols");
        Integer bRows = (Integer) session.getAttribute("matrixBrows");

        if (!(getChecker().isPossible(aCols, aRows, bCols, bRows))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        if (matrixNotNull(session)) {

            Matrix A = (Matrix) session.getAttribute("MatrixA");
            Matrix B = (Matrix) session.getAttribute("MatrixB");
//            System.out.println(A.getContent()+"    "+B.getContent());
            Matrix C = doOperation(A, B);

            returnRes(request, session, C);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(C.toJSON());
            out.flush();

        }

//
//        String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        String[] temp = test.split("@");
//        String masA = temp[0];
//        String masB = temp[1];
//
//        Matrix A = matrixTypeDetector.giveMeMatrix(masA);
//        Matrix B = matrixTypeDetector.giveMeMatrix(masB);
//
//        if (!(getChecker().isPossible(A.getColumns(), A.getRows(), B.getColumns(), B.getRows()))) {
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            return;
//        }
//
//
////            System.out.println(A.getContent()+"    "+B.getContent());
//        Matrix C = doOperation(A, B);
//
//
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.print(C.toJSON());
//        out.flush();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        JSONObject jsonObject = new JSONObject(request);
        String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        String[] temp = test.split("@");
        String masA = temp[0];
        String masB = temp[1];

        Matrix A = matrixTypeDetector.giveMeMatrix(masA);
        Matrix B = matrixTypeDetector.giveMeMatrix(masB);

        if (!(getChecker().isPossible(A.getColumns(), A.getRows(), B.getColumns(), B.getRows()))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }


//            System.out.println(A.getContent()+"    "+B.getContent());
        Matrix C = doOperation(A, B);


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(C.toJSON());
        out.flush();


    }


    protected void returnRes(HttpServletRequest request, HttpSession session, Matrix c) {
        request.setAttribute("MatrixRes", c);
        session.setAttribute("MatrixRes", c);
    }

    protected boolean matrixNotNull(HttpSession session) {
        return (session.getAttribute("MatrixA") != null && session.getAttribute("MatrixB") != null);
    }

    /**
     * Метод инкапсулирует бинарную операцию над матрицами
     *
     * @param A первый операнд
     * @param B второй операнд
     * @return результат выполнения операции в виде экземпляра Matrix
     */
    protected abstract Matrix doOperation(Matrix A, Matrix B);


}
