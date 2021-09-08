package com.example.worker.executor.v3;

import com.example.worker.data_value.ExecutorResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExecutorManager {
    private final ConsoleCommandExecutor3 consoleCommandExecutor3;

    public ExecutorManager(ConsoleCommandExecutor3 consoleCommandExecutor3) {
        this.consoleCommandExecutor3 = consoleCommandExecutor3;
    }

    public ExecutorResult execute(String consoleCommand) throws IOException, InterruptedException {
        Process process = consoleCommandExecutor3.createProcess(consoleCommand);
        startEvent();
        process.waitFor(1000, TimeUnit.SECONDS);
        endEvent();
        ExecutorResult result = consoleCommandExecutor3.createExecutorResult(process);
        return result;
    }

    private void startEvent(){

    }
    private void endEvent(){

    }
}
