# 🏢 HPE Employee REST API

> **HPE Software Engineering Job Simulation** — A Spring Boot REST service for managing employee records.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Testing](#testing)
- [Notes](#notes)

---

## Overview

A RESTful web service that exposes endpoints to **list** and **add** employees. Built using Spring Boot with an in-memory data store. Developed as part of the HPE Software Engineering virtual job simulation.

---

## Tech Stack

| | Technology |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Boot 4.1.0 |
| **Build Tool** | Maven (wrapper included) |
| **Testing** | JUnit 5 + Spring Boot Test |

---

## Project Structure

```
HPE_job-simulation/
└── main files/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/example/restservice/
    │   │   │   ├── RestServiceApplication.java   # App entry point (@SpringBootApplication)
    │   │   │   ├── Employee.java                 # Employee model (id, first_name, last_name, email, title)
    │   │   │   ├── Employees.java                # Wrapper around List<Employee>
    │   │   │   ├── EmployeeManager.java          # In-memory repository with seed data
    │   │   │   └── EmployeeController.java       # REST controller — GET & POST /employees
    │   │   └── resources/
    │   │       └── application.properties        # Server config (port: 8081)
    │   └── test/
    │       └── java/com/example/restservice/
    │           └── RestServiceApplicationTests.java  # 7 unit tests
    ├── pom.xml                                   # Maven dependencies & build config
    ├── mvnw                                      # Maven wrapper (Unix)
    └── mvnw.cmd                                  # Maven wrapper (Windows)
```

---

## Getting Started

### Prerequisites

- Java 21+
- No separate Maven install needed — use the included wrapper

### Run the app

```bash
cd "main files"

# Unix / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

Server starts at: **`http://localhost:8081`**

---

## API Reference

### `GET /employees`

Returns all employees in the system.

**Response** `200 OK`
```json
{
  "employeeList": [
    {
      "id": "1",
      "firstName": "First1",
      "lastName": "Last1",
      "email": "Email1",
      "title": "Title1"
    },
    ...
  ]
}
```

---

### `POST /employees`

Adds a new employee. Returns `201 Created` with a `Location` header pointing to the new resource.

**Request Body**
```json
{
  "employee_id": "djones3",
  "first_name": "Daria",
  "last_name": "Jones",
  "email": "dariajones@gmail.com",
  "title": "Software Developer"
}
```

**Response** `201 Created`
```
Location: http://localhost:8081/employees/djones3
```

---

## Testing

Run all tests:

```bash
./mvnw test
```

| Test | Description |
|---|---|
| `createEmployeeManager` | Employee list is non-empty on initialization |
| `addEmployee` | Adding an employee increments count by exactly 1 |
| `employeeIdInList` | Correct `id` is persisted after add |
| `employeeFirstNameInList` | Correct `first_name` is persisted after add |
| `employeeLastNameInList` | Correct `last_name` is persisted after add |
| `employeeEmailInList` | Correct `email` is persisted after add |
| `employeeTitleInList` | Correct `title` is persisted after add |

---

## Notes

- **In-memory storage only** — all data resets on restart. No database is configured.
- **Seed data** — `EmployeeManager` pre-loads 3 employees (`id: 1, 2, 3`) via a static initializer at startup.
- **No DELETE / PUT** — only GET and POST are implemented in this simulation scope.
