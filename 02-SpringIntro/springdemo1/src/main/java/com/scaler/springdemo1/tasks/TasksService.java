package com.scaler.springdemo1.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TasksService {
    @Autowired
    private TaskRepository taskRepository;

    private EntityManager em;

    private static Long taskIdCount = Long.valueOf(10005);
    private ArrayList<Tasks> tasks = new ArrayList<>();

    List<Tasks> getAllTasks() {
        log.info("Inside find all tasks method");
        tasks = (ArrayList<Tasks>) taskRepository.findAll();
        return tasks;
    }

    Page<Tasks> getAllTasks(Pageable pageable) {
        log.info("Inside find all tasks method");
        Page<Tasks> tasks = taskRepository.getAllTasks(pageable);
        return tasks;
    }

    Tasks addTask(Tasks tasks) {
        if(tasks.getTaskId() == null){
            tasks.setTaskId(++taskIdCount);
        }
        return taskRepository.save(tasks);
    }

    Tasks getTask(Long index) {
        return taskRepository.findByTaskId(index);
    }

    Tasks setTaskDone(Long index, boolean done) {
        var task = tasks.get(Math.toIntExact(index));
        task.setDone(done);
        return task;
    }
}
