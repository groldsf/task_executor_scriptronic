package com.example.web_backend.repository;

import com.example.web_backend.entitys.TaskInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskInstanceRepository extends JpaRepository<TaskInstance, Long> {

    List<TaskInstance> findTaskInstancesByTaskId(long taskId);

}
