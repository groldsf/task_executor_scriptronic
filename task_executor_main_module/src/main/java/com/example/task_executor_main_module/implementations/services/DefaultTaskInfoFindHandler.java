package com.example.task_executor_main_module.implementations.services;

import com.example.task_executor_main_module.implementations.data_objects.DefaultTask;
import com.example.task_executor_main_module.implementations.data_objects.DefaultTaskInfo;
import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskInfo;
import com.example.task_executor_main_module.interfaces.services.TaskInfoFindHandler;
import org.springframework.stereotype.Service;


@Service
public class DefaultTaskInfoFindHandler implements TaskInfoFindHandler {

    @Override
    public boolean isProcessed(TaskInfo taskInfo) {
        return taskInfo instanceof DefaultTaskInfo;
    }

    @Override
    public Task getTask(TaskInfo taskInfo) {
        DefaultTaskInfo defaultTaskInfo = (DefaultTaskInfo) taskInfo;
        return new DefaultTask(defaultTaskInfo.getMessage());
    }
}
