package com.example.worker.controller;

import com.example.worker_dto.CommandToWorkerDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @PutMapping("/command")
    public void toWork(@RequestBody CommandToWorkerDto command){
        System.out.println("command: { " +
                "taskId: " + command.getTaskId() + ", " +
                "taskInstanceId: " + command.getTaskInstanceId() +
                "}");
    }

}
