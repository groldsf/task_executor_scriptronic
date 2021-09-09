package com.example.worker.executor.v4;

import java.util.ArrayList;
import java.util.List;

public class Executor<State, StartValue> {

    private final List<ExecutorStage<State>> executorStages;
    private final List<ExecutorErrorHandler> executorErrorHandlers;
    private final ExecutorStateCreator<State, StartValue> stateCreator;


    public State execute(StartValue value) throws Exception {
        State state = stateCreator.create(value);
        try {
            executeStages(state);
        }catch (Exception e){
            executorErrorHandlers.forEach(executorErrorHandler -> executorErrorHandler.error(e));
        }
        return state;
    }

    private void executeStages(State state) throws Exception {
        for (ExecutorStage<State> executorStage : executorStages) {
            executorStage.execute(state);
        }
    }


    private Executor(ExecutorBuilder<State, StartValue> builder){
        executorStages = builder.executorStages;
        executorErrorHandlers = builder.executorErrorHandlers;
        stateCreator = builder.stateCreator;
    }

    public static <State, StartValue> ExecutorBuilder<State, StartValue> builder() {
        return new ExecutorBuilder<>();
    }

    public static class ExecutorBuilder<State, StartValue> {

        private final List<ExecutorStage<State>> executorStages = new ArrayList<>();
        private final List<ExecutorErrorHandler> executorErrorHandlers = new ArrayList<>();
        private ExecutorStateCreator<State, StartValue> stateCreator;

        private ExecutorBuilder() {
        }

        public Executor<State, StartValue> build() {
            return new Executor<>(this);
        }

        public ExecutorBuilder<State, StartValue> setStateCreator(ExecutorStateCreator<State, StartValue> stateCreator) {
            this.stateCreator = stateCreator;
            return this;
        }

        public ExecutorBuilder<State, StartValue> addStage(ExecutorStage<State> executorStage) {
            executorStages.add(executorStage);
            return this;
        }

        public ExecutorBuilder<State, StartValue> addErrorHandler(ExecutorErrorHandler executorErrorHandler) {
            executorErrorHandlers.add(executorErrorHandler);
            return this;
        }
    }


}
