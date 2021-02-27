package com.arhohuttunen.dryvsdamp;

public class TaskBuilder {
    private String title = "Not relevant";
    private Task.Status status;
    private Long assigneeId;

    public static TaskBuilder builder() {
        return new TaskBuilder();
    }

    public static TaskBuilder openTaskWithAssignee(Long assigneeId) {
        return builder().openStatus().withAssignee(assigneeId);
    }

    public static TaskBuilder inProgressTask(Long assigneeId) {
        return builder().inProgressStatus().withAssignee(assigneeId);
    }

    public TaskBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder openStatus() {
        this.status = Task.Status.OPEN;
        return this;
    }

    public TaskBuilder inProgressStatus() {
        this.status = Task.Status.IN_PROGRESS;
        return this;
    }

    public TaskBuilder closedStatus() {
        this.status = Task.Status.CLOSED;
        return this;
    }

    public TaskBuilder withAssignee(Long assigneeId) {
        this.assigneeId = assigneeId;
        return this;
    }

    public Task build() {
        Task task = new Task();
        task.setTitle(title);
        task.setStatus(status);
        task.setAssigneeId(assigneeId);
        return task;
    }
}
