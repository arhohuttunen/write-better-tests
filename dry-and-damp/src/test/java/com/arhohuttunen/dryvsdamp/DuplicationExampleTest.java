package com.arhohuttunen.dryvsdamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicationExampleTest {
    @Test
    void stopTaskProgress() {
        Task task = new Task();
        task.setTitle("Do the laundry");
        task.setStatus(Task.Status.IN_PROGRESS);
        task.setAssigneeId(1L);

        task.stopProgress();

        assertThat(task.getStatus()).isEqualTo(Task.Status.OPEN);
        assertThat(task.getAssigneeId()).isNull();
    }

    @Test
    void finishTask() {
        Task task = new Task();
        task.setTitle("Do the laundry");
        task.setStatus(Task.Status.IN_PROGRESS);
        task.setAssigneeId(1L);

        task.finish();

        assertThat(task.getStatus()).isEqualTo(Task.Status.CLOSED);
        assertThat(task.getAssigneeId()).isEqualTo(1L);
    }
}
