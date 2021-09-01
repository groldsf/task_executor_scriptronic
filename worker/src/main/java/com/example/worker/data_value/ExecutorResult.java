package com.example.worker.data_value;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExecutorResult {
    private final String output;
    private final String error;
}
