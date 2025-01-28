package com.mapping.OnetoOneUnidirectional.repository;

import com.mapping.OnetoOneUnidirectional.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
}
