package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/post2")
public class Form2 extends HttpServlet {
    private static List<String> BAD_WORDS = Arrays.asList("cholera", "dupa");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean aware = "true".equals(request.getParameter("aware"));

        String passedString = request.getParameter("enteredString");
        if (!aware) {
            for (String badWord : BAD_WORDS) {
                StringBuilder replacement = new StringBuilder();
                for (int i = 0; i < badWord.length(); i++) {
                    replacement.append("*");
                }
                passedString = passedString.replaceAll(badWord, replacement.toString());
            }
            response.getWriter().println(passedString);
        }

    }
}
