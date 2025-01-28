package com.maptut.onetomanyBidirectional.service.Impl;

import com.maptut.onetomanyBidirectional.dto.QuestionDTO;
import com.maptut.onetomanyBidirectional.entity.Answer;
import com.maptut.onetomanyBidirectional.entity.Question;
import com.maptut.onetomanyBidirectional.repository.AnswerRepository;
import com.maptut.onetomanyBidirectional.repository.QuestionRepository;
import com.maptut.onetomanyBidirectional.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*@Override
    public QuestionDTO savequestion(QuestionDTO questionDTO)
    {
        Question q  =modelMapper.map(questionDTO,Question.class);
        Question savedata = questionRepository.save(q);
        return modelMapper.map(savedata, QuestionDTO.class);
    }*/

    @Override
    public QuestionDTO savequestion(QuestionDTO questionDTO) {
        // Map the QuestionDTO to the Question entity
        Question question = modelMapper.map(questionDTO, Question.class);

        // Check and fetch existing answers by ID if provided
        if (questionDTO.getAnswerlist() != null) {
            List<Answer> answerList = questionDTO.getAnswerlist().stream().map(answerDTO -> {
                if (answerDTO.getAid() != 0) {
                    // Fetch the existing Answer by ID
                    return answerRepository.findById(answerDTO.getAid())
                            .orElseThrow(() -> new RuntimeException("Answer not found with ID: " + answerDTO.getAid()));
                } else {
                    // Create a new Answer if no ID is provided
                    Answer newAnswer = modelMapper.map(answerDTO, Answer.class);
                    // Ensure the Question reference is set for the Answer
                    newAnswer.setQuestion(question);
                    return newAnswer;
                }
            }).collect(Collectors.toList());

            // Set the answer list to the Question
            question.setAnswerList(answerList);
        }

        // Save the Question along with its Answers
        Question savedQuestion = questionRepository.save(question);

        // Map the saved Question back to a QuestionDTO
        return modelMapper.map(savedQuestion, QuestionDTO.class);
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
