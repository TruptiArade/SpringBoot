package com.maptut.ManyToOneUnidirectional.service.Impl;

import com.maptut.ManyToOneUnidirectional.dto.QuestionDTO;
import com.maptut.ManyToOneUnidirectional.entity.Question;
import com.maptut.ManyToOneUnidirectional.repository.QuestionRepository;
import com.maptut.ManyToOneUnidirectional.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionDTO savequestion(QuestionDTO questionDTO)
    {
        Question q  =modelMapper.map(questionDTO,Question.class);
        Question savedata = questionRepository.save(q);
        return modelMapper.map(savedata, QuestionDTO.class);
    }

    @Override
    public List<QuestionDTO> fetchquestions()
    {
        List<Question> questionlist = questionRepository.findAll();
        return questionlist.stream()
                .map(entity -> modelMapper.map(entity, QuestionDTO.class))
                .collect(Collectors.toList());

    }
}
