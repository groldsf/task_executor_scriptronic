package com.example.web_backend.triggerManager;

import com.example.web_backend.entitys.Task;
import com.example.web_backend.entitys.TaskInstance;
import com.example.web_backend.repository.TaskInstanceRepository;
import com.example.web_backend.repository.TaskRepository;
import com.example.web_backend.triggerManager.mapper.CommandConstructor;
import com.example.worker_dto.CommandToWorkerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskActivator {

    private final TaskRepository taskRepository;
    private final TaskInstanceRepository taskInstanceRepository;
    private final TaskSenderInQueue taskSender;
    private final CommandConstructor commandConstructor;


    public TaskInstance triggerTask(long id) {
        Task task = taskRepository.getById(id);
        TaskInstance taskInstance = new TaskInstance(task);
        taskInstance.setStatus("created");
        TaskInstance taskInstance1 = taskInstanceRepository.save(taskInstance);


        CommandToWorkerDto command = commandConstructor.createCommand(taskInstance1);
        taskSender.send(command);

        return taskInstance1;
    }
}
