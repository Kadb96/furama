package com.codegym.furama.repository;

import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.Contract;

import java.util.List;

public interface IContractRepository {
    List<ContractDto> showAll();
    List<ContractDto> showByPage(int page);
    List<ContractDto> searchAll(String keyword);
    List<ContractDto> searchByPage(int page, String keyword);
    boolean add(Contract contract);
    boolean delete(int contractId);
    boolean update(int contractId, Contract contract);
}
