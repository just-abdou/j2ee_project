package lesServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangePasswordWebService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        
        Utulisateur currentUser= AuthentificationUtil.getLoggedInUser(request);

        if (currentUser != null && currentUser.getMotDePasse().equals(oldPassword)) {
            currentUser.setMotDePasse(newPassword);
            
            utulisateurs.editUser(currentUser); 
            AuthentificationUtil.setLoggedInUser(request, currentUser);

            request.setAttribute("successMessage", "Mot de passe modifié avec succès.");
        } else {
            request.setAttribute("errorMessage", "Ancien mot de passe incorrect.");
        }

        request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);
    }
}