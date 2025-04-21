package com.codegym.furama.service;

import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> showAll();
    List<EmployeeDto> showByPage(int Page);
    List<EmployeeDto> searchAll(String keyword);
    List<EmployeeDto> searchByPage(int page, String keyword);
    boolean add(Employee employee);
    boolean delete(int employeeId);
    boolean update(int employeeId, Employee employee);
}
