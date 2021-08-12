package com.example.task_executor_main_module.implementations.data_objects;

import com.example.task_executor_main_module.interfaces.data_objects.TaskInfo;

public class DefaultTaskInfo implements TaskInfo {

    private final String message;

    public DefaultTaskInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
