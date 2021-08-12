package com.example.task_executor_main_module.implementations.data_objects;

import com.example.task_executor_main_module.interfaces.data_objects.Task;

public class DefaultTask implements Task {
    private final String message;

    public DefaultTask(String message) {
        this.message = message;
    }

    public void run(){
        System.out.println(message);
    }
}
