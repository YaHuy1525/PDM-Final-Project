package com.example.pdm_final_project.Controller;

import com.example.pdm_final_project.Entity.TodoEntity;
import com.example.pdm_final_project.Service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5000")
public class TodoController {
    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoEntity> getAllTasks() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoEntity> getTaskById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/board/{boardId}")
    public List<TodoEntity> getTasksByBoard(@PathVariable Long boardId) {
        return todoService.getTasksByBoard(boardId);
    }

    @GetMapping("/user/{userId}")
    public List<TodoEntity> getTasksByUser(@PathVariable Long userId) {
        return todoService.getTasksByUser(userId);
    }

    @GetMapping("/filter")
    public List<TodoEntity> getFilteredTasks(@RequestParam(required = false) String timeFilter) {
        if (timeFilter == null) {
            return todoService.getAllTodos();
        }

        return switch (timeFilter) {
            case "today" ->todoService.getTodayTasks();
            case "thisWeek"-> todoService.getThisWeekTasks();
            case "thisMonth"-> todoService.getThisMonthTasks();
            default-> todoService.getAllTodos();
        };
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TodoEntity task) {
        try {
            logger.info("Received task creation request with boardId: {}, labelId: {}, userId: {}", 
                task.getBoardId(), task.getLabelId(), task.getUserId());
            
            TodoEntity createdTask = todoService.createTodo(task);
            
            logger.info("Created task with ID: {}, boardId: {}, labelId: {}", 
                createdTask.getTaskId(), createdTask.getBoardId(), createdTask.getLabelId());
            
            return ResponseEntity.ok(createdTask);
        } catch (Exception e) {
            logger.error("Error creating task: ", e);
            return ResponseEntity.badRequest()
                .body("Error creating task: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TodoEntity taskDetails) {
        try {
            logger.info("Updating task {} with boardId: {}, labelId: {}", 
                id, taskDetails.getBoardId(), taskDetails.getLabelId());
            
            TodoEntity updatedTask = todoService.updateTodo(id, taskDetails);
            return ResponseEntity.ok(updatedTask);
        } catch (Exception e) {
            logger.error("Error updating task {}: ", id, e);
            return ResponseEntity.badRequest()
                .body("Error updating task: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            todoService.deleteTodo(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error deleting task {}: ", id, e);
            return ResponseEntity.badRequest()
                .body("Error deleting task: " + e.getMessage());
        }
    }
}
