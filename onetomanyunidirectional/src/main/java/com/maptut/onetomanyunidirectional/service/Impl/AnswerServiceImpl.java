package com.maptut.onetomanyunidirectional.service.Impl;

import com.maptut.onetomanyunidirectional.dto.AnswerDTO;
import com.maptut.onetomanyunidirectional.entity.Answer;
import com.maptut.onetomanyunidirectional.repository.AnswerRepository;
import com.maptut.onetomanyunidirectional.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService
{
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDTO savecanswers(AnswerDTO answerDTO)
    {
        Answer a=modelMapper.map(answerDTO,Answer.class);
        Answer savedata = answerRepository.save(a);
        return modelMapper.map(savedata,AnswerDTO.class);
    }

    @Override
    public List<AnswerDTO> fetchanswers()
    {
        List<Answer> allanswer = answerRepository.findAll();
        return allanswer.stream()
                .map(entity -> modelMapper.map(entity, AnswerDTO.class))
                .collect(Collectors.toList());
    }
}

