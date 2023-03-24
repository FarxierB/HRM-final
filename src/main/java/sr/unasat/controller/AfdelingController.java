package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.dao.AfdelingDAO;
import sr.unasat.entity.Afdeling;
import sr.unasat.entity.WerkUren;

import java.util.List;

@Path("/afdeling")
public class AfdelingController {

    AfdelingDAO afdelingDAO = new AfdelingDAO();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Afdeling> findAllAfdelingen() {
        return afdelingDAO.findAllAfdelingen();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Afdeling findAfdelingById(@PathParam("id") int id) {
        return afdelingDAO.findAfdelingById(id);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Afdeling addAfdeling(Afdeling afdeling) {
        return afdelingDAO.insertAfdeling(afdeling);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAfdeling(Afdeling updatedAfdeling) {
        int rowsUpdated = afdelingDAO.updateAfdeling(updatedAfdeling);
        if (rowsUpdated == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(updatedAfdeling).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")

    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAfdeling(@PathParam("id") int id) {
        int rowsDeleted = afdelingDAO.deleteAfdeling(id);
        if (rowsDeleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().build();
        }
    }
}
