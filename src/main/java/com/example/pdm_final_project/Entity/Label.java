package com.example.pdm_final_project.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "labels")
@Data
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    private String name;
    private String color;

    @OneToMany(mappedBy = "label")
    private List<TodoEntity> tasks;
}
