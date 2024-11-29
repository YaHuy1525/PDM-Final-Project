package com.example.pdm_final_project.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name = "activity_logs")
@Data
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
}
