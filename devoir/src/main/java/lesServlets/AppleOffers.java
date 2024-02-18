package lesServlets;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.servlet.annotation.WebServlet;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;



@Path("/appleOffers")
public class AppleOffers {
    static final String OFFERS_KEY = "appleOffers";

    
    @SuppressWarnings("unchecked")
    @GET
    public static List<ModelAppleOffre> getOffers() {
        List<ModelAppleOffre> offers = (List<ModelAppleOffre>) Memoire.getValue(OFFERS_KEY);
        
        if (offers == null) {
            return new ArrayList<>();
        }
        
        return offers;
    }
    
    @PUT
    @Path("/editOffer")
    @Produces(MediaType.APPLICATION_JSON)
    public static void editExpirationDate(@QueryParam("offerId") String offerId, Date newDate) {
        List<ModelAppleOffre> offers = getOffers(); 

        boolean offerFound = false;

        for (ModelAppleOffre offer : offers) {
            if (offerId.equals(offer.getId())) {
                offer.setDateLimite(newDate); 
                offerFound = true;
                break; 
            }
        }

        if (!offerFound) {
            System.out.println("Offer not found."); 
        }

        Memoire.setValue(OFFERS_KEY, offers);
    }
}

