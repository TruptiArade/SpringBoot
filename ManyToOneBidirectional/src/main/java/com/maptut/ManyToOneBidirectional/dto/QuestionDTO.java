package com.maptut.ManyToOneBidirectional.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private int qid;
    private String question;
    private List<StudentDTO> students;
}
