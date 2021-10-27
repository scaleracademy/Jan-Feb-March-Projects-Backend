package com.scaler.springdemo1.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TasksServiceTests {

    private TasksService getTaskService() {
        return new TasksService();
    }

    @Test
    void addTaskWorks() {
        var service = getTaskService();
        var taskName = "This is a task";
        var index = service.addTask(taskName);
        assertEquals(0, index);
    }

    @Test
    void getTaskWorks() {
        var service = getTaskService();
        var taskName = "This is a task";
        var index = service.addTask(taskName);
        var task = service.getTask(0);
        assertEquals(taskName, task.name);
    }

    @Test
    void setTaskDoneWorks() {
        var service = getTaskService();
        var taskName = "This is a task";
        service.addTask(taskName);
        service.setTaskDone(0, true);
        assertTrue(service.getTask(0).isDone());
    }


}
