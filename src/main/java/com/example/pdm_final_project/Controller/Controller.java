package com.example.pdm_final_project.Controller;

import com.example.pdm_final_project.Service.TaskService;
import com.example.pdm_final_project.io.TaskDTO;
import com.example.pdm_final_project.io.TaskResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class Controller {
    private TaskService taskService;
    private ModelMapper modelMapper;

    @GetMapping("/tasks")
    public List<TaskResponse> getALlTasks(){
        log.info("Api GET /expenses called");
        List<TaskDTO> list = taskService.getAllExpenses();
        log.info("Printing the data from service: {}", list);
        List<TaskResponse> responses = list.stream().map(taskDTO -> mapToExpenseResponse(taskDTO))
            .collect(Collectors.toList());
        return responses;
    }

    @GetMapping("/error")
    public Error error(){
        return new Error("Errror");
    }

    public TaskResponse mapToExpenseResponse(TaskDTO taskDTO){
        return modelMapper.map(taskDTO, TaskResponse.class);
    }
}
