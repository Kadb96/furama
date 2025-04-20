package com.codegym.furama.service;

import com.codegym.furama.model.EducationDegree;
import com.codegym.furama.repository.EducationDegreeRepository;
import com.codegym.furama.repository.IEducationDegreeRepository;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    //ket noi EducationDegreeRepository
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> showAll() {
        return educationDegreeRepository.showAll();
    }
}
