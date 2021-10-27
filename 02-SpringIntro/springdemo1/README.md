# Spring Boot Demo Project
## Task Management API 

### Requirements

1. Paginate requests to get all tasks (10 per page)
   
    `https://127.0.0.1:8080/tasks/?size=10&page=4` this returns 31-40
2. Validate that task name - more than 8 chars

### Recommendations 

1. Save the tasks to a DB (use H2DB or SQLite, easiest)
2. On server restart, too must persist
