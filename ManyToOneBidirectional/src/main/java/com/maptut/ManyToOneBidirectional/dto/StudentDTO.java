package com.maptut.ManyToOneBidirectional.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maptut.ManyToOneBidirectional.entity.Question;
import lombok.Data;

@Data
public class StudentDTO
{
    private int id;
    private String sname;
    private int prn;
    private Question question;
}
