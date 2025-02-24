# 🚀 Employee-API-Application (REST API - Spring Boot)

## 🌟 Overview
This project is a RESTful API for managing employees, built using Spring Boot. It provides endpoints to create, retrieve, update, and delete employee records with validation, verification, and error handling mechanisms. Additionally, a frontend integration using Fetch API allows users to interact with the API directly.

## 🛠️ Tech Stack
- ⚡ **Spring Boot 3.4.3**
- 🌍 **Spring Boot Starter Web** (for building REST APIs)
- 💾 **Spring Boot Starter Data JPA** (for database interaction)
- 🛢️ **MySQL** (for persistent storage)
- 🔄 **Spring Boot DevTools** (for development efficiency)
- ✅ **Spring Boot Starter Test** (for testing)
- 🔍 **Spring Boot Validation** (for input validation)
- ⚠️ **Spring Boot Exception Handling** (for error handling)
- 🖥️ **HTML, CSS, JavaScript** (Frontend UI)

## 🎯 Features
- ➕ Create a new employee with validation
- 📜 Retrieve all employees
- 🔍 Retrieve a specific employee by ID
- ✏️ Update an existing employee with verification
- ❌ Delete an employee
- ⚠️ Error handling for invalid requests and database issues
- 🌐 Frontend with Fetch API to interact with backend

## 📌 API Endpoints
| 🏷️ HTTP Method | 🔗 Endpoint | 📄 Description |
|------------|----------------|-------------|
| 📝 POST | `/api/employees` | Create a new employee (with validation) |
| 📥 GET | `/api/employees` | Retrieve all employees |
| 🔎 GET | `/api/employees/{id}` | Retrieve an employee by ID (with verification) |
| 🛠️ PUT | `/api/employees/{id}` | Update an existing employee (with validation) |
| 🗑️ DELETE | `/api/employees/{id}` | Delete an employee (with verification) |

## ⚙️ Setup and Installation
### 📌 Prerequisites
- ☕ Java 22
- 🏗️ Maven
- 🛢️ MySQL database

### 🚀 Steps to Run
1. **Clone the repository:**
   ```sh
   git clone https://github.com/ishjaiswal7/Employee-API-Application.git
   cd Employee-API-Application
   ```
2. **Configure MySQL Database:**
   - Open `application.properties` (or `application.yml` if you use YAML) and configure your database settings:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```
3. **Build and Run the Project:**
   ```sh
   mvn spring-boot:run
   ```
4. **Test the API:**
   - Use 🛠️ **Postman** to test the API endpoints by sending requests and verifying responses.
   - Alternatively, use `curl` commands in the terminal.

## 🌐 Frontend Integration with Fetch API
Create a simple frontend to interact with the API using JavaScript Fetch API.

## 🏗️ Project Structure
```
Employee-API-Application
│── src/main/java/com/example/demo
│   ├── controller/EmployeeController.java
│   ├── model/Employee.java
│   ├── repository/EmployeeRepository.java
│   ├── service/EmployeeService.java
│   ├── exception/EmployeeNotFoundException.java
│   ├── validation/EmployeeValidator.java
│   └── DemoApplication.java
│── src/main/resources/
│   ├── static
│   |   ├── index.html 
│   |   ├── add.html
│   |   ├── delete.html
│   |   ├── update.html
│   |   ├── index.js 
│   |   ├── add.js
│   |   ├── delete.js
│   |   └── update.js
|   └── application.properties
│── pom.xml
```

## 📜 License
This project is licensed under the MIT License. 📄

## 📚 Reference

I built this application alongside the course: [Full-Stack Web Development on Coursera](https://www.coursera.org/learn/fullstack-web-development?specialization=amazon-junior-software-developer).
