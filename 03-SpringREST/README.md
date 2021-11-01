# Task Manager (Spring Boot)

## Requirements 

1. Add created + modified timestamps on Tasks (and all entites)
2. Add an entity Notes 
   1. Notes have just a text body 
   2. Notes belong to Tasks
   3. Notes can exist only within a Task 
   4. Deleting a Task, deletes all its notes
3. Let a Task depend on another Task _(self referencing)_
   1. Each task will have an array `dependsOn` of data type `List<Task>`
   2. A task can not be marked done if the tasks it depends on  are not marked done
   3. Given this situation
      ```
      Task 1 (not done) -> depends on
         Task 1.1 (done)
         Task 1.2 (done)
         Task 1.3 (not done)
      ```
       1. when we delete task 1.3, Task 1 should turn to **done**
       2. After this ^ if another task is added on which Task 1 depends on, Task 1 should again be set to not-done
       3. when we set Task 1.3 to done, Task 1 should turn to done
       4. After that ^ if we set Task 1.1 or 1.2 or 1.3 to not-done, Task 1 should get set to not-done again
   4. There is **NO SEPARATE TABLE** for _sub tasks_. In above example, Task 1 as well as Task 1.1, 1.2 etc are all rows of the task table only
   5. Handle circular dependency (eg: following should not happen) 
      ```
      Task A -> depends on Task B -> depends on Task A
      Task A -> depends on Task B -> ...... -> depends on Task A
      ```

## REST API 

- **`GET /tasks`** read all tasks
- **`POST /tasks`**  add a new task
    ```
    { "task": "task name here" }
    ```
- **`GET /tasks/{id}`** read one task (by id)
- **`PUT /tasks/{id}/done`** set task to done
- **`DELETE /tasks/{id}/done`** set task to not-done

- **`GET /tasks/{id}/dependencies`** get tasks which are dependencies of a task only
- **`POST /tasks/{id}/dependencies`** add a task as a dependency of a task
    ```
    { "id": "id of task which is to be a dependency" }
    ```
