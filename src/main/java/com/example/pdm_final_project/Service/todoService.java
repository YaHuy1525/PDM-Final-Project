package com.example.pdm_final_project.Service;

import com.example.pdm_final_project.Entity.TodoEntity;
import com.example.pdm_final_project.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoEntity> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public List<TodoEntity> getTasksByBoard(Long boardId) {
        return todoRepository.findByBoard_BoardId(boardId);
    }

    public List<TodoEntity> getTasksByUser(Long userId) {
        return todoRepository.findByUser_User_Id(userId);
    }

    public List<TodoEntity> getTasksByLabel(Long labelId) {
        return todoRepository.findByLabel_LabelId(labelId);
    }

    public List<TodoEntity> getTasksByStatus(String status) {
        return todoRepository.findByStatus(status);
    }

    public TodoEntity createTodo(TodoEntity todo) {
        return todoRepository.save(todo);
    }

    public TodoEntity updateTodo(Long id, TodoEntity todoDetails) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            TodoEntity existingTodo = todo.get();
            existingTodo.setTitle(todoDetails.getTitle());
            existingTodo.setDescription(todoDetails.getDescription());
            existingTodo.setStatus(todoDetails.getStatus());
            existingTodo.setDueDate(todoDetails.getDueDate());
            existingTodo.setCreatedAt(todoDetails.getCreatedAt());
            existingTodo.setBoard(todoDetails.getBoard());
            existingTodo.setUser(todoDetails.getUser());
            existingTodo.setLabel(todoDetails.getLabel());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}