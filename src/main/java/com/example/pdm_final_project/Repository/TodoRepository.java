package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByBoardId(Long boardId);
    List<TodoEntity> findByUserId(Long userId);
    List<TodoEntity> findByLabelId(Long labelId);
    List<TodoEntity> findByStatus(String status);
}
