# ConsoleApplication

This project is a Spring Boot console application designed for managing departments and lecturers within a university system. It uses a relational database and includes dependencies such as Spring Data JPA, Liquibase, and MapStruct.

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17**
- **Maven**
- **PostgreSQL** (optional; H2 can be used as an alternative for development and testing)

### Clone the Repository

If you haven't cloned the repository yet, you can do so using Git:

```bash
git clone https://github.com/Gr1Lzy/spring-console-app.git
```

### Configuration of `.env` File

To configure the PostgreSQL connection for your application, create a `.env` file in the root directory of your project and include the following properties:

```env
POSTGRES_URL=jdbc:postgresql://{URL}:{PORT}/{DBName}
POSTGRES_USER={USERNAME}
POSTGRES_PASSWORD={PASSWORD}
```

If you do not want to configure the `.env` file and do not have **PostgreSQL**, you can switch to the `dev` profile configuration. This profile uses an **H2 database**, which is suitable for development and testing purposes.

### Data

All test data used to populate the database is stored in the 'src/main/resources/db/data' directory. This data is used to seed the database with initial values for testing and development.
