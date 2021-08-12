package com.example.task_executor_main_module.implementations.services;

import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskInfo;
import com.example.task_executor_main_module.interfaces.services.TaskFinder;
import com.example.task_executor_main_module.interfaces.services.TaskInfoFindHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskFinderImpl implements TaskFinder {

    private final List<TaskInfoFindHandler> handlerList;

    public TaskFinderImpl(List<TaskInfoFindHandler> handlerList) {
        this.handlerList = handlerList;
    }

    @Override
    public Task getTask(TaskInfo taskInfo) {
        for (TaskInfoFindHandler taskInfoFindHandler: handlerList){
            if (taskInfoFindHandler.isProcessed(taskInfo)){
                return taskInfoFindHandler.getTask(taskInfo);
            }
        }
        return null;
    }
}
