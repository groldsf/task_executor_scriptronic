package com.example.worker.executor.v3;

import com.example.worker.data_value.ExecutorResult;

import java.io.IOException;

public interface ConsoleCommandExecutor3 {

    ExecutorResult createExecutorResult(Process process);

    Process createProcess(String consoleCommand) throws IOException;
}
