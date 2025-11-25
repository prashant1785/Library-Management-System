📚 Library Management System

The Library Management System is a full-stack CRUD application built using Spring Boot and MySQL to manage books, authors, and student records within a library. It supports borrowing and returning books, along with tracking availability.

🚀 Features

Add, update, delete and view books

Manage authors and students

Borrow and return books functionality

Track total copies, available copies, and borrowed count

Exception handling and input validation

REST API with proper status codes

MySQL database integration using Spring Data JPA

🛠️ Tech Stack
Category	Technology
Backend	Spring Boot, Spring Data JPA, Hibernate
Database	MySQL
Build Tool	Maven
Language	Java
API Testing	Postman
IDE	IntelliJ IDEA / STS / Eclipse
📂 Project Structure
src/
 ┣ main/
 ┃ ┗ java/com/library
 ┃   ┣ controller
 ┃   ┣ service
 ┃   ┣ exception
 ┃   ┣ repository
 ┃   ┗ model
 ┗ resources/
     ┗ application.properties

🗄️ Database Schema
Book Table
Field	Type
book_id	int (PK)
title	varchar
author	varchar
totalCopies	int
availableCopies	int
Student Table
Field	Type
student_id	int (PK)
name	varchar
email	varchar
Borrow Table
Field	Type
borrow_id	int (PK)
student_id	int (FK)
book_id	int (FK)
issueDate	date
returnDate	date
🌐 API Endpoints
Method	Endpoint	Description
GET	/api/books	Get all books
GET	/api/books/{id}	Get book by ID
POST	/api/books	Add new book
PUT	/api/books/{id}	Update book details
DELETE	/api/books/{id}	Delete book
POST	/api/borrow/{bookId}/student/{studentId}	Borrow a book
PUT	/api/return/{bookId}/student/{studentId}	Return a book
⚙️ Steps to Run the Project
1️⃣ Clone Repository
git clone https://github.com/prashant1785/library-management-system.git

2️⃣ Configure MySQL
create database library_db;

3️⃣ Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Run Application
mvn spring-boot:run

🧪 Test With Postman

Use the API endpoints mentioned above to test book CRUD and borrow/return operations.

📸 Screenshots (Optional)

Add UI or Postman screenshots here

🔮 Future Enhancements

Login & JWT authentication

Role-based admin and student dashboard

Angular/React frontend UI

Email notifications for due dates

👨‍💻 Author

Prashant Domkawale
📍 Java Full Stack Developer
🔗 LinkedIn: https://www.linkedin.com/in/prashant-domkawale-179b19266/
📧 Email: domkawaleprashant1785@gmail.com
