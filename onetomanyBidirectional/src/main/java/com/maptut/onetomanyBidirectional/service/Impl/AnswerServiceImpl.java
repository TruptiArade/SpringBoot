package com.maptut.onetomanyBidirectional.service.Impl;

import com.maptut.onetomanyBidirectional.dto.AnswerDTO;
import com.maptut.onetomanyBidirectional.entity.Answer;
import com.maptut.onetomanyBidirectional.entity.Question;
import com.maptut.onetomanyBidirectional.repository.AnswerRepository;
import com.maptut.onetomanyBidirectional.repository.QuestionRepository;
import com.maptut.onetomanyBidirectional.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDTO savecanswers(AnswerDTO answerDTO) {
        // Fetch the Question entity based on the provided qid in the DTO
        Question question = questionRepository.findById(answerDTO.getQuestion().getQid())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Convert AnswerDTO to Answer entity
        Answer answer = modelMapper.map(answerDTO, Answer.class);

        // Set the question in the Answer entity
        answer.setQuestion(question);

        // Save the Answer entity
        Answer savedAnswer = answerRepository.save(answer);

        // Return the saved Answer as AnswerDTO
        return modelMapper.map(savedAnswer, AnswerDTO.class);
    }


    @Override
    public List<AnswerDTO> fetchanswers() {
        // Fetch all answers from the repository
        List<Answer> allAnswers = answerRepository.findAll();

        // Convert the Answer entities to AnswerDTOs and return the list
        return allAnswers.stream()
                .map(entity -> modelMapper.map(entity, AnswerDTO.class))
                .collect(Collectors.toList());
    }
}
