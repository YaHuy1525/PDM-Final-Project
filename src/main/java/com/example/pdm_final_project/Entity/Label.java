package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private Long labelId;

    private String name;
    private String color;

    @JsonManagedReference(value = "label-tasks")
    @OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
    private List<TodoEntity> tasks;

    // Getters
    public Long getLabelId() {
        return labelId;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<TodoEntity> getTasks() {
        return tasks;
    }

    // Setters
    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTasks(List<TodoEntity> tasks) {
        this.tasks = tasks;
    }
}
