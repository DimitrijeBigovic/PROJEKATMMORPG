package rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.LocationResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/json")
@RegisterRestClient(configKey = "location-api")
public interface LocationApi {

    @GET
    @Path("/{ip}")
    public LocationResponse getLocationByIP(@PathParam("ip") String ipAddress);
}
