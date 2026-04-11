package resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Item;
import service.itemService;

import java.util.List;

@Path("/Item")
public class itemResource {

    @Inject
    public itemService itemService;




    @POST
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addItem")
    public Response addItem(Item item) {

        itemService.addItem(item);
        return Response.ok().entity(item).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllItems")
    public Response getAllItems() {
       List<Item> items = itemService.getAllItems();
       return Response.ok().entity(items).build();
    }


}
