#!/bin/bash

# This script populates the database with initial data for testing purposes.

# Database connection details
DB_HOST="localhost"
DB_PORT="3306"
DB_USER="root"
DB_PASSWORD="your_password"
DB_NAME="truact_db"

# SQL commands to seed the database
SQL_COMMANDS="
INSERT INTO users (username, password, email) VALUES ('admin', 'admin123', 'admin@example.com');
INSERT INTO users (username, password, email) VALUES ('user1', 'user123', 'user1@example.com');
INSERT INTO users (username, password, email) VALUES ('user2', 'user123', 'user2@example.com');

INSERT INTO transactions (user_id, amount, transaction_date, status) VALUES (1, 100.00, NOW(), 'COMPLETED');
INSERT INTO transactions (user_id, amount, transaction_date, status) VALUES (2, 200.00, NOW(), 'COMPLETED');
INSERT INTO transactions (user_id, amount, transaction_date, status) VALUES (1, 1500.00, NOW(), 'PENDING');
INSERT INTO transactions (user_id, amount, transaction_date, status) VALUES (2, 300.00, NOW(), 'COMPLETED');
"

# Execute SQL commands
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD $DB_NAME -e "$SQL_COMMANDS"

echo "Database seeded with initial data."