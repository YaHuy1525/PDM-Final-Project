package com.example.pdm_final_project.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;
    private String email;
    
    @Column(name = "profile_picture")
    private String profilePicture;
    
    @Column(name = "date_joined")
    private Timestamp dateJoined;
    
    @Column(name = "last_login")
    private Timestamp lastLogin;

    @JsonManagedReference(value = "user-tasks")
    @OneToMany(mappedBy = "user")
    private List<TodoEntity> tasks;

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public List<TodoEntity> getTasks() {
        return tasks;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setTasks(List<TodoEntity> tasks) {
        this.tasks = tasks;
    }

    // Constructor
    public User() {
        this.dateJoined = new Timestamp(System.currentTimeMillis());
        this.lastLogin = new Timestamp(System.currentTimeMillis());
    }
}