package com.example.task_executor_main_module.interfaces.services;

import com.example.task_executor_main_module.interfaces.data_objects.TaskInfo;
import com.example.task_executor_main_module.interfaces.data_objects.TaskResult;

public interface TaskInfoExecutor {

    TaskResult runTask(TaskInfo taskInfo);

}
