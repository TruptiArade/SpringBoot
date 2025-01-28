package com.maptut.ManyToOneUnidirectional.service;

import com.maptut.ManyToOneUnidirectional.dto.QuestionDTO;

import java.util.List;

public interface QuestionService
{
    QuestionDTO savequestion(QuestionDTO questionDTO);
    List<QuestionDTO> fetchquestions();
}
