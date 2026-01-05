package com.truact.model;

import java.sql.Timestamp;

public class FraudAlert {
    private int id;
    private String transactionId;
    private int userId;
    private String alertMessage;
    private boolean resolved;
    private Timestamp createdAt;

    public FraudAlert(int id, String transactionId, int userId, String alertMessage, boolean resolved, Timestamp createdAt) {
        this.id = id;
        this.transactionId = transactionId;
        this.userId = userId;
        this.alertMessage = alertMessage;
        this.resolved = resolved;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "FraudAlert{" +
                "id=" + id +
                ", transactionId='" + transactionId + '\'' +
                ", userId=" + userId +
                ", alertMessage='" + alertMessage + '\'' +
                ", resolved=" + resolved +
                ", createdAt=" + createdAt +
                '}';
    }
}