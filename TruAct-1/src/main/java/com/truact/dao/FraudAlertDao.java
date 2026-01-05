package com.truact.dao;

import com.truact.model.FraudAlert;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FraudAlertDao {

    private final JdbcTemplate jdbcTemplate;

    public FraudAlertDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to save a fraud alert to the database
    public void saveFraudAlert(FraudAlert fraudAlert) {
        String sql = "INSERT INTO fraud_alerts (transaction_id, user_id, alert_message, resolved, created_at) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, fraudAlert.getTransactionId(), fraudAlert.getUserId(), fraudAlert.getAlertMessage(), fraudAlert.isResolved(), fraudAlert.getCreatedAt());
    }

    // Method to retrieve all fraud alerts from the database
    public List<FraudAlert> getAllFraudAlerts() {
        String sql = "SELECT id, transaction_id, user_id, alert_message, resolved, created_at FROM fraud_alerts";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new FraudAlert(rs.getInt("id"), rs.getString("transaction_id"), rs.getInt("user_id"), rs.getString("alert_message"), rs.getBoolean("resolved"), rs.getTimestamp("created_at")));
    }
}