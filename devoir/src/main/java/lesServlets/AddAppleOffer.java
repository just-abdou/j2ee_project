package lesServlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddAppleOffer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = java.util.UUID.randomUUID().toString();
        double budget = Double.parseDouble(request.getParameter("budget"));
        String organisme = request.getParameter("organisme");
        String contact = request.getParameter("contact");
        String strDate = request.getParameter("dateLimite");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateLimite = null;

        try {
            dateLimite = dateFormat.parse(strDate);
            ModelAppleOffre newOffer = new ModelAppleOffre(id, budget, dateLimite, organisme, contact);

            List<ModelAppleOffre> offers = AppleOffers.getOffers();
            offers.add(newOffer);

            Memoire.setValue(AppleOffers.OFFERS_KEY, offers);
            request.getSession().setAttribute("successMessage", "The Apple Offer has been successfully added.");
            request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to add the Apple Offer due to a date parsing error.");
            request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);
        }
    }
}