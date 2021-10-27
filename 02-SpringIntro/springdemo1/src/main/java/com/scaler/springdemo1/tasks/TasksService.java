package com.scaler.springdemo1.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
	
	@Autowired
	private TaskRepository taskRepository;

	List<Task> getAllTasks(Integer size, Integer page) {
		Pageable pageable;

		pageable = PageRequest.of(page - 1, size);

		return taskRepository.findAll(pageable).getContent();
	}

    int addTask(String taskName) {
        var task = new Task(taskName, false);
		task = taskRepository.save(task);
		return task.getId();
    }

    Task getTask(int index) {
        var task = taskRepository.getById(index); // handle case of wrong index
        return task;
    }

    Task setTaskDone(int index, boolean done) {
        var task = taskRepository.getById(index);
        task.setDone(done);
        return task;
    }
}
