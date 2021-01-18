package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String cookieName = "cookie51";
            boolean cookieFound = false;
            for (Cookie c : cookies) {
                if (cookieName.equals(c.getName())) {
                    cookieFound = true;
                    c.setMaxAge(0);
                    response.addCookie(c);
                    response.getWriter().println("Witamy na stronie cookie52");
                }
            }
            if (!cookieFound) {
                response.getWriter().println("BRAK");
            }
        }
    }
}

