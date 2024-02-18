package lesServlets;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;

public class AuthentificationUtil {


	public static boolean isAuthenticated(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        Utulisateur user = (Utulisateur) session.getAttribute("loggedInUser");
	        return user != null;
	    }
	    
	    return false;
	}

	public static void setLoggedInUser(HttpServletRequest request, Utulisateur user) {
	    HttpSession session = request.getSession();
	    session.setAttribute("loggedInUser", user);
	}
  
    public static Utulisateur getLoggedInUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false); 
        
        if (session != null) {
            return (Utulisateur) session.getAttribute("loggedInUser");
        }
        
        return null; 
    }
    


}