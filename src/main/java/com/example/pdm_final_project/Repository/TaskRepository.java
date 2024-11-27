package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
