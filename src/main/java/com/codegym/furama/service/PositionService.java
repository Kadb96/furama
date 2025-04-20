package com.codegym.furama.service;

import com.codegym.furama.model.Position;
import com.codegym.furama.repository.IPositionRepository;
import com.codegym.furama.repository.PositionRepository;

import java.util.List;

public class PositionService implements IPositionService {
    //ket noi PositionRepository
    IPositionRepository positionRepository = new PositionRepository();

    @Override
    public List<Position> showAll() {
        return positionRepository.showAll();
    }
}
