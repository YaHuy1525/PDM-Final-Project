package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String title;
    private String description;
    private String status;
    private Timestamp dueDate;
    private Timestamp createdAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

    @OneToMany(mappedBy = "task")
    private List<ActivityLog> activityLogs;
}
