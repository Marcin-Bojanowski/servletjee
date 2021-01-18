package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("counter") != null) {
            int counter = (int) session.getAttribute("counter") + 1;
            session.setAttribute("counter", counter);
            resp.getWriter().append("Licznik: " + counter);
        } else {
            resp.getWriter().append("EMPTY");
        }
    }
}

