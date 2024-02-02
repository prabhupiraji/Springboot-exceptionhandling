package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.EmployeeModel;

public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {

}
