package lesServlets;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/testing")
public class Testing {
    @GET
    @Path("/test")
    public String test() {
        return "Test successful";
    }


}
