package com.scaler.springdemo3.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService {
    @Autowired TasksRepository tasksRepo;

    List<Task> getAllTasks() {
        return tasksRepo.findAll();
    }

    Task addTask(String taskName) {
        var task = new Task(taskName, false);
        var savedTask = tasksRepo.save(task);
        return savedTask;
    }

    Task getTask(int index) {
        var task = tasksRepo.getById(index); // handle case of wrong index
        return task;
    }

    Task setTaskDone(int index, boolean done) {
        var task = tasksRepo.getById(index);
        task.setDone(done);
        var updatedTask = tasksRepo.save(task);
        return updatedTask;
    }
}
