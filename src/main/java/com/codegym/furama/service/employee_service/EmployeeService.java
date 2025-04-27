package com.codegym.furama.service.employee_service;

import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Employee;
import com.codegym.furama.repository.employee_repository.EmployeeRepository;
import com.codegym.furama.repository.employee_repository.IEmployeeRepository;

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
    public List<EmployeeDto> searchAll(String keyword) {
        return employeeRepository.searchAll(keyword);
    }

    @Override
    public List<EmployeeDto> searchByPage(int page, String keyword) {
        return employeeRepository.searchByPage(page, keyword);
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
        return employeeRepository.delete(employeeId);
    }

    @Override
    public boolean update(int employeeId, Employee employee) {
        if (employee.getUsername() == "") {
            return employeeRepository.updateWithNullUserName(employeeId, employee);
        } else {
            return employeeRepository.update(employeeId, employee);
        }    }
}
