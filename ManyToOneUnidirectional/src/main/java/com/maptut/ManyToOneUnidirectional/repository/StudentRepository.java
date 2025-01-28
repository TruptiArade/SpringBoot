package com.maptut.ManyToOneUnidirectional.repository;

import com.maptut.ManyToOneUnidirectional.entity.Student;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
}
