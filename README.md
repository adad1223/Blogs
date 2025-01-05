# Microservices Blog Application

This project is a **microservices-based application** designed to manage users, blogs, and comments. It uses **Docker and Kubernetes** for scalability and modern security practices like **JWT for authentication** and **bcrypt for password hashing**.

## Table of Contents
- [Overview](#overview)
- [Endpoints](#endpoints)
  - [User Service](#user-service)
  - [Blog Service](#blog-service)
  - [Comment Service](#comment-service)
- [Tech Stack](#tech-stack)
- [Setup and Installation](#setup-and-installation)
---

## Overview

The application comprises three services:
1. **User Service**: Manages user registration, authentication, and profiles.
2. **Blog Service**: Handles blog posts, including creation, retrieval, updating, and deletion.
3. **Comment Service**: Facilitates adding and retrieving comments for blog posts.

This system demonstrates how to structure a scalable, secure, and modular application using modern software development practices.
---

## Endpoints

### User Service
- **POST** `/auth/register/`: Register a new user with a hashed password.
- **POST** `/auth/login/`: Authenticate a user and issue a JWT token.
- **GET** `/users/<id>`: Retrieve user details.
- **PUT** `/users/<id>`: Edit a user's profile.
- **DELETE** `/users/<id>`: Delete a user.

### Blog Service
- **POST** `/blogs/`: Create a new blog post.
- **GET** `/blogs/`: Retrieve all blog posts.
- **GET** `/blogs/<id>`: Retrieve a specific blog post.
- **PUT** `/blogs/<id>`: Edit an existing blog post.
- **DELETE** `/blogs/<id>`: Delete a specific blog post.

### Comment Service
- **POST** `/comments/`: Add a comment to a blog post.
- **GET** `/comments?post_id=<id>`: List comments for a specific blog post.

---

## Tech Stack

- **Backend**: Spring Boot
- **Authentication**: JWT, bcrypt
- **Databases**: PostgreSQL
- **Containerization**: Docker
- **Orchestration**: Kubernetes
- **API Gateway**: Spring Cloud Gateway
- **Service Discovery**: Eureka Server

---

## Setup and Installation

1. Clone the repository.
   ```bash
   git clone https://github.com/your-repo/microservices-blog-app.git
   ```
2.Navigate to the project directory
  ```bash
  cd microservices-blog-app
```
3.Build Docker images for each service.
  ```bash
  docker-compose build
```
4.Start all services using Docker Compose.
Docker Compose will set up the services, including the User Service, Blog Service, Comment Service, and the API Gateway.
```bash
docker-compose up
```
5.Access the application via the API Gateway.
The API Gateway will be accessible at the following URL:
```bash
http://localhost:9000
```

  
