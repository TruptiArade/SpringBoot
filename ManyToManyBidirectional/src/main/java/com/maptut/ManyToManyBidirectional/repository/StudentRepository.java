package com.maptut.ManyToManyBidirectional.repository;

import com.maptut.ManyToManyBidirectional.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
