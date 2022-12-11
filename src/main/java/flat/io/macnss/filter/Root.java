package flat.io.macnss.filter;

import flat.io.macnss.Config.Global;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class Root implements Filter {
    private String baseUrl;
    public void init(FilterConfig config) throws ServletException {
        this.baseUrl = Global.url;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();

        String requestedUrl = httpRequest.getRequestURL().toString();
        String loginUrl = this.baseUrl+"users/login";
        String resourcesUrl = this.baseUrl+"resources";

        if(session.getAttribute("person") == null && !loginUrl.equals(requestedUrl) && !requestedUrl.startsWith(resourcesUrl)){
            httpResponse.sendRedirect(Global.url+"users/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
