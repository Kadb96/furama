package com.codegym.furama.repository.contract_repository;

import com.codegym.furama.dto.ContractDto;
import com.codegym.furama.model.Contract;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
//    cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT contract.*, e.employee_name, c.customer_name, s.service_name, " +
        "s.service_cost + ifnull(sum(att.attach_service_price * cd.quantity),0) contract_total_money " +
        "FROM contract " +
        "JOIN employee e ON contract.employee_id = e.employee_id " +
        "JOIN customer c ON contract.customer_id = c.customer_id " +
        "JOIN service s ON contract.service_id = s.service_id " +
        "LEFT JOIN contract_detail cd ON contract.contract_id = cd.contract_id " +
        "LEFT JOIN attach_service att ON cd.attach_service_id = att.attach_service_id " +
        "GROUP BY contract.contract_id " +
        "ORDER BY contract.contract_id;";
    private final String SHOW_BY_PAGE = "SELECT contract.*, e.employee_name, c.customer_name, s.service_name, " +
            "s.service_cost + ifnull(sum(att.attach_service_price * cd.quantity),0) contract_total_money " +
            "FROM contract " +
            "JOIN employee e ON contract.employee_id = e.employee_id " +
            "JOIN customer c ON contract.customer_id = c.customer_id " +
            "JOIN service s ON contract.service_id = s.service_id " +
            "LEFT JOIN contract_detail cd ON contract.contract_id = cd.contract_id " +
            "LEFT JOIN attach_service att ON cd.attach_service_id = att.attach_service_id " +
            "GROUP BY contract.contract_id " +
            "ORDER BY contract.contract_id " +
            "LIMIT ?, 5;";
    private final String ADD = "INSERT INTO contract (contract_start_date, contract_end_date, contract_deposit, " +
            "employee_id, customer_id, service_id) " +
            "values (?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE contract " +
            "SET contract_start_date = ?, contract_end_date = ?, contract_deposit = ?, employee_id = ?, " +
            "customer_id = ?, service_id = ? " +
            "WHERE contract_id = ?";


    @Override
    public List<ContractDto> showAll() {
        List<ContractDto> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String contractStartDateString = resultSet.getString("contract_start_date");
                String contractEndDateString = resultSet.getString("contract_end_date");
                LocalDate contractStartDate = LocalDate.parse(contractStartDateString, formatter);
                LocalDate contractEndDate = LocalDate.parse(contractEndDateString, formatter);
                double contractDeposit = resultSet.getDouble("contract_deposit");
                int employeeId = resultSet.getInt("employee_id");
                String customerId = resultSet.getString("customer_id");
                String serviceId = resultSet.getString("service_id");
                String employeeName = resultSet.getString("employee_name");
                String customerName = resultSet.getString("customer_name");
                String serviceName = resultSet.getString("service_name");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                ContractDto contract = new ContractDto(contractId, contractStartDate, contractEndDate, contractDeposit,
                        employeeId, customerId, serviceId, employeeName, customerName, serviceName, contractTotalMoney);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contractList;
    }

    @Override
    public List<ContractDto> showByPage(int page) {
        List<ContractDto> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BY_PAGE);
            preparedStatement.setInt(1, (page - 1) * 5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String contractStartDateString = resultSet.getString("contract_start_date");
                String contractEndDateString = resultSet.getString("contract_end_date");
                LocalDate contractStartDate = LocalDate.parse(contractStartDateString, formatter);
                LocalDate contractEndDate = LocalDate.parse(contractEndDateString, formatter);
                double contractDeposit = resultSet.getDouble("contract_deposit");
                int employeeId = resultSet.getInt("employee_id");
                String customerId = resultSet.getString("customer_id");
                String serviceId = resultSet.getString("service_id");
                String employeeName = resultSet.getString("employee_name");
                String customerName = resultSet.getString("customer_name");
                String serviceName = resultSet.getString("service_name");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                ContractDto contract = new ContractDto(contractId, contractStartDate, contractEndDate, contractDeposit,
                        employeeId, customerId, serviceId, employeeName, customerName, serviceName, contractTotalMoney);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contractList;
    }

    @Override
    public List<ContractDto> searchAll(String keyword) {
        List<ContractDto> contractList = new ArrayList<>();
        return contractList;
    }

    @Override
    public List<ContractDto> searchByPage(int page, String keyword) {
        List<ContractDto> contractList = new ArrayList<>();
        return contractList;
    }

    @Override
    public boolean add(Contract contract) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1, contract.getContractStartDateStringSql());
            preparedStatement.setString(2, contract.getContractEndDateStringSql());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setInt(4, contract.getEmployeeId());
            preparedStatement.setString(5, contract.getCustomerId());
            preparedStatement.setString(6, contract.getServiceId());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int contractId) {
        return false;
    }

    @Override
    public boolean update(int contractId, Contract contract) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, contract.getContractStartDateStringSql());
            preparedStatement.setString(2, contract.getContractEndDateStringSql());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setInt(4, contract.getEmployeeId());
            preparedStatement.setString(5, contract.getCustomerId());
            preparedStatement.setString(6, contract.getServiceId());
            preparedStatement.setInt(7, contractId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
