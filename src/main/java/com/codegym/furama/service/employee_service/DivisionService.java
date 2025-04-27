package com.codegym.furama.service.employee_service;

import com.codegym.furama.model.Division;
import com.codegym.furama.repository.employee_repository.DivisionRepository;
import com.codegym.furama.repository.employee_repository.IDivisionRepository;

import java.util.List;

public class DivisionService implements IDivisionService {
    //ket noi DivisionRepository
    private IDivisionRepository divisionRepository = new DivisionRepository();

    @Override
    public List<Division> showAll() {
        return divisionRepository.showAll();
    }
}
