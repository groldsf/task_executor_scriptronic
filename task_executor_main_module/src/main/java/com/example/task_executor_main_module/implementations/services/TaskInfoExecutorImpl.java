package com.example.task_executor_main_module.implementations.services;

import com.example.task_executor_main_module.interfaces.data_objects.Task;
import com.example.task_executor_main_module.interfaces.data_objects.TaskInfo;
import com.example.task_executor_main_module.interfaces.data_objects.TaskResult;
import com.example.task_executor_main_module.interfaces.services.TaskExecutor;
import com.example.task_executor_main_module.interfaces.services.TaskFinder;
import com.example.task_executor_main_module.interfaces.services.TaskInfoExecutor;
import org.springframework.stereotype.Service;

@Service
public class TaskInfoExecutorImpl implements TaskInfoExecutor {

    private final TaskFinder taskFinder;
    private final TaskExecutor taskExecutor;

    public TaskInfoExecutorImpl(TaskFinder taskFinder, TaskExecutor taskExecutor) {
        this.taskFinder = taskFinder;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public TaskResult runTask(TaskInfo taskInfo) {

        Task task = taskFinder.getTask(taskInfo);
        return taskExecutor.execute(task);
    }
}
