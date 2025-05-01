package com.codegym.furama.service.customer_repository;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> showAll();
    List<CustomerDto> showByPage(int page);
    List<CustomerDto> searchAll(String keyword);
    List<CustomerDto> searchByPage(int page, String keyword);
    boolean add(Customer customer);
    boolean delete(String customerId);
    boolean update(String customerId, Customer customer);
}
