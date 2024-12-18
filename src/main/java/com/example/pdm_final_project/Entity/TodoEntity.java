package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
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
    private Date dueDate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @JsonBackReference(value = "board-tasks")
    @ManyToOne()
    @JoinColumn(name = "board_id")
    private Board board;

    @JsonBackReference(value = "user-tasks")
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference(value = "label-tasks")
    @ManyToOne()
    @JoinColumn(name = "label_id")
    private Label label;

    @Transient
    private Long boardId;

    @Transient
    private Long userId;

    @Transient
    private Long labelId;

    public TodoEntity() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.status = "Ongoing";
    }


    // Getters
    @JsonProperty("taskId")
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

    public Date getDueDate() {
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

    @JsonProperty("boardId")
    public Long getBoardId() {
        if (boardId != null) return boardId;
        return board != null ? board.getBoardId() : null;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    @JsonProperty("userId")
    public Long getUserId() {
        if (userId != null) return userId;
        return user != null ? user.getUserId() : null;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonProperty("labelId")
    public Long getLabelId() {
        if (labelId != null) return labelId;
        return label != null ? label.getLabelId() : null;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    @JsonProperty("labelName")
    public String getLabelName() {
        return label.getName();
    }

    @JsonProperty("labelColor")
    public String getLabelColor() {
        return label.getColor();
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

    public void setDueDate(Date dueDate) {
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


    //I SHOULD HAVE USED LOMBOK
}
