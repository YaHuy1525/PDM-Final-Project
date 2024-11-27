package com.example.pdm_final_project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "Task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String title;
    private String status;
    private String Description;
    private long labelId;
    @CreationTimestamp
    @Column(nullable = false,updatable = false )
    private Timestamp dueDate;
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updateAt;
}
