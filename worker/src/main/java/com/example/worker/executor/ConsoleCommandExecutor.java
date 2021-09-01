package com.example.worker.executor;

import com.example.worker.data_value.ExecutorResult;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ConsoleCommandExecutor {

    //"java -cp dist;libs examples.DependencyExample"
    public ExecutorResult execute(String consoleCommand) throws IOException, InterruptedException {
        Process process = createProcess(consoleCommand);
        process.waitFor(1000, TimeUnit.SECONDS);
        ExecutorResult result = createExecutorResult(process);
        return result;
    }

    private ExecutorResult createExecutorResult(Process process) {
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
//        Writer output = new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8);
//        output.write("1 2\n");
//        output.flush();
        String outputLines = output.lines().collect(Collectors.joining("\n"));
        String errorLines = error.lines().collect(Collectors.joining("\n"));
        return new ExecutorResult(outputLines, errorLines);
    }

    private Process createProcess(String consoleCommand) throws IOException {
        return Runtime.getRuntime()
                .exec(consoleCommand);
    }

}
