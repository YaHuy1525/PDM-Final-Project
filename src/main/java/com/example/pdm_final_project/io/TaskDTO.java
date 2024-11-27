package com.example.pdm_final_project.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private long id;
    private String title;
    private String status;
    private String Description;
    private long labelId;
    private Timestamp dueDate;
    private Timestamp createdAt;
    private Timestamp updateAt;
}
