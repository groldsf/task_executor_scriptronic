package com.example.web_backend.services;

import com.example.web_backend.DTO.TaskInstanceDTO;
import com.example.web_backend.entitys.Task;
import com.example.web_backend.entitys.TaskInstance;
import com.example.web_backend.repository.TaskRepository;
import com.example.web_backend.triggerManager.TriggerManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    private final TriggerManager triggerManager;

    public TaskService(TaskRepository taskRepository, TriggerManager triggerManager) {
        this.taskRepository = taskRepository;
        this.triggerManager = triggerManager;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskInstanceDTO triggerTask(long id) {
        TaskInstance taskInstance = triggerManager.triggerTask(id);
        return new TaskInstanceDTO(taskInstance);
    }
}
