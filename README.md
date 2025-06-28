# SafePay

SafePay is a Spring Boot application for monitoring, analyzing, and reporting potentially fraudulent financial transactions.  
It provides a RESTful API for transaction management, fraud detection, and fraud reporting.

---

## Tech Stack

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 In-Memory Database** (for development/testing)
- **Lombok** (for boilerplate code reduction)
- **Jakarta Validation** (for DTO validation)
- **Maven** (build tool)
- **RESTful API** (Spring Web)

---

## Main Features

### Transaction Management
- Create and store transactions with details such as user, amount, type, location, and merchant.
- Retrieve all transactions or filter by user.
- Pagination support for transaction queries.

### Fraud Detection
- Automatic fraud checks on new transactions using configurable rules:
  - High-value transaction detection
  - High-risk location detection
  - Rapid-fire transaction detection
- Retrieve fraud check results for a specific transaction.

### Fraud Reporting
- Manual reporting of suspicious transactions.
- Store and retrieve fraud reports.

---

## Example API Endpoints

- `POST /api/transactions/`  
  Create a new transaction (fraud check is performed automatically).

- `GET /api/transactions/`  
  Retrieve all transactions.

- `GET /api/transactions/user/{userId}`  
  Retrieve all transactions for a specific user (with pagination).

- `GET /api/transactions/{id}/fraud-check`  
  Get fraud check result for a specific transaction.

- `POST /api/fraud-reports`  
  Manually create a fraud report for a transaction.

---

## DTO Validation

All incoming requests for creating transactions are validated using Jakarta Bean Validation annotations.  
Example for `TransactionRequestDTO`:
- `userId`: must not be null and must be >= 1
- `amount`: must not be null and must be >= 0.01
- `type`: must not be null
- `location` and `merchant`: must not be blank and max 100 characters

---

## Project Structure

- `model/` – JPA entities (Transaction, FraudCheckResult, FraudReport, etc.)
- `repository/` – Spring Data JPA repositories
- `service/` – Business logic and fraud detection rules
- `controller/` – REST API endpoints
- `dto/` – Data Transfer Objects for API requests/responses
- `mapper/` – Mapping logic between DTOs and entities

---

## Status

This project is under active development.  
Core transaction and fraud detection logic is implemented, but features and rules are being expanded.

---

**Note:**  
This project uses an in-memory H2 database by default. All data is lost