package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/session5")
public class Session5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int a = new Random().nextInt(100);
        int b = new Random().nextInt(100);

        int requiredResult = a + b;
        request.getSession().setAttribute("captchaResult", requiredResult);

        response.getWriter().append(
                "<form action=\"\" method=\"POST\">\n" +
                        "    <label>\n" +
                        "        Imie:\n" +
                        "        <input type=\"text\" name=\"name\">\n" +
                        "    </label>\n" +
                        "    <label>\n" +
                        "        Nazwisko:\n" +
                        "        <input type=\"text\" name=\"surname\">\n" +
                        "    </label>\n" +
                        "    <label>\n" +
                        "        email:\n" +
                        "        <input type=\"text\" name=\"email\">\n" +
                        "    </label>\n" +
                        "    <label>\n" +
                        a + " + " + b + " = " +
                        "        <input type=\"number\" name=\"captcha\">\n" +
                        "    </label>\n" +
                        "    <input type=\"submit\">\n" +
                        "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        if (Integer.parseInt(req.getParameter("captcha"))
                == ((int) req.getSession().getAttribute("captchaResult"))) {
            resp.getWriter().println(req.getParameter("name") + " - podałeś poprawną wartość, nie jesteś robotem");
        } else {
            resp.getWriter().println("Jesteś robotem");
        }
    }
}

