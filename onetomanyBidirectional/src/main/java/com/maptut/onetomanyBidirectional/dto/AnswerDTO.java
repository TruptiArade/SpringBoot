package com.maptut.onetomanyBidirectional.dto;

import com.maptut.onetomanyBidirectional.entity.Question;
import lombok.Data;
import org.aspectj.weaver.patterns.TypePatternQuestions;

@Data
public class AnswerDTO
{
    private int aid;
    private String answers;
    private Question question;
}
