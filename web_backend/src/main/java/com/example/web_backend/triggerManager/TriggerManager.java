package com.example.web_backend.triggerManager;

import com.example.web_backend.entitys.TaskInstance;
import org.springframework.stereotype.Service;

@Service
public class TriggerManager {

    private final TaskActivator taskActivator;

    public TriggerManager(TaskActivator taskActivator) {
        this.taskActivator = taskActivator;
    }


    public TaskInstance triggerTask(long id) {
        return taskActivator.triggerTask(id);
    }
}
