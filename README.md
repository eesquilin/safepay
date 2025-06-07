# SafePay

SafePay is a work-in-progress Spring Boot application designed to monitor, analyze, and report potentially fraudulent financial transactions.

## Tech Stack

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 In-Memory Database** (for development/testing)
- **Lombok** (for boilerplate code reduction)
- **Jakarta Persistence API (JPA)**
- **Maven** (build tool)
- **RESTful API** (Spring Web)

## Main Features (in progress)

- **Transaction Management**
  - Create and store transactions with details such as user, amount, type, location, and merchant.
  - Retrieve all transactions or filter by user and type.

- **Fraud Detection**
  - Automatic fraud checks on new transactions using configurable rules (e.g., high-value transaction detection).
  - Store and retrieve fraud check results.

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

## Project Structure

- `model/` – JPA entities (Transaction, FraudCheckResult, FraudReport, etc.)
- `repository/` – Spring Data JPA repositories
- `service/` – Business logic and fraud detection rules
- `controller/` – REST API endpoints

## Status

This project is under active development.  
Core transaction and fraud detection logic is implemented, but features and rules are being expanded.

---

>[!NOTE]
>This project uses an in-memory H2 database by default. All data is lost on restart.
