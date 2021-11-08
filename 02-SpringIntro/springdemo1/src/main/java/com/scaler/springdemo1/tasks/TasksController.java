package com.scaler.springdemo1.tasks;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;


@RequestMapping("tasks")
@RestController
public class TasksController {

    @Data
    static class AddTaskBody {
    	@NotEmpty
    	@Size(min = 8, message = "task name should have at least 8 characters")
        String task;
    }

    @Autowired TasksService tasksService;

	@GetMapping()
	List<Task> getAllTask(@RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
			@RequestParam(name = "page", required = false, defaultValue = "1") Integer page) {
		return tasksService.getAllTasks(size, page);
	}
 
    @GetMapping("{id}")
    Task getTaskById(@PathVariable("id") int taskId) {
        return tasksService.getTask(taskId);
    }

    @PostMapping()
    Task addNewTask(@Valid @RequestBody AddTaskBody body) {
        var index = tasksService.addTask(body.task);
        return tasksService.getTask(index);
    }

    @PutMapping("{id}/done")
    Task setTaskDone(@PathVariable("id") int taskId) {
        tasksService.setTaskDone(taskId, true);
        return tasksService.getTask(taskId);
    }

    @DeleteMapping("{id}/done")
    Task setTaskUndone(@PathVariable("id") int taskId) {
        tasksService.setTaskDone(taskId, false);
        return tasksService.getTask(taskId);
    }
}
