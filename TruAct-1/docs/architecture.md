# Architecture of TruAct Fraud Detection System

## Overview
The TruAct project is an AI-powered fraud detection system designed to identify and prevent fraudulent activities in financial transactions. The system leverages machine learning algorithms to analyze transaction data and detect anomalies that may indicate fraud. The architecture is designed to support both admin and user functionalities, ensuring a robust and scalable solution.

## Architectural Components

### 1. **Client Layer**
- **User Interface**: The system provides separate dashboards for Admin and User roles. The Admin dashboard allows configuration of detection settings, monitoring of fraud cases, and management of algorithms. The User dashboard displays alerts for potentially fraudulent transactions.

### 2. **Controller Layer**
- **AdminController**: Handles requests related to admin functionalities such as configuration updates and fraud detection monitoring.
- **UserController**: Manages user-related functionalities, including transaction submissions and alert notifications.

### 3. **Service Layer**
- **AdminService**: Contains business logic for managing admin functionalities, including configuration and monitoring of fraud detection.
- **UserService**: Handles user-related business logic, including transaction monitoring and alert notifications.
- **DetectionService**: Implements the core logic for detecting fraudulent transactions using machine learning models.

### 4. **Data Access Layer (DAO)**
- **TransactionDao**: Responsible for database operations related to financial transactions.
- **UserDao**: Manages user-related database operations.
- **FraudAlertDao**: Handles operations related to fraud alerts and notifications.

### 5. **Model Layer**
- **Transaction**: Represents a financial transaction entity.
- **User**: Represents a user entity in the system.
- **FraudAlert**: Represents a fraud alert entity.

### 6. **Machine Learning Layer**
- **FraudModel**: Represents the machine learning model used for fraud detection.
- **ModelTrainer**: Responsible for training the fraud detection model using historical transaction data.
- **FeatureExtractor**: Extracts relevant features from transaction data to improve model accuracy.

### 7. **Utility Layer**
- **JdbcUtil**: Provides JDBC connection management and utility methods for database operations.
- **CsvLoader**: Loads data from CSV files for training and testing purposes.
- **LoggerUtil**: Provides logging functionalities to track system operations and errors.

### 8. **Database Layer**
- The system uses a MySQL database to store transaction data, user information, and fraud alerts. The database schema is defined in the `schema.sql` file, and initial data is populated using the `data.sql` file.

## Deployment
The application can be containerized using Docker. The `Dockerfile` and `docker-compose.yml` files define the necessary configurations for building and running the application in a containerized environment.

## Conclusion
The TruAct fraud detection system is designed with a modular architecture that separates concerns across different layers. This design facilitates maintainability, scalability, and ease of integration with machine learning algorithms for effective fraud detection.