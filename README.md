# SafePay

SafePay is a work-in-progress Spring Boot application for monitoring, analyzing, and reporting potentially fraudulent financial transactions.

## Tech Stack

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 In-Memory Database** (for development/testing)
- **Lombok** (for boilerplate code reduction)
- **Jakarta Validation**
- **Maven** (build tool)
- **RESTful API** (Spring Web)

## Main Features (in progress)

- **Transaction Management**
  - Create and store transactions with details such as user, amount, type, location, and merchant.
  - Retrieve all transactions or filter by user and type.
  - Retrieve a transaction by its ID.

- **Fraud Detection**
  - Automatic fraud checks on new transactions using configurable rules (e.g., high-value transaction detection).
  - Retrieve fraud check results for a specific transaction.

- **Fraud Reporting**
  - Manual reporting of suspicious transactions.
  - Store and retrieve fraud reports.

## Example API Endpoints

- `POST /api/transactions/`  
  Create a new transaction (fraud check is performed automatically).

- `GET /api/transactions/`  
  Retrieve all transactions.

- `GET /api/transactions/user/{userId}`  
  Retrieve all transactions for a specific user.

- `GET /api/transactions/{id}`  
  Retrieve a transaction by its ID.

- `GET /api/transactions/{id}/fraud-check`  
  Get fraud check result for a specific transaction.

- `POST /api/fraud-reports`  
  Manually create a fraud report for a transaction.

- `GET /api/fraud-reports/{id}`  
  Retrieve a fraud report by its ID.

## Project Structure

- `model/` – JPA entities (Transaction, FraudCheckResult, FraudReport, etc.)
- `repository/` – Spring Data JPA repositories
- `service/` – Business logic and fraud detection rules
- `controller/` – REST API endpoints
- `dto/` – Data Transfer Objects for API requests/responses
- `mapper/` – Mapping logic between DTOs and entities

## Status

This project is under active development.  
Core transaction and fraud detection logic is implemented, but features and rules are being expanded.

---

**Note:**  
This project uses an in-memory H2 database by default. All data is lost