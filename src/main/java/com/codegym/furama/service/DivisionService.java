package com.codegym.furama.service;

import com.codegym.furama.model.Division;
import com.codegym.furama.repository.DivisionRepository;
import com.codegym.furama.repository.IDivisionRepository;

import java.util.List;

public class DivisionService implements IDivisionService {
    //ket noi DivisionRepository
    IDivisionRepository divisionRepository = new DivisionRepository();

    @Override
    public List<Division> showAll() {
        return divisionRepository.showAll();
    }
}
