package com.arhohuttunen.dryvsdamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WorseExampleTest {
    private Task task;

    @BeforeEach
    void setupTask() {
        task = new Task();
        task.setTitle("Do the laundry");
        task.setStatus(Task.Status.IN_PROGRESS);
        task.setAssigneeId(1L);
    }

    @Test
    void stopTaskProgress() {
        task.stopProgress();

        assertThat(task.getStatus()).isEqualTo(Task.Status.OPEN);
        assertThat(task.getAssigneeId()).isNull();
    }

    @Test
    void finishTask() {
        task.finish();

        assertThat(task.getStatus()).isEqualTo(Task.Status.CLOSED);
        assertThat(task.getAssigneeId()).isEqualTo(1L);
    }

    @Test
    void startTaskProgress() {
        task.setStatus(Task.Status.OPEN);
        task.startProgress();

        assertThat(task.getStatus()).isEqualTo(Task.Status.IN_PROGRESS);
        assertThat(task.getAssigneeId()).isEqualTo(1L);
    }
}
