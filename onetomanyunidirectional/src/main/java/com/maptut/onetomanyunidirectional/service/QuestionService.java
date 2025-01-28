package com.maptut.onetomanyunidirectional.service;

import com.maptut.onetomanyunidirectional.dto.QuestionDTO;

import java.util.List;

public interface QuestionService
{
    QuestionDTO savequestion(QuestionDTO questionDTO);
    List<QuestionDTO> fetchquestions();
}
