package com.arhohuttunen.dryvsdamp;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class TaskAssert extends AbstractAssert<TaskAssert, Task> {
    protected TaskAssert(Task task) {
        super(task, TaskAssert.class);
    }

    public static TaskAssert assertThat(Task task) {
        return new TaskAssert(task);
    }

    public TaskAssert isOpen() {
        Assertions.assertThat(actual.getStatus()).isEqualTo(Task.Status.OPEN);
        return this;
    }

    public TaskAssert isInProgress() {
        Assertions.assertThat(actual.getStatus()).isEqualTo(Task.Status.IN_PROGRESS);
        return this;
    }

    public TaskAssert isClosed() {
        Assertions.assertThat(actual.getStatus()).isEqualTo(Task.Status.CLOSED);
        return this;
    }

    public TaskAssert isUnassigned() {
        Assertions.assertThat(actual.getAssigneeId()).isNull();
        return this;
    }

    public TaskAssert isAssignedTo(Long assigneeId) {
        Assertions.assertThat(actual.getAssigneeId()).isEqualTo(assigneeId);
        return this;
    }
}
