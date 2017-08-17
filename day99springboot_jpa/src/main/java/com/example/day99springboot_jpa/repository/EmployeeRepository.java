package com.example.day99springboot_jpa.repository;

import com.example.day99springboot_jpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
