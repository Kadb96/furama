package com.codegym.furama.service.contract_service;

import com.codegym.furama.dto.ContractDetailDto;
import com.codegym.furama.model.ContractDetail;
import com.codegym.furama.repository.contract_repository.ContractDetailRepository;
import com.codegym.furama.repository.contract_repository.IContractDetailRepository;

import java.util.List;

public class ContractDetailService implements IContractDetailService {
    //ket noi ContractDetailRepository
    private IContractDetailRepository contractDetailRepository = new ContractDetailRepository();

    @Override
    public List<ContractDetailDto> showAll() {
        return contractDetailRepository.showAll();
    }

    @Override
    public List<ContractDetailDto> showByPage(int page) {
        return contractDetailRepository.showByPage(page);
    }

    @Override
    public List<ContractDetailDto> searchAll(String keyword) {
        return contractDetailRepository.searchAll(keyword);
    }

    @Override
    public List<ContractDetailDto> searchByPage(int page, String keyword) {
        return contractDetailRepository.searchByPage(page, keyword);
    }

    @Override
    public boolean add(ContractDetail contractDetail) {
        return contractDetailRepository.add(contractDetail);
    }

    @Override
    public boolean delete(int contractDetailId) {
        return contractDetailRepository.delete(contractDetailId);
    }

    @Override
    public boolean update(int contractDetailId, ContractDetail contractDetail) {
        return contractDetailRepository.update(contractDetailId, contractDetail);
    }
}
