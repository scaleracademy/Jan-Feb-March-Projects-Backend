package com.scaler.springdemo1.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/tasks")
@RestController
public class TasksController {
    @Autowired TasksService tasksService;

    @GetMapping("/")
    List<TasksService.Task> getAllTask() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/:id")
    String getSomethingElse(@PathVariable int taskId) {
        return "we will return something else here";
    }
}
