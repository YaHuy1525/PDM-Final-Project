package com.example.pdm_final_project.Repository;

import com.example.pdm_final_project.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByName(String name);
    List<Board> findByCreatedAt();
}