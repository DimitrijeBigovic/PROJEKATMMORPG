package resource;


import exception.PlayerException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.MultipartBody;
import model.Player;

import service.playerService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Path("/player")
public class playerResource {


    @Inject
    public playerService PlayerService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPlayer")
//    @RolesAllowed("admin")
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
//    @PermitAll
    public Response getAllPlayers() {
        List<Player> Players = PlayerService.getAllPlayers();
        return Response.ok().entity(Players).build();
    }

    @GET
    @Path("/getPlayerByID")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerByID(@QueryParam("id") Long id) {
        Player player = PlayerService.getPlayerById(id);
        return Response.ok().entity(player).build();
    }

    @GET
    @Path("/getPlayersByUsername")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersByUsername(@QueryParam("username") String username) {
        List<Player> Players = PlayerService.getAllPlayersByUsername(username);
        return Response.ok().entity(Players).build();
    }


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/addImageToPlayer")
    public Response addImageToPlayer(MultipartBody multipartBody) {
        try {
           java.nio.file.Path destination = java.nio.file.Path.of("C:\\Users\\dimit\\OneDrive\\Desktop\\SlikeZAprojekat",multipartBody.file.fileName());
            Files.copy(multipartBody.file.uploadedFile(), destination, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/addImageToPlayer2")
    public Response addImageToPlayer2(@QueryParam("id") long player_id, MultipartBody Image)  {

        try {
            Player player = PlayerService.addImageToPlayer2(player_id, Image);
            return Response.ok().build();
        }catch (PlayerException p){
            return Response.status(Response.Status.BAD_REQUEST).entity(p.getMessage()).build();
        }catch (IOException i){
            return Response.serverError().entity("Greska Pri cuvanju fajla").build();
        }


    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getPlayerWithFiles")
    public Response getPlayerWithFiles(@QueryParam("id") long id) {
        try {
            Player player = PlayerService.getPlayerWithImages(id);
            return Response.ok().entity(player).build();

        } catch (PlayerException e) {
          return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

    }


}
