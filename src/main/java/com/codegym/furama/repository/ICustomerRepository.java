package com.codegym.furama.repository;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<CustomerDto> showAll();
    List<CustomerDto> showByPage(int Page);
    boolean add(Customer customer);
    boolean delete(int customerId);
    boolean update(int customerId, Customer customer);
}
