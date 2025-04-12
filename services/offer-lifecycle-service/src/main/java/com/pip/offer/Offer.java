package com.pip.offer;

import java.time.Instant;

public class Offer {
    private int id;
    private String title;
    private int discount;
    private String status;
    private Instant createdAt;
    private Instant updatedAt;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDiscount() { return discount; }
    public void setDiscount(int discount) { this.discount = discount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
