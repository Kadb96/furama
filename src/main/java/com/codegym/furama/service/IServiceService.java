package com.codegym.furama.service;

import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.model.Service;

import java.util.List;

public interface IServiceService {
    List<ServiceDto> showAll();
    List<ServiceDto> showByPage(int page);
    List<ServiceDto> searchAll(String keyword);
    List<ServiceDto> searchByPage(int page, String keyword);
    boolean add(Service service);
    boolean delete(int serviceId);
    boolean update(int serviceId, Service service);
}
