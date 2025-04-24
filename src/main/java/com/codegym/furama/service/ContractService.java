package com.codegym.furama.service;

import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.Contract;
import com.codegym.furama.repository.ContractRepository;
import com.codegym.furama.repository.IContractRepository;

import java.util.List;

public class ContractService implements IContractService {
    //ket noi ContractRepository
    IContractRepository contractRepository = new ContractRepository();

    @Override
    public List<ContractDto> showAll() {
        return contractRepository.showAll();
    }

    @Override
    public List<ContractDto> showByPage(int page) {
        return contractRepository.showByPage(page);
    }

    @Override
    public List<ContractDto> searchAll(String keyword) {
        return contractRepository.searchAll(keyword);
    }

    @Override
    public List<ContractDto> searchByPage(int page, String keyword) {
        return contractRepository.searchByPage(page, keyword);
    }

    @Override
    public boolean add(Contract contract) {
        return contractRepository.add(contract);
    }

    @Override
    public boolean delete(int contractId) {
        return contractRepository.delete(contractId);
    }

    @Override
    public boolean update(int contractId, Contract contract) {
        return contractRepository.update(contractId, contract);
    }
}
