package com.example.pdm_final_project.Controller;

import com.example.pdm_final_project.Entity.Label;
import com.example.pdm_final_project.Service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labels")
@CrossOrigin(origins = "http://localhost:3000")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public List<Label> getAllLabels() {
        return labelService.getAllLabels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Label> getLabelById(@PathVariable Long id) {
        return labelService.getLabelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
