package com.maptut.onetomanyunidirectional.dto;

import com.maptut.onetomanyunidirectional.entity.Answer;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO
{
    private int qid;
    private String question;
    private List<Answer> answerlist;
}
