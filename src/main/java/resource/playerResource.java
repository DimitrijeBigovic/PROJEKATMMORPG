package resource;


import exception.PlayerException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.GameCharacter;
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
    public Response addPlayer(Player player) {
        try {
            PlayerService.createPlayer(player);
        } catch (PlayerException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().entity(player).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPlayers")
    public Response getAllPlayers() {
        List<Player> Players = PlayerService.getAllPlayers();
        return Response.ok().entity(Players).build();
    }

    @GET
    @Path("/getPlayersByUsername")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersByUsername(@QueryParam("username") String username) {
        List<Player> Players = PlayerService.getAllPlayersByUsername(username);
        return Response.ok().entity(Players).build();
    }

    @GET
    @Path("/getCharactersByPlayerId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharactersByPlayerId(@QueryParam("id") Long id) {
        List<GameCharacter> characters = PlayerService.getCharactersByPlayerId(id);
        return Response.ok().entity(characters).build();
    }

}
