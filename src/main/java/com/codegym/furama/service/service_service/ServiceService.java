package com.codegym.furama.service.service_service;

import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.model.Service;
import com.codegym.furama.repository.service_repository.IServiceRepository;
import com.codegym.furama.repository.service_repository.SerivceRepository;

import java.util.List;

public class ServiceService implements IServiceService {
    //ket noi ServiceRepository
    private IServiceRepository serviceRepository = new SerivceRepository();

    @Override
    public List<ServiceDto> showAll() {
        return serviceRepository.showAll();
    }

    @Override
    public List<ServiceDto> showByPage(int page) {
        return serviceRepository.showByPage(page);
    }

    @Override
    public List<ServiceDto> searchAll(String keyword) {
        return serviceRepository.searchAll(keyword);
    }

    @Override
    public List<ServiceDto> searchByPage(int page, String keyword) {
        return serviceRepository.searchByPage(page, keyword);
    }

    @Override
    public boolean add(Service service) {
        return serviceRepository.add(service);
    }

    @Override
    public boolean delete(String serviceId) {
        return serviceRepository.delete(serviceId);
    }

    @Override
    public boolean update(String serviceId, Service service) {
        return serviceRepository.update(serviceId, service);
    }
}
