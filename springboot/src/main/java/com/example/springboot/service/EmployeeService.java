package com.example.springboot.service;

import com.example.springboot.entity.Employees;
import com.example.springboot.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service layer is where all the business logic lies
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public List<Employees> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employees getEmployeeById(Integer id) {
        Optional<Employees> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }

        log.info("Employees with id: {} doesn't exist", id);
        return null;
    }

    public Employees saveEmployee(Employees Employees) {
        Employees.setCreatedAt((LocalDateTime.now()));
        Employees.setUpdatedAt((LocalDateTime.now()));
        Employees savedEmployee = employeeRepo.save(Employees);

        log.info("Employees with id: {} saved successfully", Employees.getId());
        return savedEmployee;
    }

    public Employees updateEmployee(Employees Employees) {
        Optional<Employees> existingEmployee = employeeRepo.findById(Employees.getId());
        Employees.setCreatedAt(existingEmployee.get().getCreatedAt());
        Employees.setUpdatedAt(LocalDateTime.now());

        Employees updatedEmployee = employeeRepo.save(Employees);

        log.info("Employees with id: {} updated successfully", Employees.getId());
        return updatedEmployee;
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepo.deleteById(id);
    }
}
