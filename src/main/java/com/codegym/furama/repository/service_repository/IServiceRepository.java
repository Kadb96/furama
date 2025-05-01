package com.codegym.furama.repository.service_repository;

import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.model.Service;

import java.util.List;

public interface IServiceRepository {
    List<ServiceDto> showAll();
    List<ServiceDto> showByPage(int page);
    List<ServiceDto> searchAll(String keyword);
    List<ServiceDto> searchByPage(int page, String keyword);
    boolean add(Service service);
    boolean delete(String serviceId);
    boolean update(String serviceId, Service service);
}
