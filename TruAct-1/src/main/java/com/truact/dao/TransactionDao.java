package com.truact.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.truact.exception.DataAccessException;
import com.truact.model.Transaction;

public class TransactionDao {

    private final JdbcTemplate jdbcTemplate;

    public TransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveTransaction(Transaction transaction) throws DataAccessException {
        String sql = "INSERT INTO transactions (transaction_id, user_id, amount, timestamp, status) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, transaction.getTransactionId(), transaction.getUserId(), transaction.getAmount().doubleValue(), Timestamp.valueOf(transaction.getTimestamp()), transaction.getStatus());
        } catch (RuntimeException e) {
            throw new DataAccessException("Error saving transaction", e);
        }
    }

    public List<Transaction> getAllTransactions() throws DataAccessException {
        String sql = "SELECT id, transaction_id, user_id, amount, timestamp, status FROM transactions";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                int id = rs.getInt("id");
                return new Transaction(id, rs.getString("transaction_id"), rs.getInt("user_id"), BigDecimal.valueOf(rs.getDouble("amount")), rs.getTimestamp("timestamp").toLocalDateTime(), rs.getString("status"));
            });
        } catch (RuntimeException e) {
            throw new DataAccessException("Error retrieving transactions", e);
        }
    }

    public Transaction getTransactionById(int id) throws DataAccessException {
        String sql = "SELECT id, transaction_id, user_id, amount, timestamp, status FROM transactions WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                int tid = rs.getInt("id");
                return new Transaction(tid, rs.getString("transaction_id"), rs.getInt("user_id"), BigDecimal.valueOf(rs.getDouble("amount")), rs.getTimestamp("timestamp").toLocalDateTime(), rs.getString("status"));
            }, id);
        } catch (RuntimeException e) {
            throw new DataAccessException("Error retrieving transaction by ID", e);
        }
    }
}