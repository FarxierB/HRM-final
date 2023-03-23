package sr.unasat.controller;

import sr.unasat.dao.WerknemerDAO;
import sr.unasat.entity.Werknemer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
@Path("/werknemer")
public class WerknemerController {

        private WerknemerDAO werknemerDAO = new WerknemerDAO();

        @GET
        @Path("/list")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Werknemer> findAllWerknemers() {
            return werknemerDAO.findAllWerknemers();
        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Werknemer findWerknemerById(@PathParam("id") int id) {
            return werknemerDAO.findWerknemerById(id);
        }

        @POST
        @Path("/add")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Werknemer addWerknemer(Werknemer werknemer) {
            return werknemerDAO.insertWerknemer(werknemer);
        }

        @PUT
        @Path("/update")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response updateWerknemer(Werknemer updatedWerknemer) {
            int rowsUpdated = werknemerDAO.updateWerknemer(updatedWerknemer);
            if (rowsUpdated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.ok(updatedWerknemer).build();
            }
        }

        @DELETE
        @Path("/delete/{id}")

        @Produces(MediaType.APPLICATION_JSON)
        public Response deleteWerknemer(@PathParam("id") int id) {
            int rowsDeleted = werknemerDAO.deleteWerknemer(id);
            if (rowsDeleted == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.ok().build();
            }
        }

}
