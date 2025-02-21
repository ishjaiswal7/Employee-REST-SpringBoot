# 🚀 Employee REST API - Spring Boot

## 🌟 Overview
This project is a RESTful API for managing employees, built using Spring Boot. It provides endpoints to create, retrieve, update, and delete employee records.

## 🛠️ Tech Stack
- ⚡ **Spring Boot 3.4.3**
- 🌍 **Spring Boot Starter Web** (for building REST APIs)
- 💾 **Spring Boot Starter Data JPA** (for database interaction)
- 🛢️ **MySQL** (for persistent storage)
- 🔄 **Spring Boot DevTools** (for development efficiency)
- ✅ **Spring Boot Starter Test** (for testing)

## 🎯 Features
- ➕ Create a new employee
- 📜 Retrieve all employees
- 🔍 Retrieve a specific employee by ID
- ✏️ Update an existing employee
- ❌ Delete an employee

## 📌 API Endpoints
| 🏷️ HTTP Method | 🔗 Endpoint | 📄 Description |
|------------|----------------|-------------|
| 📝 POST | `/api/employees` | Create a new employee |
| 📥 GET | `/api/employees` | Retrieve all employees |
| 🔎 GET | `/api/employees/{id}` | Retrieve an employee by ID |
| 🛠️ PUT | `/api/employees/{id}` | Update an existing employee |
| 🗑️ DELETE | `/api/employees/{id}` | Delete an employee |

## ⚙️ Setup and Installation
### 📌 Prerequisites
- ☕ Java 22
- 🏗️ Maven
- 🛢️ MySQL database

### 🚀 Steps to Run
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/Employee_Rest_SpringBoot.git
   cd Employee_Rest_SpringBoot
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

## 🏗️ Project Structure
```
Employee_Rest_SpringBoot
│── src/main/java/com/example/demo
│   ├── controller/EmployeeController.java
│   ├── model/Employee.java
│   ├── repository/EmployeeRepository.java
│   ├── service/EmployeeService.java
│   └── DemoApplication.java
│── src/main/resources/
│   ├── application.properties
│── pom.xml
```

## 📜 License
This project is licensed under the MIT License. 📄

