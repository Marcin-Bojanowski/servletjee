package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post5")
public class Form5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result = request.getParameter("convertionType");
        double temp = Double.parseDouble(request.getParameter("degrees"));
        double degrees = 0;
        if ("celcToFahr".equals(result)) {
            degrees = 32 + (9.0 / 5.0) * temp;
            response.getWriter().println(degrees);
        } else {
            degrees = (5.0 / 9.0) * (temp - 32);
            response.getWriter().println(degrees);
        }
    }


}
