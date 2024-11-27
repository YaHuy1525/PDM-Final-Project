package com.example.pdm_final_project.Service;

import com.example.pdm_final_project.Entity.TaskEntity;
import com.example.pdm_final_project.Repository.TaskRepository;
import com.example.pdm_final_project.io.TaskDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService{
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    public List<TaskDTO> getAllExpenses() {
        //Call the Repository method
        List<TaskEntity> list = taskRepository.findAll();
        log.info("Printing data from the repository: {}", list);
        //Convert ExpenseEntity to DTO object
        List<TaskDTO> listOfExpenses = list.stream().map(taskEntity -> mapToExpenseDTO(taskEntity))
                .collect(Collectors.toList());
        return listOfExpenses;
    }

    public TaskDTO mapToExpenseDTO(TaskEntity taskEntity){
        return modelMapper.map(taskEntity, TaskDTO.class);
    }
}
