package org.example.Lab2_Spring.repos;

import org.example.Lab2_Spring.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo
    extends CrudRepository<Department, Long>{
    }
