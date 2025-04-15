package com.codegym.furama.repository;

import com.codegym.furama.model.CustomerType;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM customer_type";

    @Override
    public List<CustomerType> showAll() {
        List<CustomerType> customerTypes = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customerTypeId, customerTypeName);
                customerTypes.add(customerType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerTypes;
    }
}
