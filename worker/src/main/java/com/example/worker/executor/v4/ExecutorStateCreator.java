package com.example.worker.executor.v4;

public interface ExecutorStateCreator<State, StartValue> {
    State create(StartValue startValue) throws Exception;
}
