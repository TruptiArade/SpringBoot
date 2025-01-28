package com.maptut.ManyToOneUnidirectional.controller;

import com.maptut.ManyToOneUnidirectional.dto.QuestionDTO;
import com.maptut.ManyToOneUnidirectional.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Questioninfo")
public class QuestionController
{
    @Autowired
    private QuestionService questionService;

    // Add a question and associate answers by their IDs
    @PostMapping("/add")
    public QuestionDTO saveQuestion(@RequestBody QuestionDTO questionDTO)
    {
        return questionService.savequestion(questionDTO);
    }

    // Fetch all questions
    @GetMapping("/questionlist")
    public List<QuestionDTO> fetchQuestions()
    {
        return questionService.fetchquestions();
    }
}
