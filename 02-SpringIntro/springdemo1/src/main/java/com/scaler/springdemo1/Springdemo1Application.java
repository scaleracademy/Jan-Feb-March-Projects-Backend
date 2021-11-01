package com.scaler.springdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class Springdemo1Application implements CommandLineRunner {
public class Springdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springdemo1Application.class, args);
	}
//
//	@Autowired
//	private TaskRepository taskRepository;
//	@Autowired
//	private TaskRepository taskRepository;

//	@Override
//	public void run(String... args) throws Exception {
//		Tasks task1 = new Tasks(10001L,"Task1", false);
//		taskRepository.save(task1);
//		Tasks task2 = new Tasks(10001L,"Task1", false);
//		taskRepository.save(task2);
//		Tasks task3 = new Tasks(10001L,"Task1", false);
//		taskRepository.save(task3);
//	}
}
