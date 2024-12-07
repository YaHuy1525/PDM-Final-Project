package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.TodoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    @Query(value = "SELECT * FROM tasks WHERE board_id = :boardId", nativeQuery = true)
    List<TodoEntity> findByBoardId(@Param("boardId") Long boardId);

    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId", nativeQuery = true)
    List<TodoEntity> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM tasks WHERE CAST(due_date AS DATE) = CAST(GETDATE() AS DATE)", nativeQuery = true)
    List<TodoEntity> findTodayTasks();

    @Query(value = "SELECT * FROM tasks WHERE due_date BETWEEN GETDATE() AND DATEADD(day, 7, GETDATE())", nativeQuery = true)
    List<TodoEntity> findThisWeekTasks();

    @Query(value = "SELECT * FROM tasks WHERE YEAR(due_date) = YEAR(GETDATE()) AND MONTH(due_date) = MONTH(GETDATE())", nativeQuery = true)
    List<TodoEntity> findThisMonthTasks();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tasks (title, description, status, due_date, created_at, board_id, user_id, label_id) " +
           "VALUES (:title, :description, :status, :dueDate, :createdAt, :boardId, :userId, :labelId)", nativeQuery = true)
    void saveTodo(@Param("title") String title,
                 @Param("description") String description,
                 @Param("status") String status,
                 @Param("dueDate") Date dueDate,
                 @Param("createdAt") Timestamp createdAt,
                 @Param("boardId") Long boardId,
                 @Param("userId") Long userId,
                 @Param("labelId") Long labelId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tasks SET title = :title, description = :description, " +
           "status = :status, due_date = :dueDate, board_id = :boardId, " +
           "label_id = :labelId WHERE task_id = :taskId", nativeQuery = true)
    void updateTodo(@Param("taskId") Long taskId,
                   @Param("title") String title,
                   @Param("description") String description,
                   @Param("status") String status,
                   @Param("dueDate") Date dueDate,
                   @Param("boardId") Long boardId,
                   @Param("labelId") Long labelId);

    @Query(value = "SELECT * FROM tasks WHERE task_id = :taskId", nativeQuery = true)
    TodoEntity findTodoById(@Param("taskId") Long taskId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tasks WHERE task_id = :taskId", nativeQuery = true)
    void deleteTodoById(@Param("taskId") Long taskId);
}