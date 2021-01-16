package org.example.Lab2_Spring.repos;

import org.example.Lab2_Spring.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo  extends CrudRepository<Employee, Long> {
    List<Employee>findByLastName(String lastName);
}
