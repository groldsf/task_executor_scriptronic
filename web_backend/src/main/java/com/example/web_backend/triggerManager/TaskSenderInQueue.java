package com.example.web_backend.triggerManager;

import com.example.worker_dto.CommandToWorkerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskSenderInQueue {

//    private final Queue<Object> queue = new ConcurrentLinkedQueue<>();

    private final RestTemplate restTemplate = new RestTemplate();

    private final String uriToSend = "http://localhost:8888/command";

    public void send(CommandToWorkerDto commandToWorkerDto) {
        restTemplate.put(uriToSend, commandToWorkerDto);
    }
}
