package com.example.web_backend.services;

import com.example.web_backend.DTO.TaskInstanceDTO;
import com.example.web_backend.repository.TaskInstanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskInstanceService {

    private final TaskInstanceRepository taskInstanceRepository;


    public TaskInstanceService(TaskInstanceRepository taskInstanceRepository) {
        this.taskInstanceRepository = taskInstanceRepository;
    }

    @Transactional
    public List<TaskInstanceDTO> getTaskInstancesByTaskID(long taskId){
        List<TaskInstanceDTO> res = taskInstanceRepository.findTaskInstancesByTaskId(taskId).stream().map(
                TaskInstanceDTO::new
        ).collect(Collectors.toList());
        return res;
    }


    public List<TaskInstanceDTO> getTaskInstances() {
        List<TaskInstanceDTO> res = taskInstanceRepository.findAll()
                .stream().map(TaskInstanceDTO::new).collect(Collectors.toList());
        return res;
    }

    public TaskInstanceDTO getTaskInstanceById(long id) {
        TaskInstanceDTO dto = new TaskInstanceDTO(taskInstanceRepository.getById(id));
        return dto;
    }
}
