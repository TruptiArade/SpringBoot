package com.maptut.ManyToOneBidirectional.repository;

import com.maptut.ManyToOneBidirectional.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
}
