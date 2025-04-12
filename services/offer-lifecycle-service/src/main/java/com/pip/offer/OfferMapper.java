package com.pip.offer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class OfferMapper implements ResultSetMapper<Offer> {
    @Override
    public Offer map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Offer offer = new Offer();
        offer.setId(r.getInt("id"));
        offer.setTitle(r.getString("title"));
        offer.setDiscount(r.getInt("discount"));
        offer.setStatus(r.getString("status"));
        offer.setCreatedAt(r.getTimestamp("created_at").toInstant());
        offer.setUpdatedAt(r.getTimestamp("updated_at").toInstant());
        return offer;
    }
}
