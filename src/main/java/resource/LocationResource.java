package resource;


import exception.PlayerException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import model.LocationZone;
import service.LocationService;

@Path("/location")
public class LocationResource {
    @Inject
    LocationService locationService;


    @GET
    @Path("/getLocationByUserID")
    public Response getLocationByUserID(@QueryParam("id") Long id) throws PlayerException {
        LocationZone locationZone= locationService.getLocationZone(id);
        return Response.ok(locationZone).build();
    }
}
