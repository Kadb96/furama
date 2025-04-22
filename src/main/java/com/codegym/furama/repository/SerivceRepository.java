package com.codegym.furama.repository;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.dto.ServiceDto;
import com.codegym.furama.model.Service;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SerivceRepository implements IServiceRepository {
    //cac cau query duoc su dung
    private final String SEARCH_ALL = "SELECT s.*, rt.rent_type_name, st.service_type_name FROM service s JOIN rent_type rt ON s.rent_type_id = rt.rent_type_id JOIN service_type st ON s.service_type_id = st.service_type_id WHERE s.service_name LIKE ? ORDER BY s.service_id;";
    private final String SEARCH_BY_PAGE = "SELECT s.*, rt.rent_type_name, st.service_type_name FROM service s JOIN rent_type rt ON s.rent_type_id = rt.rent_type_id JOIN service_type st ON s.service_type_id = st.service_type_id WHERE s.service_name LIKE ? ORDER BY s.service_id LIMIT ?, 5;";
    private final String ADD = "INSERT INTO service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<ServiceDto> showAll() {
        List<ServiceDto> serviceList = new ArrayList<>();
        return serviceList;
    }

    @Override
    public List<ServiceDto> showByPage(int page) {
        List<ServiceDto> serviceList = new ArrayList<>();
        return serviceList;
    }

    @Override
    public List<ServiceDto> searchAll(String keyword) {
        List<ServiceDto> serviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String rentTypeName = resultSet.getString("rent_type_name");
                String serviceTypeName = resultSet.getString("service_type_name");

                ServiceDto service = new ServiceDto(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople,
                        rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors,
                        rentTypeName, serviceTypeName);
                serviceList.add(service);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceList;
    }

    @Override
    public List<ServiceDto> searchByPage(int page, String keyword) {
        List<ServiceDto> serviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_PAGE);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setInt(2, (page - 1) * 5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String rentTypeName = resultSet.getString("rent_type_name");
                String serviceTypeName = resultSet.getString("service_type_name");

                ServiceDto service = new ServiceDto(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople,
                        rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors,
                        rentTypeName, serviceTypeName);
                serviceList.add(service);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceList;
    }

    @Override
    public boolean add(Service service) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setInt(5, service.getRentTypeId());
            preparedStatement.setInt(6, service.getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int serviceId) {
        return false;
    }

    @Override
    public boolean update(int serviceId, Service service) {
        return false;
    }
}
