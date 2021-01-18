package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newCookieName = request.getParameter("key");
        String newCookieValue = request.getParameter("value");
        int newCookieTime=Integer.parseInt(request.getParameter("time"));
        Cookie newCookie = new Cookie(newCookieName, newCookieValue);
        newCookie.setMaxAge(newCookieTime*60*60);
        response.addCookie(newCookie);
        response.getWriter().println("Dodano ciastko");
    }


}
