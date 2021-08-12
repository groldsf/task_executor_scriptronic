package com.example.task_executor_main_module.interfaces.services;

import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskResult;

public interface TaskExecutorHandler {
    boolean isProcessed(Task task);

    TaskResult execute(Task task);
}
