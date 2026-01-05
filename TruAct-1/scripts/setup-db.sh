#!/bin/bash

# This script sets up the MySQL database for the TruAct application.

# Database configuration
DB_NAME="truact_db"
DB_USER="root"
DB_PASSWORD="your_password"

# Create the database
echo "Creating database: $DB_NAME"
mysql -u $DB_USER -p$DB_PASSWORD -e "CREATE DATABASE IF NOT EXISTS $DB_NAME;"

# Use the database
echo "Using database: $DB_NAME"
mysql -u $DB_USER -p$DB_PASSWORD -e "USE $DB_NAME;"

# Create tables
echo "Creating tables..."
mysql -u $DB_USER -p$DB_PASSWORD $DB_NAME < ../src/main/resources/db/schema.sql

echo "Database setup completed."