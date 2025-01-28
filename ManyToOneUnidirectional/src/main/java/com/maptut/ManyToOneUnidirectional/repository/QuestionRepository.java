package com.maptut.ManyToOneUnidirectional.repository;

import com.maptut.ManyToOneUnidirectional.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
