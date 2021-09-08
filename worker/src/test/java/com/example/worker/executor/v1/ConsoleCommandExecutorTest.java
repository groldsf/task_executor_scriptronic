package com.example.worker.executor.v1;

import com.example.worker.data_value.ExecutorResult;
import com.example.worker.executor.v1.ConsoleCommandExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleCommandExecutorTest {

    private ConsoleCommandExecutor executor;

    @BeforeEach
    void tearUp() {
        executor = new ConsoleCommandExecutor();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void execute() throws IOException, InterruptedException {
        {
            ExecutorResult result = executor.execute("javac -d tasks\\class tasks\\java\\TestApplication.java");
            assertTrue(result.getError().isBlank());
            assertTrue(result.getOutput().isBlank());
        }
        {
            ExecutorResult result = executor.execute("java -cp tasks\\class TestApplication");
            assertTrue(result.getError().isBlank());
            assertEquals("Hello World", result.getOutput());
        }

    }
}