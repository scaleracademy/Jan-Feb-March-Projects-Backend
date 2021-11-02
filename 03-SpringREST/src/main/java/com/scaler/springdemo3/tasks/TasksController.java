package com.scaler.springdemo3.tasks;

import com.scaler.springdemo3.commons.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TasksController {

    @Autowired
    TasksService tasksService;

    @GetMapping("/")
    List<Task> getAllTask(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    ) {
        return tasksService.getAllTasks(page, size);
    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable("id") int taskId) {
        return tasksService.getTask(taskId);
    }

    @PostMapping("/")
    Task addNewTask(@Valid @RequestBody AddTaskDto body) {
        var savedTask = tasksService.addTask(body.task);
        return savedTask;
    }

    @PutMapping("/{id}/done")
    Task setTaskDone(@PathVariable("id") int taskId) {
        tasksService.setTaskDone(taskId, true);
        return tasksService.getTask(taskId);
    }

    @DeleteMapping("/{id}/done")
    Task setTaskUndone(@PathVariable("id") int taskId) {
        tasksService.setTaskDone(taskId, false);
        return tasksService.getTask(taskId);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    ResponseEntity<ErrorResponse> handleExceptions(Exception exception) {

        if (exception instanceof MethodArgumentNotValidException) {
            var error = (MethodArgumentNotValidException) exception;
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(error.getMessage())
            );
        }

        return ResponseEntity.internalServerError().body(
                new ErrorResponse("Unknown server error")
        );
    }
}
