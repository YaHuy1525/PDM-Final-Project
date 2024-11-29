package com.example.pdm_final_project.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private String action;
    private String details;
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TodoEntity task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters
    public Long getLogId() {
        return logId;
    }

    public String getAction() {
        return action;
    }

    public String getDetails() {
        return details;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public TodoEntity getTask() {
        return task;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setTask(TodoEntity task) {
        this.task = task;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
