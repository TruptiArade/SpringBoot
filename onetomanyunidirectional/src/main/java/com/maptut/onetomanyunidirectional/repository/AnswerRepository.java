package com.maptut.onetomanyunidirectional.repository;

import com.maptut.onetomanyunidirectional.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer>
{
}
