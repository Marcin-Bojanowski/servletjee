package session;

import pl.coderslab.classes.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
public class Session4 extends HttpServlet {
    public static final String CART_ITEMS = "cartItems";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if ("add".equals(request.getParameter("submit"))) {
            CartItem cartItem = new CartItem(
                    request.getParameter("name"),
                    Integer.parseInt(request.getParameter("quantity")),
                    Double.parseDouble(request.getParameter("price")));

            if (session.getAttribute(CART_ITEMS) == null) {
                session.setAttribute(CART_ITEMS, new ArrayList<CartItem>());
            }
            List<CartItem> cartItems = (List<CartItem>) session.getAttribute(CART_ITEMS);
            cartItems.add(cartItem);
            session.setAttribute(CART_ITEMS, cartItems);
            response.sendRedirect("/session4.html");
        } else if ("show".equals(request.getParameter("submit"))) {

            List<CartItem> cartItems = (List<CartItem>) session.getAttribute(CART_ITEMS);
            double totalSum = 0;
            for (CartItem item : cartItems) {
                response.getWriter().println(
                        item.getName() + " - " + item.getQuantity() + " x " + item.getPrice() + "zł = " + item.getPrice() * item.getQuantity() + "zł<br>");
                totalSum += item.getPrice() * item.getQuantity();
            }
            response.getWriter().println("SUMA: " + totalSum + "zł");
        }
    }


}
