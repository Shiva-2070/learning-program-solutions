package com.ormlearn.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ormlearn.orm_learn.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
