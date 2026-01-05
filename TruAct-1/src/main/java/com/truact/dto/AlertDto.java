package com.truact.dto;

public class AlertDto {
    private String transactionId;
    private String userId;
    private String alertMessage;
    private boolean resolved;

    public AlertDto() {
    }

    public AlertDto(String transactionId, String userId, String alertMessage, boolean resolved) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.alertMessage = alertMessage;
        this.resolved = resolved;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
}