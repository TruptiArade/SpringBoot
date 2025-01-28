package com.maptut.ManyToOneBidirectional.service;

import com.maptut.ManyToOneBidirectional.dto.QuestionDTO;

import java.util.List;

public interface QuestionService
{
    QuestionDTO savequestion(QuestionDTO questionDTO);
    List<QuestionDTO> fetchquestions();
}
