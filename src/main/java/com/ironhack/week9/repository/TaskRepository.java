package com.ironhack.week9.repository;

import com.ironhack.week9.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
