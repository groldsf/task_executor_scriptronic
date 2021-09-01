package com.example.worker_dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class CommandToWorkerDto {
    private long taskId;
    private long taskInstanceId;
    private TaskInfo taskInfo;
}
