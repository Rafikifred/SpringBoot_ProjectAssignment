MyDiary API
MyDiary is a RESTful API for an online journal application that allows users to document their thoughts and feelings. 
The API is designed with best practices for clean, secure, and scalable architecture.

Features
User Management:

User registration (/auth/signup) with email and password validation.
User login (/auth/signin) with email and password authentication.
Optional OAuth integration for secure access.
Journal Entries Management:

Create a new journal entry (POST /entries).
View all entries (GET /entries), sorted by creation date in descending order.
View a specific entry (GET /entries/{entryId}).
Edit an existing entry (PATCH /entries/{entryId}).
Delete an entry (DELETE /entries/{entryId}).
API Response Format:

Success responses include status, message, and data.
Error responses include status and error.
Database Integration:

MySQL database for data persistence.
Tables for users and journal entries.
Technologies Used
Backend Framework: Java (Spring Boot)
Database: MySQL
ORM: Spring Data JPA
Security: Spring Security (optional JWT/OAuth integration)
Build Tool: Maven
Testing Tools: Postman for API testing

 database connection in src/main/resources/application.properties:
properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydiary
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
