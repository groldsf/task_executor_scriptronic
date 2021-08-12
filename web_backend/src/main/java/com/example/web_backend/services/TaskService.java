package com.example.web_backend.services;

import com.example.web_backend.DTO.TaskInstanceDTO;
import com.example.web_backend.entitys.Task;
import com.example.web_backend.entitys.TaskInstance;
import com.example.web_backend.repository.TaskInstanceRepository;
import com.example.web_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskInstanceRepository taskInstanceRepository;

    public TaskService(TaskRepository taskRepository, TaskInstanceRepository taskInstanceRepository) {
        this.taskRepository = taskRepository;
        this.taskInstanceRepository = taskInstanceRepository;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskInstanceDTO triggerTask(long id) {
        Task task = taskRepository.getById(id);
        TaskInstance taskInstance = new TaskInstance(task);
        taskInstance.setStatus("created");
        TaskInstance save = taskInstanceRepository.save(taskInstance);
        return new TaskInstanceDTO(save);
    }
}
