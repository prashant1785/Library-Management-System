�
� Library Management System
 A Library Management System built using Spring Boot and MySQL to manage books and students
 with support for issuing and returning books. The system provides REST APIs for all CRUD operations
 and relational data handling.
 🚀 Features
 • 
• 
• 
• 
• 
• 
• 
Add, update, delete, and get books
 Add and view students
 Issue a book to a student
 Return a book
 Entity relationship mapping using JPA/Hibernate
 REST API architecture
 Postman tested
 🛠 Tech Stack
 Technology
 Description
 Java 17
 Backend language
 Spring Boot
 Application framework
 Spring Data JPA
 ORM and DB queries
 MySQL
 Database
 Hibernate
 JPA implementation
 Maven
 Build tool
 Postman
 API testing
 🧱 Project Architecture
 Controller Layer → Service Layer → Repository Layer → Database (MySQL)
 1
🗄 Database Structure
 Student Table
 Field Type
 student_id PK, BIGINT
 name VARCHAR
 Book Table
 Field Type
 book_id PK, BIGINT
 title VARCHAR
 author VARCHAR
 Library / Transaction Table (for issuing books)
 Field Type
 id PK
 student_id FK
 book_id FK
 issue_date DATE
 return_date DATE
 🔗 Entity Relationships
 Student 1 -> Many Library
 Book 1 -> Many Library
 📡 REST API Endpoints
 Books APIs
 Method Endpoint Description
 GET /books Get all books
 POST /books/add Create new book
 GET /books/{id} Get book by ID
 • 
• 
2
Method Endpoint Description
 PUT /books/update/{id} Update book
 DELETE /books/delete/{id} Delete book
 GET /books/findByBookName/{name} Search by book name
 Students APIs
 Method Endpoint Description
 GET /students Get all students
 POST /students/add Add student
 Library / Issue APIs
 Method Endpoint Description
 POST /library/issue Issue book
 PUT /library/return Return book
 GET /library/student/{id} Get issued books of student
 🧪 Testing With Postman
 Create a book
 Create a student
 Issue a book using studentId & bookId
 Return book
 Check DB values update
 💡 Future Enhancements
 Add UI using Angular
 Implement Spring Security authentication
 Add fine calculation on late return
 Add pagination & sorting
 📥 How to Run the Project
 Prerequisites
 JDK 17+
 MySQL installed and running
 Postman (optional)
 1. 
2. 
3. 
4. 
5. 
• 
• 
• 
• 
• 
• 
• 
3
IntelliJ / STS / Eclipse
 • 
Steps
 git clone <repository-url>
 cd Library-Management-System
 mvn clean install
 • 
• 
• 
Create a database in MySQL 
CREATE DATABASE librarydb;
 Update 
application.properties
 spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
 spring.datasource.username=root
 spring.datasource.password=your_password
 Run 
LmsApplication.java
 👩💻 Author
 Prashant Dilip Domkawale
 Full Stack Java Developer
 Email: domkawaleprashant1785@gmail.com
 GitHub: https://github.com/prashant1785
 ⭐ If you like this project
 Give this repository a star to support future updates!
