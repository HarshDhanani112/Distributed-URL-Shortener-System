# Distributed URL Shortener System

A scalable backend application for shortening URLs, managing redirections, and handling secure user authentication using Spring Boot.

---

## Features

- User Registration & Login
- JWT Authentication & Authorization
- URL Shortening Service
- URL Redirection
- RESTful APIs
- Layered Architecture
- DTO Pattern
- Validation & Exception Handling
- Pagination Support
- MySQL Database Integration
- Redis Caching (In Progress)

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Redis
- Maven
- Postman
- Git & GitHub

---

## Project Architecture

- Controller Layer
- Service Layer
- Repository Layer
- DTO Layer
- Entity Layer
- Exception Handling Layer

---

## API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login user |

### URL APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/shorten` | Generate short URL |
| GET | `/{shortCode}` | Redirect to original URL |
| GET | `/urls` | Get all URLs with pagination |

---

## Database Features

- Relational Database Design
- Normalization
- Query Optimization
- Indexing
- Pagination

---

## Security Features

- JWT-based Authentication
- Password Encryption
- Secure API Access
- Role-based Authorization (Planned)

---

## Future Improvements

- Custom Short URLs
- URL Analytics Dashboard
- Click Tracking
- Docker Deployment
- Rate Limiting
- API Documentation using Swagger
- Role-Based Access Control

---

## Getting Started

### Clone Repository

```bash
git clone https://github.com/HarshDhanani112/Distributed-URL-Shortener-System.git
