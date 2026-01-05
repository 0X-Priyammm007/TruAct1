# Database Schema for TruAct Fraud Detection System

## Overview
The TruAct fraud detection system utilizes a relational database to manage user and transaction data effectively. The database schema is designed to support the functionalities required for detecting fraudulent activities in financial transactions.

## Database Tables

### 1. Users Table
- **Table Name**: `users`
- **Description**: Stores user information.
- **Columns**:
  - `id` (INT, Primary Key, Auto Increment): Unique identifier for each user.
  - `username` (VARCHAR(50), Unique): The username of the user.
  - `password` (VARCHAR(255)): The hashed password of the user.
  - `email` (VARCHAR(100), Unique): The email address of the user.
  - `created_at` (TIMESTAMP): The date and time when the user was created.

### 2. Transactions Table
- **Table Name**: `transactions`
- **Description**: Records all financial transactions made by users.
- **Columns**:
  - `id` (INT, Primary Key, Auto Increment): Unique identifier for each transaction.
  - `user_id` (INT, Foreign Key): References the `id` in the `users` table.
  - `amount` (DECIMAL(10, 2)): The amount of the transaction.
  - `transaction_date` (TIMESTAMP): The date and time when the transaction occurred.
  - `status` (ENUM('PENDING', 'COMPLETED', 'FAILED')): The status of the transaction.

### 3. Fraud Alerts Table
- **Table Name**: `fraud_alerts`
- **Description**: Stores alerts generated for potentially fraudulent transactions.
- **Columns**:
  - `id` (INT, Primary Key, Auto Increment): Unique identifier for each fraud alert.
  - `transaction_id` (INT, Foreign Key): References the `id` in the `transactions` table.
  - `alert_date` (TIMESTAMP): The date and time when the alert was generated.
  - `reason` (VARCHAR(255)): The reason for the fraud alert.
  - `resolved` (BOOLEAN): Indicates whether the alert has been resolved.

## Relationships
- **Users to Transactions**: One-to-Many
  - A user can have multiple transactions, but each transaction is associated with only one user.
  
- **Transactions to Fraud Alerts**: One-to-One
  - Each transaction can generate one fraud alert, but each fraud alert is linked to only one transaction.

## SQL Schema Definition
```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDING', 'COMPLETED', 'FAILED') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE fraud_alerts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id INT,
    alert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reason VARCHAR(255) NOT NULL,
    resolved BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (transaction_id) REFERENCES transactions(id)
);
```

## Conclusion
This database schema provides a robust foundation for the TruAct fraud detection system, enabling efficient management of users, transactions, and fraud alerts. The relationships between tables ensure data integrity and facilitate effective fraud detection processes.