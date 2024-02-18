package lesServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserWebService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            System.out.println("Adding user");

            String id = java.util.UUID.randomUUID().toString();
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String login = request.getParameter("login");
            String motDePasse = request.getParameter("motDePasse");
            String numeroTelephone = request.getParameter("numeroTelephone");
            String role = request.getParameter("role");


            Utulisateur nouvelUtilisateur = new Utulisateur(id, nom, prenom, login, motDePasse, numeroTelephone, role);

            utulisateurs.addUser(nouvelUtilisateur);

            System.out.println("User added");

            request.setAttribute("successMessage", "The user has been successfully added.");

        } catch (Exception e) { 
            e.printStackTrace();

            request.setAttribute("errorMessage", "Failed to add the user.");
        }

        request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);
    }
}