package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByBoard_BoardId(Long boardId);
    List<TodoEntity> findByUser_User_Id(Long userId);
    List<TodoEntity> findByLabel_LabelId(Long labelId);
    List<TodoEntity> findByStatus(String status);
}