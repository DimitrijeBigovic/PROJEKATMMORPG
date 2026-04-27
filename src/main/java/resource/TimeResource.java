package resource;


import exception.PlayerException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import model.TimeZone;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import rest.TimeApi;
import service.TimeService;

@Path("/time")
public class TimeResource {

    @Inject
    TimeService timeService;

    @GET
    @Path("/getTimeZoneByIP")
    public Response getTimeZoneByIP(@QueryParam("id") Long id) throws PlayerException {
        TimeZone timezone= timeService.getTimeByPlayerId(id);
        return Response.ok(timezone).build();

    }



}
