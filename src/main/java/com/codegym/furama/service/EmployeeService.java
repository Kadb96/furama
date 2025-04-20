package com.codegym.furama.service;

import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Employee;
import com.codegym.furama.repository.EmployeeRepository;
import com.codegym.furama.repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    //ket noi EmployeeRepository
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<EmployeeDto> showAll() {
        return employeeRepository.showAll();
    }

    @Override
    public List<EmployeeDto> showByPage(int Page) {
        return employeeRepository.showByPage(Page);
    }

    @Override
    public boolean add(Employee employee) {
        if (employee.getUsername() == "") {
            return employeeRepository.addWithNullUserName(employee);
        } else {
            return employeeRepository.add(employee);
        }
    }

    @Override
    public boolean delete(int employeeId) {
        return false;
    }

    @Override
    public boolean update(int employeeId, Employee employee) {
        return false;
    }
}
