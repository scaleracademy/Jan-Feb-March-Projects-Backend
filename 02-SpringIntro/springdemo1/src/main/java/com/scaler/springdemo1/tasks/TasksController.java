package com.scaler.springdemo1.tasks;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/tasks")
@RestController
public class TasksController {

    @Data
    static class AddTaskBody {
        String task;
    }

    @Autowired TasksService tasksService;

    @GetMapping("/")
    List<TasksService.Task> getAllTask() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    TasksService.Task getTaskById(@PathVariable("id") int taskId) {
        return tasksService.getTask(taskId);
    }

    @PostMapping("/")
    TasksService.Task addNewTask(@RequestBody AddTaskBody body) {
        var index = tasksService.addTask(body.task);
        return tasksService.getTask(index);
    }

    @PutMapping("/{id}/done")
    TasksService.Task setTaskDone(@PathVariable("id") int taskId) {
        tasksService.setTaskDone(taskId, true);
        return tasksService.getTask(taskId);
    }

    @DeleteMapping("/{id}/done")
    TasksService.Task setTaskUndone(@PathVariable("id") int taskId) {
        tasksService.setTaskDone(taskId, false);
        return tasksService.getTask(taskId);
    }
}
