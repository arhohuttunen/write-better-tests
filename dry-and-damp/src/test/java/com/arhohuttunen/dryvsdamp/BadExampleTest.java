package com.arhohuttunen.dryvsdamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BadExampleTest {
    private static final String TASK_TITLE = "Do the laundry";
    private static final Task.Status TASK_STATUS = Task.Status.IN_PROGRESS;
    private static final Long TASK_ASSIGNEE = 1L;

    @Test
    void stopTaskProgress() {
        Task task = new Task();
        task.setTitle(TASK_TITLE);
        task.setStatus(TASK_STATUS);
        task.setAssigneeId(TASK_ASSIGNEE);

        task.stopProgress();

        assertThat(task.getStatus()).isEqualTo(Task.Status.OPEN);
        assertThat(task.getAssigneeId()).isNull();
    }

    @Test
    void finishTask() {
        Task task = new Task();
        task.setTitle(TASK_TITLE);
        task.setStatus(TASK_STATUS);
        task.setAssigneeId(TASK_ASSIGNEE);

        task.finish();

        assertThat(task.getStatus()).isEqualTo(Task.Status.CLOSED);
        assertThat(task.getAssigneeId()).isEqualTo(TASK_ASSIGNEE);
    }
}
