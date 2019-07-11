package web;

import MatrixModules.Matrix;
import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


public class TestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String ipAddress = request.getRemoteAddr();
        String dateTime = new Date().toString();

        System.out.println("\n==============================================\n");

        System.out.println("Request...");
        System.out.println("Date/Time: " + dateTime);
        System.out.println("IP:" + ipAddress);

        System.out.println("\n==============================================\n");

        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();



        if (session.getAttribute("MatrixA") != null ) {
            Matrix matrixA = (Matrix) session.getAttribute("MatrixA");
            if (matrixA.getRows() > 1 || matrixA.getColumns() > 1) {
                chain.doFilter(request, response);
            } else {
                System.out.println("Нельзя осуществитть операцию с матрицей размерности 1х1");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
    }

    public void destroy() {

    }


}
