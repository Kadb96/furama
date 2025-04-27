package com.codegym.furama.repository.employee_repository;

import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeDto> showAll();
    List<EmployeeDto> showByPage(int page);
    List<EmployeeDto> searchAll(String keyword);
    List<EmployeeDto> searchByPage(int page, String keyword);
    boolean add(Employee employee);
    boolean addWithNullUserName(Employee employee);
    boolean delete(int employeeId);
    boolean update(int employeeId, Employee employee);
    boolean updateWithNullUserName(int employeeId, Employee employee);
}
