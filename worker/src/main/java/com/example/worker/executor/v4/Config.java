package com.example.worker.executor.v4;

import com.example.worker.data_value.ExecutorResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Configuration
public class Config {


    @Bean
    public Executor<State, String> consoleCommandExecutor() {
        Executor<State, String> consoleCommandExecutor = Executor.<State, String>builder()
                .setStateCreator(State::new)
                .addStage(state -> state.process = Runtime.getRuntime().exec(state.startValue))
                .addStage(state -> state.process.waitFor(1000, TimeUnit.SECONDS))
                .addStage(state -> {
                    BufferedReader output = new BufferedReader(new InputStreamReader(state.process.getInputStream()));
                    BufferedReader error = new BufferedReader(new InputStreamReader(state.process.getErrorStream()));
                    String outputLines = output.lines().collect(Collectors.joining("\n"));
                    String errorLines = error.lines().collect(Collectors.joining("\n"));
                    state.executorResult = new ExecutorResult(outputLines, errorLines);
                })
                .addErrorHandler(e->{})
                .build();
        return consoleCommandExecutor;
    }

    public static class State{
        public Process process;
        public ExecutorResult executorResult;
        public String startValue;
        public State(String startValue){
            this.startValue = startValue;
        }
    }
}
