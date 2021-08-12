package com.example.web_backend.controllers;

import com.example.web_backend.DTO.TaskInstanceDTO;
import com.example.web_backend.entitys.Task;
import com.example.web_backend.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public List<Task> getTasks(){
        return taskService.getAll();
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable long id){
        return taskService.getById(id);
    }

    @PostMapping("/task/{id}/trigger")
    public TaskInstanceDTO triggerTask(@PathVariable long id){
        return taskService.triggerTask(id);
    }
}
