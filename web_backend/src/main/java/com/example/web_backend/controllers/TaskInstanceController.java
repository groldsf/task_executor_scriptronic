package com.example.web_backend.controllers;

import com.example.web_backend.DTO.TaskInstanceDTO;
import com.example.web_backend.entitys.TaskInstance;
import com.example.web_backend.services.TaskInstanceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TaskInstanceController {

    private final TaskInstanceService taskInstanceService;

    public TaskInstanceController(TaskInstanceService taskInstanceService) {
        this.taskInstanceService = taskInstanceService;
    }

    @GetMapping("/task/{taskId}/taskInstances")
    public List<TaskInstanceDTO> getTaskInstancesByTaskId(@PathVariable long taskId){
        return taskInstanceService.getTaskInstancesByTaskID(taskId);
    }

    @GetMapping("/taskInstances")
    public List<TaskInstanceDTO> getTaskInstances(){
        return taskInstanceService.getTaskInstances();
    }

    @GetMapping("taskInstances/{id}")
    public TaskInstanceDTO getTaskInstance(@PathVariable long id){
        return taskInstanceService.getTaskInstanceById(id);
    }
}
