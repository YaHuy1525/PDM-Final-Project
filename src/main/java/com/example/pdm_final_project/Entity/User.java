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

    // Getters
    public Long getUser_Id() {
        return user_Id;
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

    public List<ActivityLog> getActivityLogs() {
        return activityLogs;
    }

    // Setters
    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
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

    public void setActivityLogs(List<ActivityLog> activityLogs) {
        this.activityLogs = activityLogs;
    }
}