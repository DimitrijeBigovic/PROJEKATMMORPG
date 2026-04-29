package rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import model.CurrencyResponce;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/rates")
@RegisterRestClient(configKey = "convert-api")
public interface CurrencyConvertrAPI {


    @GET
    public CurrencyResponce getCurrency(@QueryParam("from")String from, @QueryParam("to")String to);

}
