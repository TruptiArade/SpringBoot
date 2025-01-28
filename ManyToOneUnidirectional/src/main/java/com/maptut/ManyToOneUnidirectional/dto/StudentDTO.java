package com.maptut.ManyToOneUnidirectional.dto;

import com.maptut.ManyToOneUnidirectional.entity.Question;
import lombok.Data;

@Data
public class StudentDTO
{
    private int id;
    private String sname;
    private int prn;
    private Question question;
}
