package com.example.task_loader.interfaces.services;

import com.example.task_loader.interfaces.data_objects.TaskInfo;

import java.util.Collection;

public interface TaskInfoPublisher {
    void publish(Collection<TaskInfo> tasksInfos);
}
