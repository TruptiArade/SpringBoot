package com.maptut.onetomanyunidirectional.service;

import com.maptut.onetomanyunidirectional.dto.AnswerDTO;

import java.util.List;

public interface AnswerService
{
    AnswerDTO savecanswers(AnswerDTO answerDTO);
    List<AnswerDTO> fetchanswers();
}
