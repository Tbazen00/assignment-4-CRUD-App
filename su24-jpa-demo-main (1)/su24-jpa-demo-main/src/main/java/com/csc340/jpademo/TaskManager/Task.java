package com.csc340.jpademo.TaskManager;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private int goalId;
    @Nonnull
    private String title;
    @Nullable
    private String details;
    @Nonnull
    private String status;
    // init all fields
    public Task(int taskId, int goalId, String title, String details, String status) {
        this.taskId = taskId;
        this.goalId = goalId;
        this.title = title;
        this.details = details;
        this.status = status;
    }
    // Getter
    public int getTaskId() {
        return taskId;
    }
    // Setter
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    // Getter
    public int getGoalId() {
        return goalId;
    }
    // Setter
    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }
    // Getter
    @Nonnull
    public String getTitle() {
        return title;
    }
    // Setter
    public void setTitle(@Nonnull String title) {
        this.title = title;
    }
    // Getter
    @Nullable
    public String getDetails() {
        return details;
    }
    // Setter
    public void setDetails(@Nullable String details) {
        this.details = details;
    }
    // Getter
    @Nonnull
    public String getStatus() {
        return status;
    }
    // Setter
    public void setStatus(@Nonnull String status) {
        this.status = status;
    }
    // update current with new method!!
    public void replaceTask(Task newTask) {
        // Update goalId if t is nonzero
        if (newTask.getGoalId() != 0) {
            this.goalId = newTask.getGoalId();
        }
        // Update title if new is not empty
        if (!newTask.getTitle().isEmpty()) {
            this.title = newTask.getTitle();
        }
        // Update details if new are not nulll
        if (newTask.getDetails() != null) {
            this.details = newTask.getDetails();
        }
        // Update status if not empty
        if (!newTask.getStatus().isEmpty()) {
            this.status = newTask.getStatus();
        }
    }
}
