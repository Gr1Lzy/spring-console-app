# ConsoleApplication

This project is a Spring Boot console application designed for managing departments and lecturers within a university system. It uses a relational database and includes dependencies such as Spring Data JPA, Liquibase, and MapStruct.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17**
- **Maven**
- **PostgreSQL** (H2 for test)

## Running PostgreSQL Database

To start the PostgreSQL database, use the following command in the root directory of your project:

```bash
docker-compose up
```
Alternatively, you can select the `dev` profile to use a test H2 database instead of PostgreSQL.

## Data

All test data used to populate the database is stored in the `src/main/resources/db/data` directory. This data is used to seed the database with initial values for testing and development.
