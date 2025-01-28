package com.maptut.onetomanyBidirectional.repository;

import com.maptut.onetomanyBidirectional.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer>
{
}
