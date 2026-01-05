package com.truact.dao;

import com.truact.model.User;
import com.truact.exception.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) throws DataAccessException {
        String sql = "INSERT INTO users (username, password, email, role, fraud_count) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRole(), user.getFraudCount());
        } catch (RuntimeException e) {
            throw new DataAccessException("Error adding user", e);
        }
    }

    public User getUserById(int id) throws DataAccessException {
        String sql = "SELECT id, username, password, email, role, fraud_count FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> 
                new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("role"), rs.getInt("fraud_count")), id);
        } catch (RuntimeException e) {
            throw new DataAccessException("Error retrieving user", e);
        }
    }

    public List<User> getAllUsers() throws DataAccessException {
        String sql = "SELECT id, username, password, email, role, fraud_count FROM users";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> 
                new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("role"), rs.getInt("fraud_count")));
        } catch (RuntimeException e) {
            throw new DataAccessException("Error retrieving users", e);
        }
    }

    public void updateUser(User user) throws DataAccessException {
        String sql = "UPDATE users SET username = ?, password = ?, email = ?, role = ?, fraud_count = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRole(), user.getFraudCount(), user.getId());
        } catch (RuntimeException e) {
            throw new DataAccessException("Error updating user", e);
        }
    }

    public void incrementFraudCount(int userId) throws DataAccessException {
        String sql = "UPDATE users SET fraud_count = fraud_count + 1 WHERE id = ?";
        try {
            jdbcTemplate.update(sql, userId);
        } catch (RuntimeException e) {
            throw new DataAccessException("Error incrementing fraud count", e);
        }
    }

    public List<com.truact.dto.AlertDto> getAlertsForTransaction(String transactionId) throws DataAccessException {
        String sql = "SELECT transaction_id, user_id, alert_message, resolved FROM fraud_alerts WHERE transaction_id = ?";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> new com.truact.dto.AlertDto(rs.getString("transaction_id"), String.valueOf(rs.getInt("user_id")), rs.getString("alert_message"), rs.getBoolean("resolved")), transactionId);
        } catch (RuntimeException e) {
            throw new DataAccessException("Error retrieving alerts for transaction", e);
        }
    }

    public void deleteUser(int id) throws DataAccessException {
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (RuntimeException e) {
            throw new DataAccessException("Error deleting user", e);
        }
    }
}