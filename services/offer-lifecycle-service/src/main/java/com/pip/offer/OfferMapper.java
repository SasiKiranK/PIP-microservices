package com.pip.offer;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferMapper implements RowMapper<Offer> {

    @Override
    public Offer map(ResultSet r, StatementContext ctx) throws SQLException {
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
