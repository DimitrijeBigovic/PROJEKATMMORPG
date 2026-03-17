package resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Player;
import service.playerService;

import java.util.List;

@Path("/player")
public class playerResource {


    @Inject
    public playerService PlayerService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPlayer")
    public boolean addPlayer(Player player) {
        PlayerService.createPlayer(player);
        return true;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPlayers")
    public Response getAllPlayers() {
        List<Player> Players = PlayerService.getAllPlayers();
        return Response.ok().entity(Players).build();
    }

}
