# HPE Software Engineering Job Simulation — Employee REST API

A Spring Boot REST API built as part of the *HPE (Hewlett Packard Enterprise) Software Engineering Job Simulation*. The service exposes endpoints to retrieve and add employee records, backed by an in-memory store.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.0 |
| Build tool | Maven (via mvnw wrapper) |
| Testing | JUnit 5 + Spring Boot Test |

---

## Project Structure


main files/
├── src/
│   ├── main/java/com/example/restservice/
│   │   ├── RestServiceApplication.java   # Entry point
│   │   ├── Employee.java                 # Employee model
│   │   ├── Employees.java                # Wrapper list model
│   │   ├── EmployeeManager.java          # In-memory repository
│   │   └── EmployeeController.java       # REST controller
│   └── test/java/com/example/restservice/
│       └── RestServiceApplicationTests.java  # Unit tests
├── pom.xml
└── mvnw / mvnw.cmd


---

## API Endpoints

Base URL: http://localhost:8080

### GET /employees
Returns all employees.

*Response*
json
{
  "employeeList": [
    {
      "id": "1",
      "firstName": "First1",
      "lastName": "Last1",
      "email": "Email1",
      "title": "Title1"
    }
  ]
}


### POST /employees
Adds a new employee. Returns 201 Created with a Location header pointing to the new resource.

*Request body*
json
{
  "employee_id": "djones3",
  "first_name": "Daria",
  "last_name": "Jones",
  "email": "dariajones@gmail.com",
  "title": "Software Developer"
}


---

## Running Locally

*Prerequisites:* Java 21, Maven (or use the included wrapper)

bash
cd "main files"

# Run the app
./mvnw spring-boot:run

# Run tests
./mvnw test


On Windows, use mvnw.cmd instead of ./mvnw.

The server starts on http://localhost:8080 by default.

---

## Data Persistence

The service uses an *in-memory static list* — data resets on every restart. Three seed employees (1, 2, 3) are pre-loaded at startup via a static initializer in EmployeeManager.

---

## Tests

7 unit tests in RestServiceApplicationTests:

| Test | What it checks |
|---|---|
| createEmployeeManager | Employee list is non-empty on init |
| addEmployee | Adding an employee increments count by 1 |
| employeeIdInList | Correct ID stored after add |
| employeeFirstNameInList | Correct first name stored |
| employeeLastNameInList | Correct last name stored |
| employeeEmailInList | Correct email stored |
| employeeTitleInList | Correct title stored
