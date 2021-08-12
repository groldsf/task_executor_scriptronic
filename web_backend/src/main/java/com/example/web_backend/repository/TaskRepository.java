package com.example.web_backend.repository;

import com.example.web_backend.entitys.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
