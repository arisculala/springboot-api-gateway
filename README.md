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
git clone https://github.com/arisculala/springboot-api-gateway.git
cd springboot-api-gateway
```

- Install dependencies

```bash
mvn install
```

## ▶️ How to Run

- Run the following command to start:

```bash
mvn spring-boot:run
```

## 📂 Configure Microservices

Below is a sample application.yml file that configures the API Gateway to:

- Route requests to microservices
- Secure endpoints with Keycloak JWT validation
- Define public paths that do not require authentication

```bash
server:
  port: 8081

spring:
  main:
    allow-bean-definition-overriding: true
  cloud:
    gateway:
      routes:
        - id: users-management-service
          uri: http://localhost:8082
          predicates:
            - Path=/api/v1/users/**
        - id: auth-service
          uri: http://localhost:8082
          predicates:
            - Path=/api/v1/auth/**
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8080/realms/springboot-api-gateway

app:
  security:
    public-paths:
      - /api/v1/auth/login
      - /api/v1/auth/register
      - /api/v1/public/**

logging:
  level:
    org.springdoc: DEBUG
    root: INFO
    org.springframework: INFO
    com.users.management: DEBUG
    org.springframework.cloud.gateway: DEBUG
    org.springframework.web: DEBUG
```

- The gateway listens on port 8081.
- It routes requests to users-management-service and auth-service. Requests with the path /api/v1/users/** or /api/v1/auth/** are forwarded to http://localhost:8082.
- The API Gateway validates JWT tokens issued by Keycloak.
- The issuer-uri must match your Keycloak realm (springboot-api-gateway).
- Login & Registration (`/api/v1/auth/login`, `/api/v1/auth/register`) are accessible without authentication.
- The `/api/v1/public/**` path is also excluded from security.

## 📜 License

This project is open-source and available under the MIT License.
