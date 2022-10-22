package com.example.RPD.Repository;


import com.example.RPD.Models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
