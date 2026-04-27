package rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import model.TimeResponce;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/time/current/ip")
@RegisterRestClient(configKey = "time-api")
public interface TimeApi {

@GET
   public TimeResponce getTimeByIP(@QueryParam("ipAddress") String ipAddress);

}
