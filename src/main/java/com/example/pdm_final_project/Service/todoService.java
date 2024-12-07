package com.example.pdm_final_project.Service;

import com.example.pdm_final_project.Entity.Board;
import com.example.pdm_final_project.Entity.Label;
import com.example.pdm_final_project.Entity.TodoEntity;
import com.example.pdm_final_project.Entity.User;
import com.example.pdm_final_project.Repository.BoardRepository;
import com.example.pdm_final_project.Repository.LabelRepository;
import com.example.pdm_final_project.Repository.TodoRepository;
import com.example.pdm_final_project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoEntity> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public List<TodoEntity> getTasksByBoard(Long boardId) {
        return todoRepository.findByBoardId(boardId);
    }

    public List<TodoEntity> getTasksByUser(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    public TodoEntity createTodo(TodoEntity todo) {
        // Set default status if not provided
        if (todo.getStatus() == null) {
            todo.setStatus("PENDING");
        }

        // Set current timestamp for created_at
        todo.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        // Load and set the board if boardId is provided
        if (todo.getBoardId() != null) {
            Board board = boardRepository.findById(todo.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + todo.getBoardId()));
            todo.setBoard(board);
        }
        
        if (todo.getLabelId() != null) {
            Label label = labelRepository.findById(todo.getLabelId())
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + todo.getLabelId()));
            todo.setLabel(label);
        }
        
        if (todo.getUserId() != null) {
            User user = userRepository.findById(todo.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + todo.getUserId()));
            todo.setUser(user);
        }

        todoRepository.saveTodo(
            todo.getTitle(),
            todo.getDescription(),
            todo.getStatus(),
            todo.getDueDate(),
            todo.getCreatedAt(),
            todo.getBoardId(),
            todo.getUserId(),
            todo.getLabelId()
        );

        return todo;
    }

    public TodoEntity updateTodo(Long id, TodoEntity todoDetails) {
        TodoEntity existingTodo = todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        // Update basic fields only if they are provided
        if (todoDetails.getTitle() != null) {
            existingTodo.setTitle(todoDetails.getTitle());
        }
        if (todoDetails.getDescription() != null) {
            existingTodo.setDescription(todoDetails.getDescription());
        }
        if (todoDetails.getStatus() != null) {
            existingTodo.setStatus(todoDetails.getStatus());
        }
        if (todoDetails.getDueDate() != null) {
            existingTodo.setDueDate(todoDetails.getDueDate());
        }

        // Keep existing relationships if not provided in update
        if (todoDetails.getBoardId() != null) {
            Board board = boardRepository.findById(todoDetails.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + todoDetails.getBoardId()));
            existingTodo.setBoard(board);
        }
        
        if (todoDetails.getLabelId() != null) {
            Label label = labelRepository.findById(todoDetails.getLabelId())
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + todoDetails.getLabelId()));
            existingTodo.setLabel(label);
        }
        
        if (todoDetails.getUserId() != null) {
            User user = userRepository.findById(todoDetails.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + todoDetails.getUserId()));
            existingTodo.setUser(user);
        }

        todoRepository.updateTodo(
            id,
            existingTodo.getTitle(),
            existingTodo.getDescription(),
            existingTodo.getStatus(),
            existingTodo.getDueDate(),
            existingTodo.getBoardId(),
            existingTodo.getLabelId()
        );

        return existingTodo;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteTodoById(id);
    }

    public List<TodoEntity> getTodayTasks() {
        return todoRepository.findTodayTasks();
    }

    public List<TodoEntity> getThisWeekTasks() {
        return todoRepository.findThisWeekTasks();
    }

    public List<TodoEntity> getThisMonthTasks() {
        return todoRepository.findThisMonthTasks();
    }
}