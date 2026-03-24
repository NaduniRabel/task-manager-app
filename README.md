<h1>Task Manager App</h1>
<h3>Angular - SpringBoot - MySQL</h3>

<h2>Before run:</h2>
Install Docker & Docker compose

<h2>Steps to run:</h2>

1. Clone the repository and navigate to Task-Manager
   ```bash
   git clone https://github.com/NaduniRabel/task-manager-app.git
   cd Task-Manager
   ```
2. Create a .env file and include the variables
   ```bash
   # Spring Boot
   SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/dbname
   SPRING_DATASOURCE_USERNAME=user
   SPRING_DATASOURCE_PASSWORD=password
   SPRING_JPA_HIBERNATE_DDL_AUTO=update
   
   # MySQL
   MYSQL_ROOT_PASSWORD=password
   MYSQL_DATABASE=dbname
   ```

2. Build and start all services
   ```bash
   docker compose up --build
   ```

4. Access the application

  - frontend - http://localhost:4200
  - backend - http://localhost:8080

4. Stop the application
   ```bash
   docker compose down
   ```

<h2>MySQL Database Configuration</h2>
<ul>
   <li>Database name = taskmanager</li>
   <li>Username = root </li>
   <li>Password = root</li>
   <li> Port = 3306 </li>
</ul>
  




