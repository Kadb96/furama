package com.codegym.furama.repository.contract_repository;

import com.codegym.furama.dto.ContractDetailDto;
import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.ContractDetail;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    //    cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT cd.*, aservice.attach_service_name FROM contract_detail cd JOIN " +
            "attach_service as aservice ON cd.attach_service_id = aservice.attach_service_id ";
    private final String ADD = "INSERT INTO contract_detail (contract_id, attach_service_id, quantity) " +
            "values (?, ?, ?)";

    @Override
    public List<ContractDetailDto> showAll() {
        List<ContractDetailDto> contractDetailList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                String attachServiceName = resultSet.getString("attach_service_name");
                ContractDetailDto contractDetail = new ContractDetailDto(contractDetailId, contractId, attachServiceId, quantity,
                        attachServiceName);
                contractDetailList.add(contractDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contractDetailList;
    }

    @Override
    public List<ContractDetailDto> showByPage(int page) {
        List<ContractDetailDto> contractDetailList = new ArrayList<>();
        return contractDetailList;
    }

    @Override
    public List<ContractDetailDto> searchAll(String keyword) {
        List<ContractDetailDto> contractDetailList = new ArrayList<>();
        return contractDetailList;
    }

    @Override
    public List<ContractDetailDto> searchByPage(int page, String keyword) {
        List<ContractDetailDto> contractDetailList = new ArrayList<>();
        return contractDetailList;
    }

    @Override
    public boolean add(ContractDetail contractDetail) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setInt(1, contractDetail.getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachServiceId());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int contractDetailId) {
        return false;
    }

    @Override
    public boolean update(int contractDetailId, ContractDetail contractDetail) {
        return false;
    }
}
