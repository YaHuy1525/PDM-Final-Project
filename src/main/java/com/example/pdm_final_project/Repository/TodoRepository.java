package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    @Query(value = "SELECT * FROM tasks WHERE board_id = :boardId", nativeQuery = true)
    List<TodoEntity> findByBoardId(@Param("boardId") Long boardId);

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<TodoEntity> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM tasks WHERE label_id = :labelId", nativeQuery = true)
    List<TodoEntity> findByLabelId(@Param("labelId") Long labelId);

    @Query(value = "SELECT * FROM tasks WHERE status = :status", nativeQuery = true)
    List<TodoEntity> findByStatus(@Param("status") String status);
}