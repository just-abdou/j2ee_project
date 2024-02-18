package lesServlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String login = request.getParameter("login");
	    String password = request.getParameter("password");

	    List<Utulisateur> userList = utulisateurs.getUsers();

	    System.out.println("Attempting to authenticate user: " + login); 

	    Utulisateur authenticatedUser = authenticateUser(login, password, userList);

	    if (authenticatedUser != null) {
	        System.out.println("Authentication successful for user: " + login); 

	        
	        AuthentificationUtil.setLoggedInUser(request, authenticatedUser);

	        request.getRequestDispatcher("/accueilAdmin.jsp").forward(request, response);
	    } else {
	        System.out.println("Authentication failed for user: " + login); 
	        response.sendRedirect("login.jsp?error=1");
	    }
	}
    private Utulisateur authenticateUser(String login, String password, List<Utulisateur> userList) {
        for (Utulisateur user : userList) {
            if (user.getLogin().equals(login.trim().toLowerCase()) && user.getMotDePasse().equals(password)) {
                return user; 
            }
        }
        return null;
    }


}
