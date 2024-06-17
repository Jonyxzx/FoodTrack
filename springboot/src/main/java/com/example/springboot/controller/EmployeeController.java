package com.example.springboot.controller;

import com.example.springboot.entity.Employees;
import com.example.springboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class is where all the user requests are handled and required responses are sent
 */
@RestController
@RequestMapping("/employees/v1")
@RequiredArgsConstructor
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employees/v1/
     * Purpose: Fetches all the employees in the Employees table
     * @return List of Employees
     */
    @GetMapping("/")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employees/v1/1 (or any other id)
     * Purpose: Fetches Employees with the given id
     * @param id - Employees id
     * @return Employees with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/employees/v1/
     * Purpose: Save an Employees entity
     * @param Employees - Request body is an Employees entity
     * @return Saved Employees entity
     */
    @PostMapping("/")
    public ResponseEntity<Employees> saveEmployee(@RequestBody Employees Employees) {
        return ResponseEntity.ok().body(employeeService.saveEmployee(Employees));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employees/v1/
     * Purpose: Update an Employees entity
     * @param Employees - Employees entity to be updated
     * @return Updated Employees
     */
    @PutMapping("/")
    public ResponseEntity<Employees> updateEmployee(@RequestBody Employees Employees) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(Employees));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employees/v1/1 (or any other id)
     * Purpose: Delete an Employees entity
     * @param id - Employees's id to be deleted
     * @return a String message indicating Employees record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body("Deleted Employees successfully");
    }
}
