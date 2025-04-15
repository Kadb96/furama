package com.codegym.furama.service;

import com.codegym.furama.model.CustomerType;
import com.codegym.furama.repository.CustomerTypeRepository;
import com.codegym.furama.repository.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    //ket noi CustomerTypeRepository
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> showAll() {
        return customerTypeRepository.showAll();
    }
}
