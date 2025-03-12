# Spring Boot API Gateway with Keycloak Integration

This document provides a detailed guide on setting up and configuring a Spring Boot API Gateway with Keycloak for authentication and authorization. The API Gateway acts as a reverse proxy, handling authentication and routing requests to microservices.

## 🚀 Features

- Spring Cloud Gateway: Routes incoming requests to backend services.
- Keycloak: Provides authentication and issues JWT tokens.
- OAuth2 Resource Server: API Gateway validates JWT tokens issued by Keycloak.
- User Management Service: Handles user authentication, registration, and syncs with Keycloak. (this is a separate service)

## 📌 Prerequisites

Before setting up the Spring Boot API Gateway with Keycloak, ensure you have the following:

- Java 17+ installed
- Spring Boot 3.x (with Spring Cloud Gateway)
- Maven or Gradle for dependency management
- Keycloak Setup

## 📌 Keycloak Setup

- Keycloak Server running locally (http://localhost:8080) or hosted remotely
- A Realm created (e.g., springboot-api-gateway)
- A Client created with:
- Client ID: api-gateway-client
- Client Secret (if confidential client)
- Access Type: confidential (for backend authentication)
- Valid Redirect URIs: http://localhost:8081/\*
- Service Account Enabled for client credentials flow (if needed)

## 📥 Installation

- Clone the repository

```bash
git clone https://github.com/arisculala/atm-cli-nodejs.git
cd atm-cli-nodejs
```

- Install dependencies

```bash
npm install
```

## ▶️ How to Run

- Run the following command to start the ATM CLI:

```bash
npm run start
```

You will see a welcome message and a prompt ($) for entering commands.

## 📌 How to Run Tests

This project uses Jest for unit testing. Follow these steps to run the tests:

- If you haven’t installed dependencies yet, run:

```bash
npm install
```

- To execute all tests, run:

```bash
npm test

OR

npm run test
```

## 📝 Usage Guide

Available Commands
| Command | Description |
| -------------------------- | -------------------------- |
| login [name] | Logs in as a user (creates an account if it doesn’t exist). |
| logout | Logs out of the current session. |
| deposit [amount] | Deposits money into the logged-in account. |
| withdraw [amount] | Withdraws money from the account. |
| transfer [target] [amount] | Transfers money to another user. |
| balance | Displays the current balance. |
| transactions [type_optional] | Shows transaction history (optional filter: deposit, withdraw, transfer, etc.). |
| exit | Exits the ATM CLI. |
| help | Displays available commands. |

## 📌 Example Usage

```bash
==============================================================
  Welcome to the ATM CLI. Type 'help' for available commands.
==============================================================

$ login jhon

Hello, jhon!
Your balance is $0

$ deposit 1000

Your balance is $1000

$ withdraw 99

Withdrew $99. New balance: $901

$ logout

Goodbye, jhon!

$ login mary

Hello, mary!
Your balance is $0

$ logout

Goodbye, mary!
```

## 📂 Project Structure

```bash
atm-cli-nodejs/
│── models/
│   ├── user.model.js
│   ├── transaction.model.js
│── services/
│   ├── atm.service.js
│   ├── auth.service.js
│── index.js
│── README.md
│── package.json
```

## 📜 License

This project is open-source and available under the MIT License.
