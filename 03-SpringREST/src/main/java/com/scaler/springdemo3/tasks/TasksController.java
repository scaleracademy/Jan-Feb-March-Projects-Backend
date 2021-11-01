package com.scaler.springdemo3.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TasksController {

    @Autowired
    TasksService tasksService;

    @GetMapping("/")
    List<Task> getAllTask() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable("id") int taskId) {
        return tasksService.getTask(taskId);
    }

    @PostMapping("/")
    Task addNewTask(@RequestBody AddTaskDto body) {
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
}
