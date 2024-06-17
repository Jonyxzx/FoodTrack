package com.example.springboot.repository;

import com.example.springboot.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository is an interface that provides access to a data in a database
 */
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
}
