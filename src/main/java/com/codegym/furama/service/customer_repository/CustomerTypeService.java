package com.codegym.furama.service.customer_repository;

import com.codegym.furama.model.CustomerType;
import com.codegym.furama.repository.customer_repository.CustomerTypeRepository;
import com.codegym.furama.repository.customer_repository.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    //ket noi CustomerTypeRepository
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> showAll() {
        return customerTypeRepository.showAll();
    }
}
