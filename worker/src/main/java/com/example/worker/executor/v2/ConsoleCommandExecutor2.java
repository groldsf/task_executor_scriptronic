package com.example.worker.executor.v2;

import com.example.worker.data_value.ExecutorResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ConsoleCommandExecutor2 extends AbstractCommandExecutor {
    @Override
    protected ExecutorResult createExecutorResult(Process process) {
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String outputLines = output.lines().collect(Collectors.joining("\n"));
        String errorLines = error.lines().collect(Collectors.joining("\n"));
        return new ExecutorResult(outputLines, errorLines);
    }

    @Override
    protected Process createProcess(String consoleCommand) throws IOException {
        return Runtime.getRuntime()
                .exec(consoleCommand);
    }
}
