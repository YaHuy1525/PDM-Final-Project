package com.example.pdm_final_project.Service;

import com.example.pdm_final_project.Entity.Label;
import com.example.pdm_final_project.Repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public Optional<Label> getLabelById(Long id) {
        return labelRepository.findById(id);
    }

    public Label createLabel(Label label) {
        return labelRepository.save(label);
    }

    public Label updateLabel(Long id, Label labelDetails) {
        Optional<Label> label = labelRepository.findById(id);
        if (label.isPresent()) {
            Label existingLabel = label.get();
            existingLabel.setName(labelDetails.getName());
            existingLabel.setColor(labelDetails.getColor());
            return labelRepository.save(existingLabel);
        }
        return null;
    }

    public void deleteLabel(Long id) {
        labelRepository.deleteById(id);
    }
}
