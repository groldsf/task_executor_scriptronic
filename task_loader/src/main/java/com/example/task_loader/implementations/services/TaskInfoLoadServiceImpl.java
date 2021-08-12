package com.example.task_loader.implementations.services;

import com.example.task_loader.interfaces.data_objects.TaskInfo;
import com.example.task_loader.interfaces.services.TaskInfoLoadService;
import com.example.task_loader.interfaces.services.TaskInfoLoader;
import com.example.task_loader.interfaces.services.TaskInfoPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskInfoLoadServiceImpl implements TaskInfoLoadService {

    private final TaskInfoLoader taskInfoLoader;
    private final TaskInfoPublisher taskInfoPublisher;

    public TaskInfoLoadServiceImpl(TaskInfoLoader taskInfoLoader, TaskInfoPublisher taskInfoPublisher) {
        this.taskInfoLoader = taskInfoLoader;
        this.taskInfoPublisher = taskInfoPublisher;
    }

    @Override
    public void loadTasksInfo() {
        Collection<TaskInfo> tasksInfos= taskInfoLoader.loadTasksInfo();
        taskInfoPublisher.publish(tasksInfos);
    }
}
