package resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.player;
import service.playerService;

import java.awt.*;
import java.util.List;

@Path("/player")
public class playerResource {


    @Inject
    public playerService playerService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPlayer")
    public boolean addPlayer(player player) {
        playerService.createPlayer(player);
        return true;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPlayers")
    public Response getAllPlayers() {
        List<player> players = playerService.getAllPlayers();
        return Response.ok().entity(players).build();
    }

}
