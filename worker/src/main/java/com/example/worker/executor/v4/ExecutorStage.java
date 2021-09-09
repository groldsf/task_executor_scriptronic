package com.example.worker.executor.v4;

public interface ExecutorStage<State> {
    void execute(State executorState) throws Exception;
}
