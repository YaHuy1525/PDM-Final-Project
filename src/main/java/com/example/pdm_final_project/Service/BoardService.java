package com.example.pdm_final_project.Service;

import com.example.pdm_final_project.Entity.Board;
import com.example.pdm_final_project.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public List<Board> getBoardByName(String name) {
        return boardRepository.findByNameContaining(name);
    }

    public List<Board> getBoardsByCreatedAt() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()) {
            try {
                boardRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Failed to delete board: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Board not found with id: " + id);
        }
    }
}
