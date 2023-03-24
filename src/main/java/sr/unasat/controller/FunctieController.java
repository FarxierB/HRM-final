package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.dao.FunctieDAO;
import sr.unasat.entity.Functie;
import sr.unasat.entity.WerkUren;

import java.util.List;

@Path("/functie")
public class FunctieController {
    FunctieDAO functieDAO = new FunctieDAO();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Functie> findAllFuncties() {
        return functieDAO.findAllFuncties();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Functie findFunctieById(@PathParam("id") int id) {
        return functieDAO.findFunctieById(id);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Functie addFunctie(Functie functie) {
        return functieDAO.insertFunctie(functie);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFunctie(Functie updatedFunctie) {
        int rowsUpdated = functieDAO.updateFunctie(updatedFunctie);
        if (rowsUpdated == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(updatedFunctie).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")

    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFunctie(@PathParam("id") int id) {
        int rowsDeleted = functieDAO.deleteFunctie(id);
        if (rowsDeleted == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().build();
        }
    }
}
