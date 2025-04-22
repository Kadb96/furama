package com.codegym.furama.repository;

import com.codegym.furama.model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> showAll();
}
