package com.example.web_backend.DTO;

import com.example.web_backend.entitys.TaskInstance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class TaskInstanceDTO {
    long id;
    long task_id;

    public TaskInstanceDTO(TaskInstance taskInstance){
        id = taskInstance.getId();
        task_id = taskInstance.getTask().getId();
    }
}
