package com.csc340.jpademo.TaskManager;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "goals")
public class Goal {
    // identifier for each
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goalId;
    // Identifier for the user
    private int userId;
    // Title of the goal, cannot be null
    @Nonnull
    private String title;
    // details about the goal
    @Nullable
    private String details;
    // Target date for achieving
    @Temporal(TemporalType.DATE)
    private Date targetDate;
    //status of the goal
    private String status;
    // constructor
    public Goal() {}
    //initialize all fields
    public Goal(int goalId, int userId, String title, String details, Date targetDate, String status) {
        this.goalId = goalId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
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
    public int getUserId() {
        return userId;
    }
    // Setter
    public void setUserId(int userId) {
        this.userId = userId;
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
    public Date getTargetDate() {
        return targetDate;
    }
    // Setter
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
    // Getter
    public String getStatus() {
        return status;
    }
    // Setter
    public void setStatus(String status) {
        this.status = status;
    }
    // update current goal
    public void replaceGoal(Goal newGoal) {
        // Update userId if nonzero
        if (newGoal.getUserId() != 0) {
            this.userId = newGoal.getUserId();
        }
        // Update title if notempty
        if (!newGoal.getTitle().isEmpty()) {
            this.title = newGoal.getTitle();
        }
        // Update details ig not null
        if (newGoal.getDetails() != null) {
            this.details = newGoal.getDetails();
        }
        // Update targetDate if notynull
        if (newGoal.getTargetDate() != null) {
            this.targetDate = newGoal.getTargetDate();
        }
        // Update status if new is not empty
        if (!newGoal.getStatus().isEmpty()) {
            this.status = newGoal.getStatus();
        }
    }
}



