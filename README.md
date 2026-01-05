# TruAct - AI-powered Fraud Detection System

## Overview
TruAct is an AI-powered fraud detection system designed to identify and prevent fraudulent activities in financial transactions. The system utilizes machine learning algorithms to analyze transaction data and detect anomalies that may indicate fraud.

## Features
- **Admin Functionalities:**
  - Manage system configurations, including detection thresholds and algorithm parameters.
  - Monitor detection results and review detected fraud cases.
  - Update detection algorithms based on performance data and feedback.

- **User Functionalities:**
  - Perform financial transactions that are monitored for fraud.
  - Receive alerts for potentially fraudulent transactions.

## Project Structure
The project is structured as a Maven project with the following key components:
- **src/main/java/com/truact**: Contains the main application code, including controllers, services, DAOs, models, and machine learning components.
- **src/main/resources**: Holds configuration files, SQL scripts for database schema and initial data, and static resources for the web interface.
- **src/test**: Contains unit tests for the application.

## Database
The application uses a MySQL database to store transaction data, user information, and fraud alerts. The database schema is defined in `src/main/resources/db/schema.sql`, and initial data can be seeded using `src/main/resources/db/data.sql`.

## Setup Instructions
1. **Clone the Repository:**
   ```
   git clone <repository-url>
   cd TruAct
   ```

2. **Configure Database:**
   Update the database connection settings in `src/main/resources/application.properties`.

3. **Build the Project:**
   Use Maven to build the project:
   ```
   mvn clean install
   ```

4. **Run the Application:**
   Start the application using:
   ```
   mvn spring-boot:run
   ```

5. **Access the Dashboards:**
   - Admin Dashboard: Access via `/admin/dashboard.html`
   - User Alerts: Access via `/user/alerts.html`

## Docker Support
The project includes Docker support for easy deployment. Use the provided `Dockerfile` and `docker-compose.yml` to build and run the application in a containerized environment.

## Contribution
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
