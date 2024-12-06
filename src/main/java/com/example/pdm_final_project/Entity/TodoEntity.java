package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(nullable = false)
    private String title;
    
    private String description;
    private String status;
    
    @Column(name = "due_date")
    private Timestamp dueDate;
    
    @Column(name = "created_at")
    private Timestamp createdAt;

    @JsonBackReference(value = "board-tasks")
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @JsonBackReference(value = "user-tasks")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

    // Getters
    public Long getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public Board getBoard() {
        return board;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonIgnore
    public Label getLabel() {
        return label;
    }

    // Custom getters for label information
    @JsonProperty("labelId")
    public Long getLabelId() {
        return label != null ? label.getLabelId() : null;
    }

    @JsonProperty("labelName")
    public String getLabelName() {
        return label != null ? label.getName() : null;
    }

    @JsonProperty("labelColor")
    public String getLabelColor() {
        return label != null ? label.getColor() : null;
    }

    // Setters
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    // Constructor
    public TodoEntity() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.status = "PENDING";
    }
}
