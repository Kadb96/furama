package com.codegym.furama.repository.attach_service_repository;

import com.codegym.furama.model.AttachService;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository implements IAttachServiceRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM attach_service";

    @Override
    public List<AttachService> showAll() {
        List<AttachService> attachServiceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                double attachServicePrice = resultSet.getDouble("attach_service_price");
                String attachServiceUnit = resultSet.getString("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                AttachService attachService = new AttachService(attachServiceId, attachServiceName, attachServicePrice,
                        attachServiceUnit, attachServiceStatus);
                attachServiceList.add(attachService);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return attachServiceList;
    }
}
