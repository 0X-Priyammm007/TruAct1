package com.truact.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private String transactionId;
    private int userId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String status;

    public TransactionDto() {
    }

    public TransactionDto(String transactionId, int userId, BigDecimal amount, LocalDateTime timestamp, String status) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}