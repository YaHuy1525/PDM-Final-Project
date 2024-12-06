package com.example.pdm_final_project.Service;

import com.example.pdm_final_project.Entity.TodoEntity;
import com.example.pdm_final_project.Entity.User;
import com.example.pdm_final_project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<TodoEntity> getUserTasks(Long userId) {
        return userRepository.findTasksByUserId(userId);
    }

    public User createUser(User user) {
        // Set initial timestamps
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setDateJoined(now);
        user.setLastLogin(now);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            if (userDetails.getUsername() != null) {
                existingUser.setUsername(userDetails.getUsername());
            }
            if (userDetails.getPassword() != null) {
                existingUser.setPassword(userDetails.getPassword());
            }
            if (userDetails.getFullname() != null) {
                existingUser.setFullname(userDetails.getFullname());
            }
            if (userDetails.getEmail() != null) {
                existingUser.setEmail(userDetails.getEmail());
            }
            if (userDetails.getProfilePicture() != null) {
                existingUser.setProfilePicture(userDetails.getProfilePicture());
            }
            existingUser.setLastLogin(new Timestamp(System.currentTimeMillis()));
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
