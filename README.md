<h1>Task Manager App</h1>

<h2>Before run:</h2>
Install Docker & Docker compose

<h2>Steps to run:</h2>

1. Clone the repository and navigate to Task-Manager

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
  




