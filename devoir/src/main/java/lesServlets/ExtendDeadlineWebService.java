package lesServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ExtendDeadlineWebService")
public class ExtendDeadlineWebService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("offerId");
        String strDate = request.getParameter("nouvelleDateLimite");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateLimite = null;
        
        try {
            dateLimite = dateFormat.parse(strDate);

            AppleOffers.editExpirationDate(id, dateLimite);

            request.setAttribute("successMessage", "The deadline has been successfully extended.");
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to extend the deadline. Invalid date format.");
        }

        request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);
    }
}