package com.example.task_executor_main_module.implementations.services;

import com.example.task_executor_main_module.implementations.data_objects.DefaultTask;
import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskResult;
import com.example.task_executor_main_module.interfaces.services.TaskExecutorHandler;
import org.springframework.stereotype.Service;

@Service
public class DefaultTaskExecutorHandler implements TaskExecutorHandler {
    @Override
    public boolean isProcessed(Task task) {
        return task instanceof DefaultTask;
    }

    @Override
    public TaskResult execute(Task task) {
        DefaultTask defaultTask = (DefaultTask) task;
        defaultTask.run();
        return null;
    }
}
