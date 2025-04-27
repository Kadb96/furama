package com.codegym.furama.service.service_service;

import com.codegym.furama.model.RentType;
import com.codegym.furama.repository.service_repository.IRentTypeRepository;
import com.codegym.furama.repository.service_repository.RentTypeRepository;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    //ket noi RentTypeRepository
    private IRentTypeRepository rentTypeRepository = new RentTypeRepository();

    @Override
    public List<RentType> showAll() {
        return rentTypeRepository.showAll();
    }
}
