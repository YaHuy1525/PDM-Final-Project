package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_Id;

    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String profilePicture;
    private Timestamp dateJoined;
    private Timestamp lastLogin;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<TodoEntity> tasks;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<ActivityLog> activityLogs;
}