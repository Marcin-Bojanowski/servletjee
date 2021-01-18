package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    public static final String NOTE_LIST = "noteList";


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().append(
                "<form action=\"\" method=\"post\">\n" +
                        "    <input type=\"number\" name=\"note\" placeholder=\"Note\">\n" +
                        "    <input type=\"submit\" value=\"Send\">\n" +
                        "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String note = req.getParameter("note");
        if (note != null) {
            Integer parsedNote = Integer.parseInt(note);
            HttpSession session = req.getSession();
            if (session.isNew()) {
                session.setAttribute(NOTE_LIST, new ArrayList<Integer>());
            }
            List<Integer> noteList = (List<Integer>) session.getAttribute(NOTE_LIST);
            noteList.add(parsedNote);
            session.setAttribute(NOTE_LIST, noteList);
            Integer sum = 0;
            for (Integer i : noteList) {
                sum += i;
            }
            Double avg = (sum * 1.0d) / noteList.size();
            resp.getWriter().append("Average: " + avg);
        }
    }
}