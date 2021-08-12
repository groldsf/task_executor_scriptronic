package com.example.task_executor_main_module;

import com.example.task_executor_main_module.implementations.data_objects.DefaultTaskInfo;
import com.example.task_executor_main_module.interfaces.data_objects.TaskResult;
import com.example.task_executor_main_module.interfaces.services.TaskInfoExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TaskExecutorMainModuleApplication {

    public TaskExecutorMainModuleApplication(TaskInfoExecutor taskInfoExecutor) {
        this.taskInfoExecutor = taskInfoExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskExecutorMainModuleApplication.class, args);
    }

    final
    TaskInfoExecutor taskInfoExecutor;

    @PostConstruct
    public void start(){
        TaskResult taskResult = taskInfoExecutor.runTask(new DefaultTaskInfo("Hello!"));
        System.out.println(taskResult);
    }
}
