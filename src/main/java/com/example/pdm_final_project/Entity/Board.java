package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @Column(name = "created_at")
    private Timestamp createdAt;

    @JsonManagedReference(value = "board-tasks")
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TodoEntity> tasks = new ArrayList<>();

    // Default constructor
    public Board() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // Constructor with name and description
    public Board(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

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

    // Helper method to add a task
    public void addTask(TodoEntity task) {
        tasks.add(task);
        task.setBoard(this);
    }

    // Helper method to remove a task
    public void removeTask(TodoEntity task) {
        tasks.remove(task);
        task.setBoard(null);
    }
}
