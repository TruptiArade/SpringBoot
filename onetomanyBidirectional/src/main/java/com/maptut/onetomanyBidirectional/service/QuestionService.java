package com.maptut.onetomanyBidirectional.service;

import com.maptut.onetomanyBidirectional.dto.QuestionDTO;

import java.util.List;

public interface QuestionService
{
    QuestionDTO savequestion(QuestionDTO questionDTO);
    List<QuestionDTO> fetchquestions();
}
