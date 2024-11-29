package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "boards")
@Data
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
}
