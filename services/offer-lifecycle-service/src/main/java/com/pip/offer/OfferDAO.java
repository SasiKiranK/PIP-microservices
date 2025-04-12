package com.pip.offer;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;


@RegisterBeanMapper(Offer.class)
public interface OfferDAO {
    @SqlUpdate("INSERT INTO offers (title, discount, status) VALUES (:title, :discount, :status)")
    @GetGeneratedKeys
    int insert(@Bind("title") String title, @Bind("discount") int discount, @Bind("status") String status);

    @SqlQuery("SELECT * FROM offers WHERE id = :id")
    Offer getById(@Bind("id") int id);

    @SqlUpdate("UPDATE offers SET status = :status, updated_at = CURRENT_TIMESTAMP WHERE id = :id")
    void updateStatus(@Bind("id") int id, @Bind("status") String status);
}
