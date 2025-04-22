package com.codegym.furama.repository;

import com.codegym.furama.model.RentType;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository{
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM rent_type";

    @Override
    public List<RentType> showAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                RentType rentType = new RentType(rentTypeId, rentTypeName);
                rentTypeList.add(rentType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rentTypeList;
    }
}
