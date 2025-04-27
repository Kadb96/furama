package com.codegym.furama.repository.customer_repository;

import com.codegym.furama.model.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> showAll();
}
