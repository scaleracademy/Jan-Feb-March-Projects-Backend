package com.scaler.springdemo1.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RequestMapping("/tasks")
@RestController
public class TasksController {

    @Autowired TasksService tasksService;

    @GetMapping("/")
    List<Tasks> getAllTask() {
            return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    Tasks getTaskById(@PathVariable("id") Long taskId) {
        return tasksService.getTask(taskId);
    }

    @PostMapping("/")
    ResponseEntity<Object> addNewTask(@RequestBody Tasks body) {
        var task = tasksService.addTask(body);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{taskId}")
                .buildAndExpand(task.getTaskId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}/done")
    Tasks setTaskUndone(@PathVariable("id") Long taskId) {
        tasksService.setTaskDone(taskId, false);
        return tasksService.getTask(taskId);
    }

    @PutMapping("/{id}/done")
    Tasks setTaskDone(@PathVariable("id") Long taskId) {
            tasksService.setTaskDone(taskId, true);
        return tasksService.getTask(taskId);
    }



//
//    @PutMapping("/{id}/done")
//    TasksService.Task setTaskDone(@PathVariable("id") int taskId) {
//        tasksService.setTaskDone(taskId, true);
//        return tasksService.getTask(taskId);
//    }
//
//    @DeleteMapping("/{id}/done")
//    TasksService.Task setTaskUndone(@PathVariable("id") int taskId) {
//        tasksService.setTaskDone(taskId, false);
//        return tasksService.getTask(taskId);
//    }
}
