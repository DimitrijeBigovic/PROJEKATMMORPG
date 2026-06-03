package resource;

import exception.PlayerException;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import model.CurrencyResponce;
import service.CurrencyConvertService;

@Path("/convert")
public class CurrencyConverResource {
    @Inject
    CurrencyConvertService  Currency_service;

    @GET
    @Path("/currencyConversion")
    @RolesAllowed("admin")
    public Response currencyConversion(@QueryParam("from") String from , @QueryParam("to") String to, @QueryParam("Player_id") Long Player_id, @QueryParam("value")double value) throws PlayerException {

        CurrencyResponce  responce = Currency_service.convert(from, to, Player_id,value);

        return Response.ok(responce).build();
    }

}
