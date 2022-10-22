package com.example.RPD.Repository;


import com.example.RPD.Models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
