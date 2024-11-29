package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.TodoEntity;
import com.example.pdm_final_project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByFullname(String fullname);
    //@Query("Query here")
    List<TodoEntity> findAllTasks();
}
