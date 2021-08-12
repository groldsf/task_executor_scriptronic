package com.example.web_backend;

import com.example.web_backend.entitys.Task;
import com.example.web_backend.entitys.TaskInstance;
import com.example.web_backend.repository.TaskInstanceRepository;
import com.example.web_backend.repository.TaskRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitClass implements ApplicationListener<ContextRefreshedEvent> {

    private final List<Task> initTasks = new ArrayList<>();
    private final List<TaskInstance> initTaskInstances = new ArrayList<>();

    private final TaskRepository taskRepository;
    private final TaskInstanceRepository taskInstanceRepository;

    public InitClass(TaskRepository taskRepository, TaskInstanceRepository taskInstanceRepository) {
        this.taskRepository = taskRepository;
        this.taskInstanceRepository = taskInstanceRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("start");

        Task task1 = new Task("sleep");
        Task task2 = new Task("eat");
        Task task3 = new Task("drink");

        initTasks.add(task1);
        initTasks.add(task2);
        initTasks.add(task3);


        TaskInstance taskInstance11 = new TaskInstance(task1);
        TaskInstance taskInstance12 = new TaskInstance(task1);
        TaskInstance taskInstance21 = new TaskInstance(task2);
        TaskInstance taskInstance22 = new TaskInstance(task2);
        TaskInstance taskInstance31 = new TaskInstance(task3);
        TaskInstance taskInstance32 = new TaskInstance(task3);

        initTaskInstances.add(taskInstance11);
        initTaskInstances.add(taskInstance12);
        initTaskInstances.add(taskInstance21);
        initTaskInstances.add(taskInstance22);
        initTaskInstances.add(taskInstance31);
        initTaskInstances.add(taskInstance32);

        taskRepository.saveAll(initTasks);
        taskInstanceRepository.saveAll(initTaskInstances);
    }
}
