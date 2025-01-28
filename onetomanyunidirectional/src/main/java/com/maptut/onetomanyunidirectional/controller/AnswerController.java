package com.maptut.onetomanyunidirectional.controller;

import com.maptut.onetomanyunidirectional.dto.AnswerDTO;
import com.maptut.onetomanyunidirectional.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AnswerInfo")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/add")
    AnswerDTO savecanswers(@RequestBody AnswerDTO answerDTO) {
        return answerService.savecanswers(answerDTO);
    }

    //Display all employee
    @GetMapping("/answerlist")
    public List<AnswerDTO> fetchanswers()
    {
        return answerService.fetchanswers();
    }
}

