package com.maptut.ManyToOneBidirectional.repository;

import com.maptut.ManyToOneBidirectional.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>
{
}
