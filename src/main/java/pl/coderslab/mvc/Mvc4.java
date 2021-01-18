package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc4")
public class Mvc4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = new ArrayList<Book>();
Book book1=new Book("Potop","Sienkiewicz",23423);
Book book2=new Book("Pan Tadeusz","Mickiewicz",9879843);
books.add(book1);
books.add(book2);
request.setAttribute("lista",books);
getServletContext().getRequestDispatcher("/resultList.jsp")
        .forward(request,response);

    }
}
