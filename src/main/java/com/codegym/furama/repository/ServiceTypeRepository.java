package com.codegym.furama.repository;

import com.codegym.furama.model.ServiceType;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM service_type";

    @Override
    public List<ServiceType> showAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                ServiceType serviceType = new ServiceType(serviceTypeId, serviceTypeName);
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceTypeList;
    }
}
