package com.example.web_backend.triggerManager.mapper;

import com.example.web_backend.entitys.TaskInstance;
import com.example.worker_dto.CommandToWorkerDto;
import com.example.worker_dto.TaskInfo;
import org.springframework.stereotype.Service;

@Service
public class CommandConstructor {

    public CommandToWorkerDto createCommand(TaskInstance taskInstance){
        return CommandToWorkerDto.builder()
                .taskId(taskInstance.getTask().getId())
                .taskInstanceId(taskInstance.getId())
                .taskInfo(new TaskInfo())
                .build();
    }
}
