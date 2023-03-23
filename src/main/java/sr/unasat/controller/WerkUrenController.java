package sr.unasat.controller;

import sr.unasat.dao.WerkUrenDAO;
import sr.unasat.entity.WerkUren;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
@Path("/WerkUren")
public class WerkUrenController {
    private WerkUrenDAO werkUrenDAO = new WerkUrenDAO();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WerkUren> findAllWerkUren() {
        return werkUrenDAO.findAllWerkUren();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public WerkUren findWerkUrenById(@PathParam("id") int id) {
        return werkUrenDAO.findWerkUrenById(id);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public WerkUren addWerkUren(WerkUren werkUren) {
        return werkUrenDAO.insertWerkUren(werkUren);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateWerknemer(WerkUren updatedWerkUren) {
        int rowsUpdated = werkUrenDAO.updateWerkUren(updatedWerkUren);
        if (rowsUpdated == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(updatedWerkUren).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")

    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteWerkUren(@PathParam("id") int id) {
        int rowsDeleted = werkUrenDAO.deleteWerkUren(id);
        if (rowsDeleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().build();
        }
    }
}
