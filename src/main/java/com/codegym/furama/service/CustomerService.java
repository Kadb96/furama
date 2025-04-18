package com.codegym.furama.service;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.Customer;
import com.codegym.furama.repository.CustomerRepository;
import com.codegym.furama.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    //ket noi CustomerRepository
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<CustomerDto> showAll() {
        return customerRepository.showAll();
    }

    @Override
    public List<CustomerDto> showByPage(int Page) {
        return customerRepository.showByPage(Page);
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean delete(int customerId) {
        return customerRepository.delete(customerId);
    }

    @Override
    public boolean update(int customerId, Customer customer) {
        return customerRepository.update(customerId, customer);
    }
}
