# EventTrackerProject

## Project Overview

This project aims to develop a RESTful API using Spring Boot and JPA (Java Persistence API). The project involves creating an entity class that models database tables and performing CRUD operations using Spring Data JPA. This REST API will interact with MySQL as the underlying database, handling requests and responses in JSON format. The core objective is to build a functional application with a working REST API while maintaining best practices in version control and database management

## How to Run

* TODO: URL of app deployed on EC2

## REST Endpoints

| Http verb | URI                                                                 | Response body                    | Status codes         |
|-----------|---------------------------------------------------------------------|----------------------------------|----------------------|
| GET       | /api/transactions                                                   | List transactions                | 200                  |
| GET       | /api/transactions/1                                                 | Find transaction by id           | 200, 404             |
| POST      | /api/transactions/transactionParties/1/categories/1                 | Create new transaction           | 201, 400             |
| PUT       | /api/transactions/1                                                 | Update existing transaction      | 200, 400, 404        |
| DELETE    | /api/transactions/1                                                 | Delete transaction by id         | 204, 404, 400        |
| GET       | /api/transactions/search/lottery                                    | Search by keyword                | 200, 400, 404        |
| GET       | /api/transactions/searchDate/2024-05-05/2024-06-06                  | Search by date range             | 200, 400, 404        |
| GET       | /api/transactionParties                                             | List transaction parties         | 200                  |
| POST      | /api/transactionParties                                             | Create new transaction party     | 201, 400             |
| GET       | /api/transactionParties/1/transactions                              | Find transactions by 
party id    | 200, 400, 404        |

## Technologies Used

- Spring Boot: Used to create the REST API with annotations and configurations that simplify RESTful web services development.
- Spring Data JPA: Enables easy integration with MySQL for database operations using JPA for entity mapping and CRUD operations.
- MySQL: Provides the relational database where event and associated data will be stored, manipulated, and retrieved.
- Gradle: Manages project dependencies and builds automation.
- JUnit: Used for testing the entity class and API routes to ensure the reliability of the code.
- Postman: Utilized for testing API endpoints during development.
- Git/GitHub: Provides version control, and the final project will be stored in a public GitHub repository.

## Lessons Learned

This project provided practical experience in configuring a Spring Boot application to interact with a MySQL database via JPA. Key takeaways include:

- Entity Modeling and JPA: Mapping Java objects to database tables using JPA annotations helped solidify the understanding of ORM (Object-Relational Mapping).
- REST API Development: Designing routes for CRUD operations and configuring Spring Boot to handle incoming HTTP requests were valuable experiences.
- Database Integration: Setting up a MySQL schema, handling database migrations, and integrating the application with MySQL Workbench improved database management skills.
- Version Control: The importance of using Git for version control was reinforced, ensuring each project milestone was safely stored and easily recoverable.
- Testing and Debugging: Writing JUnit tests to validate the functionality of the application and utilizing Postman for API route testing helped ensure robustness before deployment.
