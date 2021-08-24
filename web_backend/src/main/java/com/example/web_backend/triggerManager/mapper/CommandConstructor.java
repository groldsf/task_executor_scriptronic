package com.example.web_backend.triggerManager.mapper;

import com.example.web_backend.entitys.TaskInstance;
import com.example.web_backend.triggerManager.dto.CommandToWorkerDto;
import com.example.web_backend.triggerManager.dto.TaskInfo;
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
