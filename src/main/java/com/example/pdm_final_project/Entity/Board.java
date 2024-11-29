package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String name;
    private String description;
    private Timestamp createdAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "board")
    private List<TodoEntity> tasks;

    // Getters
    public Long getBoardId() {
        return boardId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public List<TodoEntity> getTasks() {
        return tasks;
    }

    // Setters
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setTasks(List<TodoEntity> tasks) {
        this.tasks = tasks;
    }
}
