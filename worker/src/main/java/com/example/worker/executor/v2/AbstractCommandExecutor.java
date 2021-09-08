package com.example.worker.executor.v2;

import com.example.worker.data_value.ExecutorResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class AbstractCommandExecutor {

    protected abstract ExecutorResult createExecutorResult(Process process);

    protected abstract Process createProcess(String consoleCommand) throws IOException;

    public ExecutorResult execute(String consoleCommand) throws IOException, InterruptedException {
        Process process = createProcess(consoleCommand);
        startEvent();
        process.waitFor(1000, TimeUnit.SECONDS);
        endEvent();
        ExecutorResult result = createExecutorResult(process);
        return result;
    }

    private void startEvent(){

    }
    private void endEvent(){

    }


}
