package lesServlets;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AuthentificationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
	    System.out.println("Attempting to filter" ); 

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String loginURI = httpRequest.getContextPath() + "/login.html"; 
        String createUserURI = httpRequest.getContextPath() + "/AddUserWebService"; 
        
        

        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI) || httpRequest.getRequestURI().endsWith("AuthenticationServlet");
        boolean isCreateUserRequest = httpRequest.getRequestURI().equals(createUserURI);

//        if (isLoginRequest || isCreateUserRequest || AuthentificationUtil.isAuthenticated(httpRequest)) {
            chain.doFilter(request, response);
//        } else {
//            httpResponse.sendRedirect(loginURI);
//        }  
        }




}
