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
      when we delete task 1.3, Task 1 should turn to **done**
   4. There is **NO SEPARATE TABLE** for _sub tasks_. In above example, Task 1 as well as Task 1.1, 1.2 etc are all rows of the task table only
   5. Handle circular dependency (eg: following should not happen) 
      ```
      Task A -> depends on Task B -> depends on Task A
      Task A -> depends on Task B -> ...... -> depends on Task A
      ```