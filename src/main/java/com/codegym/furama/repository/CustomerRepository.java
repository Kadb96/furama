package com.codegym.furama.repository;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.Customer;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT c.*, ct.customer_type_name FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.customer_type_id ORDER BY c.customer_id;";
    private final String SHOW_BY_PAGE = "SELECT c.*, ct.customer_type_name FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.customer_type_id ORDER BY c.customer_id LIMIT ?, 5;";
    private final String SEARCH_ALL = "SELECT c.*, ct.customer_type_name FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.customer_type_id WHERE c.customer_name LIKE ? ORDER BY c.customer_id;";
    private final String SEARCH_BY_PAGE = "SELECT c.*, ct.customer_type_name FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.customer_type_id WHERE c.customer_name LIKE ? ORDER BY c.customer_id LIMIT ?, 5;";
    private final String ADD = "INSERT INTO customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE = "DELETE FROM customer WHERE customer_id = ?";
    private final String UPDATE = "UPDATE customer SET customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? WHERE customer_id = ?";

    @Override
    public List<CustomerDto> showAll() {
        List<CustomerDto> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthdayString = resultSet.getString("customer_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate customerBirthday = LocalDate.parse(customerBirthdayString, formatter);
                boolean customerGender = resultSet.getBoolean("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerDto customer = new CustomerDto(customerId, customerTypeId, customerName, customerBirthday,
                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeName);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public List<CustomerDto> showByPage(int page) {
        List<CustomerDto> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BY_PAGE);
            preparedStatement.setInt(1, (page - 1) * 5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthdayString = resultSet.getString("customer_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate customerBirthday = LocalDate.parse(customerBirthdayString, formatter);
                boolean customerGender = resultSet.getBoolean("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerDto customer = new CustomerDto(customerId, customerTypeId, customerName, customerBirthday,
                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeName);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public List<CustomerDto> searchAll(String keyword) {
        List<CustomerDto> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthdayString = resultSet.getString("customer_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate customerBirthday = LocalDate.parse(customerBirthdayString, formatter);
                boolean customerGender = resultSet.getBoolean("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerDto customer = new CustomerDto(customerId, customerTypeId, customerName, customerBirthday,
                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeName);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public List<CustomerDto> searchByPage(int page, String keyword) {
        List<CustomerDto> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_PAGE);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setInt(2, (page - 1) * 5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthdayString = resultSet.getString("customer_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate customerBirthday = LocalDate.parse(customerBirthdayString, formatter);
                boolean customerGender = resultSet.getBoolean("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerDto customer = new CustomerDto(customerId, customerTypeId, customerName, customerBirthday,
                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeName);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;    }

    @Override
    public boolean add(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthdayStringSql());
            preparedStatement.setBoolean(4, customer.isCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int customerId) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, customerId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(int customerId, Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthdayStringSql());
            preparedStatement.setBoolean(4, customer.isCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customerId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return false;

    }
}
