package com.example.task_executor_main_module.interfaces.services;

import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskInfo;

public interface TaskInfoFindHandler {
    boolean isProcessed(TaskInfo taskInfo);

    Task getTask(TaskInfo taskInfo);
}
