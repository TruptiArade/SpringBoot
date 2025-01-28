package com.maptut.onetomanyBidirectional.service;

import com.maptut.onetomanyBidirectional.dto.AnswerDTO;

import java.util.List;

public interface AnswerService
{
    AnswerDTO savecanswers(AnswerDTO answerDTO);
    List<AnswerDTO> fetchanswers();
}
