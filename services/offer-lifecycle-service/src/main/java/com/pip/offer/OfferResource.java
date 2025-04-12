package com.pip.offer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/offers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OfferResource {

    @GET
    @Path("/{id}")
    public Response getOffer(@PathParam("id") int id) {
        // return Response.ok("Offer service is up!").build();
        String response = String.format("{ \"id\": %d, \"title\": \"Sample Offers\" }", id);
        return Response.ok(response).build();
    }

    @POST
    public Response createOffer(String json) {
        return Response.status(Response.Status.CREATED).entity(json).build();
    }

    @PUT
    @Path("/{id}/approve")
    public Response approveOffer(@PathParam("id") int id) {
        String response = String.format("{ \"id\": %d, \"status\": \"APPROVED\" }", id);
        return Response.ok(response).build();
    }
}
