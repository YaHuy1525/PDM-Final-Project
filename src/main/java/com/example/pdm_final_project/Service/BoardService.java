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

    public List<Board> getBoardsByName(String name) {
        return boardRepository.findByName(name);
    }

    public List<Board> getBoardsByCreatedAt() {
        return boardRepository.findByCreatedAt();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board updateBoard(Long id, Board boardDetails) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()) {
            Board existingBoard = board.get();
            existingBoard.setName(boardDetails.getName());
            existingBoard.setDescription(boardDetails.getDescription());
            return boardRepository.save(existingBoard);
        }
        return null;
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
