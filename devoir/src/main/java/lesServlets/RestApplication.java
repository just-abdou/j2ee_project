package lesServlets;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/rest")

public class RestApplication extends ResourceConfig {
    public RestApplication() {
        packages("lesServlets");
    }
}
