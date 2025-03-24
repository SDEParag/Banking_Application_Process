# **Banking Application Process**

This Spring Boot application provides a **REST API** for a banking system that allows users to manage their bank accounts. Users can **view balance, deposit money, and withdraw money** while ensuring the balance never goes negative.

 
# **Features**

* View account balance
* Deposit money
* Withdraw money with validation
* Prevent negative balance
* Exception handling for errors

# **Technologies Used**

* Java 8
* Spring Boot
* Spring Data JPA
* MySQL Database
* REST API
* Exception Handling

# **Setup Instructions**

* **Prerequisites**
  * Java 8+
  * MySQL Database
  * Maven
  * Postman or any API testing tool

# **Database Configuration**
```http
===============================
Database Configuration (MySQL)
===============================
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=***********
spring.datasource.password=***********
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
```http
===============================
Hibernate Configuration
===============================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

# **Running the Application**

* Clone the repository:
  ```http
  git clone https://github.com/your-repo/banking-application.git
  ```
* Navigate to the project directory:
  ```http
  cd banking-application
  ```
* Build the project:
  ```http
  mvn clean install
  ```
* Run the application:
  ```http
  mvn spring-boot:run
  ```

# **API Endpoints**
```http
1. View Balance

Endpoint: GET /api/bank/balance

Response:
{
  "balance": 1000.0
}
```

```http
2. Deposit Money

Endpoint: POST /api/bank/deposit

Request Body:
{
  "amount": 500
}

Response:
{
  "message": "Deposit successful! New balance: ₹1500"
}
```

```http
3. Withdraw Money

Endpoint: POST /api/bank/withdraw

Request Body:
{
  "amount": 2000
}

Response (If insufficient funds):
{
  "error": "Insufficient funds",
  "message": "Insufficient funds."
}

Response (If successful):
{
  "message": "Withdrawal successful! New balance: ₹500"
}
```

# **Exception Handling**
```http
===============================
Centralized Exception Handling
===============================
```
The application includes centralized exception handling using `@RestControllerAdvice`. It handles:

* **Invalid Amount Exception** - If the deposit or withdrawal amount is not positive.
* **Insufficient Funds Exception** - If the user attempts to withdraw more money than available.

### **Exception Classes Implemented**
```http
1. GlobalExceptionHandler - Handles exceptions globally using @RestControllerAdvice.
2. InsufficientFundsException - Custom exception for insufficient funds.
3. InvalidAmountException - Custom exception for invalid amounts.
```

