package com.codegym.furama.service.contract_service;

import com.codegym.furama.dto.ContractDetailDto;
import com.codegym.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetailDto> showAll();
    List<ContractDetailDto> showByPage(int page);
    List<ContractDetailDto> searchAll(String keyword);
    List<ContractDetailDto> searchByPage(int page, String keyword);
    boolean add(ContractDetail contractDetail);
    boolean delete(int contractDetailId);
    boolean update(int contractDetailId, ContractDetail contractDetail);
}
