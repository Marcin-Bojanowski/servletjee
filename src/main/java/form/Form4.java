package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post4")
public class Form4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aValue = Integer.parseInt(request.getParameter("aValue"));
        int bValue = Integer.parseInt(request.getParameter("bValue"));
        int cValue = Integer.parseInt(request.getParameter("cValue"));
        double delta=bValue*bValue-4*aValue*cValue;
        if (delta<0){
            response.getWriter().println("Delta mniejsza od 0!");
        } else {
            double xOne=(-bValue-Math.sqrt(delta))/2*aValue;
            double xTwo=(-bValue+Math.sqrt(delta))/2*aValue;
            StringBuilder builder=new StringBuilder();
            builder.append("Pierwiastki równania wynoszą: ").append(xOne).append(" oraz ").append(xTwo);
            response.getWriter().println(builder.toString());
        }
    }


}
