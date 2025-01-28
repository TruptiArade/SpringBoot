package com.maptut.onetomanyBidirectional.dto;

import com.maptut.onetomanyBidirectional.entity.Answer;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO
{
    private int qid;
    private String question;
    private List<Answer> answerlist;
}
