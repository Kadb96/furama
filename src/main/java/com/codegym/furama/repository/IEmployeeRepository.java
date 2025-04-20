package com.codegym.furama.repository;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Customer;
import com.codegym.furama.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeDto> showAll();
    List<EmployeeDto> showByPage(int Page);
    boolean add(Employee employee);
    boolean addWithNullUserName(Employee employee);
    boolean delete(int employeeId);
    boolean update(int employeeId, Employee employee);
}
