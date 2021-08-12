package com.example.task_executor_main_module.implementations.services;

import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskResult;
import com.example.task_executor_main_module.interfaces.services.TaskExecutor;
import com.example.task_executor_main_module.interfaces.services.TaskExecutorHandler;
import com.example.task_executor_main_module.interfaces.services.TaskInfoFindHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskExecutorImpl implements TaskExecutor {

    private final List<TaskExecutorHandler> handlerList;

    public TaskExecutorImpl(List<TaskExecutorHandler> handlerList) {
        this.handlerList = handlerList;
    }

    @Override
    public TaskResult execute(Task task) {
        for (TaskExecutorHandler taskExecutorHandler: handlerList){
            if (taskExecutorHandler.isProcessed(task)){
                return taskExecutorHandler.execute(task);
            }
        }
        return null;
    }
}
