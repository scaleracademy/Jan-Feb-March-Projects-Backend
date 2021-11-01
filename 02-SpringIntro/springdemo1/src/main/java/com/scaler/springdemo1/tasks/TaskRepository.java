package com.scaler.springdemo1.tasks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
    Tasks findByTaskId(Long taskId);

    //Pageable will have current Page and task per page
    //giving exception [java.lang.Long] is incompatible with query return type
    //TODO Need to check Entity Manager docs
    @Query("from Tasks")
    Page<Tasks> getAllTasks(Pageable pageable);
}
