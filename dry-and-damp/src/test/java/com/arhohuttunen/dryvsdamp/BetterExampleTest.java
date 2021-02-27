package com.arhohuttunen.dryvsdamp;

import org.junit.jupiter.api.Test;

import static com.arhohuttunen.dryvsdamp.TaskAssert.assertThat;

public class BetterExampleTest {
    @Test
    void stopTaskProgress() {
        Task task = TaskBuilder.inProgressTask(1L).build();

        task.stopProgress();

        assertThat(task).isOpen().isUnassigned();
    }

    @Test
    void finishTask() {
        Task task = TaskBuilder.inProgressTask(1L).build();

        task.finish();

        assertThat(task).isClosed().isAssignedTo(1L);
    }

    @Test
    void startTaskProgress() {
        Task task = TaskBuilder.openTaskWithAssignee(1L).build();

        task.startProgress();

        assertThat(task).isInProgress().isAssignedTo(1L);
    }
}
