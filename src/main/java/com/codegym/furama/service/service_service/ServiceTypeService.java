package com.codegym.furama.service.service_service;

import com.codegym.furama.model.ServiceType;
import com.codegym.furama.repository.service_repository.IServiceTypeRepository;
import com.codegym.furama.repository.service_repository.ServiceTypeRepository;

import java.util.List;

public class ServiceTypeService implements IServiceTypeService {
    //ket noi ServiceTypeRepository
    private IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    @Override
    public List<ServiceType> showAll() {
        return serviceTypeRepository.showAll();
    }
}
