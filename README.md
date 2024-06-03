# Library-Management-System

Project Description: Library Management System

The Library Management System is a comprehensive web application developed to efficiently manage library operations. This project is implemented using Spring Boot for the backend and follows RESTful principles to expose various endpoints for managing library data. Below is an overview of the controller functionality:

Key Features and Endpoints:

Addition Operation:

Endpoint: /api/addition
Allows users to perform a simple addition of two numbers.
Retrieve All Libraries:

Endpoint: /api/getAllLibraries
Fetches a list of all libraries available in the system.
Get Library by ID:

Endpoint: /api/getById
Retrieves the details of a specific library by its unique ID.
Add New Library:

Endpoint: /api/addNewLib
Enables users to add a new library by providing details like ID, name, books, subject, and publisher.
Includes validation to prevent the addition of libraries with duplicate IDs.
Update Library Information:

Endpoint: /api/UpdateLibrary
Allows updating the details of an existing library.
Delete Library:

Endpoint: /api/deleteLibrary
Facilitates the deletion of a library based on its ID.
Sorting Libraries:

Endpoint: /api/sorting
Supports pagination and sorting of libraries by various attributes in ascending or descending order.
Filter Libraries by Name:

Endpoint: /api/getByName
Allows filtering libraries based on the name attribute.
Pagination Only:

Endpoint: /api/getByPageOnly
Retrieves a specific page of libraries with a defined number of records per page.
Sort Libraries by Attribute:

Endpoint: /api/getBySort
Provides sorting of libraries based on specified column names in either ascending or descending order.
Technologies Used:

Backend: Spring Boot, Java
Database: SQL, Hibernate
API Documentation: Swagger
Project Highlights:

Key Points:

1. Implemented RESTful web services to handle CRUD operations efficiently.
2. Utilized Spring Data JPA for database interactions, ensuring seamless integration with SQL databases.
3. Employed Swagger for API documentation and testing, enhancing the development and collaboration process.
4. Provided comprehensive search and sort functionalities, including pagination and sorting by multiple criteria.
5. Ensured robust data validation to maintain data integrity and prevent duplication.
