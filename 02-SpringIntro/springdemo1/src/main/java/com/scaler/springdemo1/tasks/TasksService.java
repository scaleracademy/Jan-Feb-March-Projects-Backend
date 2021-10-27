package com.scaler.springdemo1.tasks;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService {

    @AllArgsConstructor
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    static class Task {
        String name;
        boolean done;
    }

    private ArrayList<Task> tasks = new ArrayList<>();

    List<Task> getAllTasks() {
        return tasks;
    }

    int addTask(String taskName) {
        var task = new Task(taskName, false);
        tasks.add(task);
        return tasks.indexOf(task);
    }

    Task getTask(int index) {
        var task = tasks.get(index); // handle case of wrong index
        return task;
    }

    Task setTaskDone(int index, boolean done) {
        var task = tasks.get(index);
        task.setDone(done);
        return task;
    }
}
