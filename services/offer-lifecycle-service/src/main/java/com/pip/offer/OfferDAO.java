package com.pip.offer;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(OfferMapper.class)
public interface OfferDAO {
    @SqlUpdate("INSERT INTO offers (title, discount, status) VALUES (:title, :discount, :status)")
    @GetGeneratedKeys
    int insert(@Bind("title") String title, @Bind("discount") int discount, @Bind("status") String status);

    @SqlQuery("SELECT * FROM offers WHERE id = :id")
    Offer getById(@Bind("id") int id);

    @SqlUpdate("UPDATE offers SET status = :status, updated_at = CURRENT_TIMESTAMP WHERE id = :id")
    void updateStatus(@Bind("id") int id, @Bind("status") String status);
}
