package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get1")
public class Get1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startParam = request.getParameter("start");
        String endParam = request.getParameter("end");
        if (startParam != null && endParam != null) {
            try {
                int start = Integer.parseInt(startParam);
                int end = Integer.parseInt(endParam);
                if (start<end){
                    for (int i = start; i <= end; i++) {
                        response.getWriter().println(i);
                    }
                } else {
                    response.getWriter().println("Start mniejszy od end");
                }

            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }

        } else {
            response.getWriter().println("Brak");
        }
    }
}
