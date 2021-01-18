package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get3")
public class Get3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String widthParam = request.getParameter("width");
        String heightParam = request.getParameter("height");
        if (widthParam != null && heightParam != null) {
            try {
                int width = Integer.parseInt(widthParam);
                int height = Integer.parseInt(heightParam);
                for (int i = 1; i <= height; i++) {
                    for (int j = 1; j <= width; j++) {
                        response.getWriter().print(i*j+" ");
                    }
                    response.getWriter().println();
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

        } else {
            int width = 5;
            int height = 10;
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    response.getWriter().print(i*j+" ");
                }
                response.getWriter().println();
            }
        }
    }
}