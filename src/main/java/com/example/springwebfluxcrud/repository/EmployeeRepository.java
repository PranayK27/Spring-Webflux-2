package com.example.springwebfluxcrud.repository;

import com.example.springwebfluxcrud.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
