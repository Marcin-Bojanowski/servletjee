package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class Zad2Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        String userAgent = ((HttpServletRequest) servletRequest).getHeader("User-Agent");
        System.out.println("USER AGENT: " + userAgent);

        long startTime = System.currentTimeMillis(); //ilośc milisekund od 1 stycznia 1970;
        filterChain.doFilter(servletRequest, servletResponse);
        long stopTime = System.currentTimeMillis();

        long requestTime = stopTime - startTime;
        System.out.println("Czas wykonania żądania: " + requestTime + "ms");
    }

    @Override
    public void destroy() {

    }
}
