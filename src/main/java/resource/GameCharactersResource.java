package resource;


import exception.GameCharacterException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.GameCharacter;
import service.gameCharacterService;

import java.util.List;

@Path("/GameCharacter")
public class GameCharactersResource {

    @Inject
    public gameCharacterService gameCharacterService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addGameCharacter")
    public Response addGameCharacter(GameCharacter gameCharacter){
        try {
            gameCharacterService.addGameCharacter(gameCharacter);
        }catch (GameCharacterException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        return Response.ok().entity(gameCharacter).build();
    }
    @GET
    @Path("/getCharactersByPlayerId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharactersByPlayerId(@QueryParam("id") Long id) {
        List<GameCharacter> characters = gameCharacterService.getCharactersByPlayerId(id);
        return Response.ok().entity(characters).build();
    }


    @POST
    @Path("/addItemToCharacter/{gameCharacter_id}/{item_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItemToCharacter(@PathParam("gameCharacter_id") Long gameCharacter_id,@PathParam("item_id") Long item_id) throws GameCharacterException {
try {
    GameCharacter updateGameCharacter = gameCharacterService.addItemToGameCharacter(gameCharacter_id,item_id);
return Response.ok().entity(updateGameCharacter).build();
}catch (GameCharacterException e){
    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
}


    }

}
