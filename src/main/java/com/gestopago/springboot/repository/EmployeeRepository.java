package com.gestopago.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestopago.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
