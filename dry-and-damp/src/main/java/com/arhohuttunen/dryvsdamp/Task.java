package com.arhohuttunen.dryvsdamp;

import java.time.LocalDateTime;

public class Task {
    enum Status {
        OPEN,
        IN_PROGRESS,
        CLOSED
    }

    private String title;
    private Status status;
    private Long assigneeId;

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public void assign(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public void startProgress() {
        this.status = Status.IN_PROGRESS;
    }

    public void stopProgress() {
        this.status = Status.OPEN;
        this.assigneeId = null;
    }

    public void finish() {
        this.status = Status.CLOSED;
    }
}
