INSERT INTO users (id, username, password, email, role, fraud_count) VALUES
(1, 'admin', 'admin123', 'admin@example.com', 'ADMIN', 0),
(2, 'user1', 'user123', 'user1@example.com', 'USER', 0),
(3, 'user2', 'user456', 'user2@example.com', 'USER', 0);

INSERT INTO transactions (id, transaction_id, user_id, amount, timestamp, status) VALUES
(1, 'TXN001', 1, 1000.00, '2023-01-01 10:00:00', 'COMPLETED'),
(2, 'TXN002', 2, 500.00, '2023-01-02 11:00:00', 'COMPLETED'),
(3, 'TXN003', 3, 2000.00, '2023-01-03 12:00:00', 'COMPLETED'),
(4, 'TXN004', 2, 1500.00, '2023-01-04 13:00:00', 'PENDING'),
(5, 'TXN005', 1, 3000.00, '2023-01-05 14:00:00', 'COMPLETED');

INSERT INTO fraud_alerts (id, transaction_id, user_id, alert_message, resolved, created_at) VALUES
(1, 'TXN004', 2, 'Suspicious transaction detected for user user1', FALSE, '2023-01-04 13:00:00'),
(2, 'TXN005', 1, 'High-value transaction detected for user admin', FALSE, '2023-01-05 14:00:00');