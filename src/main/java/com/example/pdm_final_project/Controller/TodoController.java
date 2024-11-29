package com.example.pdm_final_project.Controller;

import com.example.pdm_final_project.Entity.TodoEntity;
import com.example.pdm_final_project.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

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

    @GetMapping("/label/{labelId}")
    public List<TodoEntity> getTasksByLabel(@PathVariable Long labelId) {
        return todoService.getTasksByLabel(labelId);
    }

    @PostMapping
    public TodoEntity createTask(@RequestBody TodoEntity task) {
        return todoService.createTodo(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoEntity> updateTask(@PathVariable Long id, @RequestBody TodoEntity taskDetails) {
        TodoEntity updatedTask = todoService.updateTodo(id, taskDetails);
        return updatedTask != null
                ? ResponseEntity.ok(updatedTask)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
