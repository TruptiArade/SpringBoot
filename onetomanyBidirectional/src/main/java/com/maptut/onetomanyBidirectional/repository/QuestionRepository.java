package com.maptut.onetomanyBidirectional.repository;

import com.maptut.onetomanyBidirectional.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
