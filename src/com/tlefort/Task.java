package com.tlefort;

import java.util.UUID;

public class Task {
    private final UUID id = UUID.randomUUID();
    private String title;
    private String description;
    private Boolean done;
    private User createdBy;

    public Task(String title, String description, boolean b, User createdBy) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.done = false;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done" + done +
                ", createdBy" + createdBy +
                '}';
    }
}
