package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/setCookie")
public class Cookie1Set extends HttpServlet {
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // parametr userName, jeżeli nie istnieje to CodersLab
        Cookie cookie = new Cookie("User",
                request.getParameter("userName") != null ? request.getParameter("userName") : "CodersLab");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }
}