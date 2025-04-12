package com.pip.offer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/offers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OfferResource {
    private final OfferDAO offerDAO;

    public OfferResource(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @GET
    @Path("/{id}")
    public Response getOffer(@PathParam("id") int id) {
        return offerDAO.getById(id);
    }

    @POST
    public Response createOffer(Offer offer) {
        int id = offerDAO.insert(offer.getTitle(), offer.getDiscount(), "CREATED");
        Offer saved = offerDAO.getById(id);
        return Response.ok(saved).build();
    }


    @PUT
    @Path("/{id}/approve")
    public Response approveOffer(@PathParam("id") int id) {
        offerDAO.updateStatus(id, "APPROVED");
        Offer updated = offerDAO.getById(id);
        return Response.ok(updated).build();
    }
}
