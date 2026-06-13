# HPE Software Engineering Job Simulation – Employee REST API

This project was built as part of the **Hewlett Packard Enterprise (HPE) Software Engineering Job Simulation** on Forage. It demonstrates a RESTful web service built with **Java** and **Spring Boot**, including full CRUD operations and unit testing.

## Overview

The simulation covers three core tasks:
1. **Design and build a RESTful web service** using Java Spring Boot
2. **Add application support for uploading data** via JSON request bodies
3. **Write unit tests** to verify application behavior

## Tech Stack

- Java 21
- Spring Boot 4.1.0
- Spring Web (REST)
- Maven
- JUnit 5

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java       # Application entry point
│   │   │   ├── Employee.java              # Employee model (POJO)
│   │   │   └── EmployeeController.java    # REST controller (CRUD endpoints)
│   │   └── resources/
│   │       └── application.properties     # App configuration (port 8081)
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java   # Unit tests
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md
```

## API Endpoints

| Method | Endpoint              | Description                  | Request Body Example |
|--------|-----------------------|-------------------------------|------------------------|
| GET    | `/employees`          | Get all employees             | —                       |
| GET    | `/employees/{id}`     | Get employee by ID            | —                       |
| POST   | `/employees`          | Add a new employee             | `{"id":3,"name":"Priya","department":"Sales"}` |
| PUT    | `/employees/{id}`     | Update an existing employee   | `{"name":"Updated Name","department":"Finance"}` |
| DELETE | `/employees/{id}`     | Delete an employee            | —                       |

## Sample Data (Preloaded)

| ID | Name  | Department  |
|----|-------|-------------|
| 1  | Aman  | Engineering |
| 2  | Rahul | HR          |

## How to Run

### Prerequisites
- Java 21 (JDK)
- Maven (or use the included `mvnw` / `mvnw.cmd` wrapper)

### Run the application
```bash
./mvnw spring-boot:run
```
On Windows:
```powershell
.\mvnw.cmd spring-boot:run
```

The app starts on **http://localhost:8081**

### Test the API
```bash
curl http://localhost:8081/employees
```

Or use [Postman](https://www.postman.com/) to test GET, POST, PUT, and DELETE requests.

## Run Unit Tests
```bash
./mvnw test
```
On Windows:
```powershell
.\mvnw.cmd test
```

## What I Learned

- Building RESTful APIs with Spring Boot annotations (`@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`)
- Handling JSON request/response bodies with `@RequestBody`
- Using `@PathVariable` for dynamic routing
- Writing and running unit tests with Spring Boot's testing framework
- Project setup and dependency management with Maven

## About

Built as part of the [HPE Software Engineering Virtual Experience Program](https://www.theforage.com/simulations/hewlett-packard-enterprise/software-engineering-pcij) on Forage.
