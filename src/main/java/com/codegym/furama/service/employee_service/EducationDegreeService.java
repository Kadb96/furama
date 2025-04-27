package com.codegym.furama.service.employee_service;

import com.codegym.furama.model.EducationDegree;
import com.codegym.furama.repository.employee_repository.EducationDegreeRepository;
import com.codegym.furama.repository.employee_repository.IEducationDegreeRepository;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    //ket noi EducationDegreeRepository
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> showAll() {
        return educationDegreeRepository.showAll();
    }
}
