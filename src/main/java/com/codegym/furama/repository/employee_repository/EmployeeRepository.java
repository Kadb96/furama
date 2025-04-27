package com.codegym.furama.repository.employee_repository;

import com.codegym.furama.dto.EmployeeDto;
import com.codegym.furama.model.Employee;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT e.*, p.position_name, ed.education_degree_name, d.division_name FROM employee e JOIN position p ON e.position_id = p.position_id JOIN education_degree ed ON e.education_degree_id = ed.education_degree_id JOIN division d ON e.division_id = d.division_id ORDER BY e.employee_id;";
    private final String SHOW_BY_PAGE = "SELECT e.*, p.position_name, ed.education_degree_name, d.division_name FROM employee e JOIN position p ON e.position_id = p.position_id JOIN education_degree ed ON e.education_degree_id = ed.education_degree_id JOIN division d ON e.division_id = d.division_id ORDER BY e.employee_id LIMIT ?, 5;";
    private final String SEARCH_ALL = "SELECT e.*, p.position_name, ed.education_degree_name, d.division_name FROM employee e JOIN position p ON e.position_id = p.position_id JOIN education_degree ed ON e.education_degree_id = ed.education_degree_id JOIN division d ON e.division_id = d.division_id WHERE e.employee_name LIKE ? ORDER BY e.employee_id";
    private final String SEARCH_BY_PAGE = "SELECT e.*, p.position_name, ed.education_degree_name, d.division_name FROM employee e JOIN position p ON e.position_id = p.position_id JOIN education_degree ed ON e.education_degree_id = ed.education_degree_id JOIN division d ON e.division_id = d.division_id WHERE e.employee_name LIKE ? ORDER BY e.employee_id LIMIT ?, 5;";
    private final String INSERT_INTO = "INSERT INTO employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String INSERT_INTO_WITH_NULL_USERNAME = "INSERT INTO employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE = "DELETE FROM employee WHERE employee_id = ?";
    private final String UPDATE = "UPDATE employee SET employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? WHERE employee_id = ?";
    private final String UPDATE_WITH_NULL_USERNAME = "UPDATE employee SET employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, username = NULL WHERE employee_id = ?";

    @Override
    public List<EmployeeDto> showAll() {
        List<EmployeeDto> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthdayString = resultSet.getString("employee_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate employeeBirthday = LocalDate.parse(employeeBirthdayString, formatter);
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                EmployeeDto employee = new EmployeeDto(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId,
                        divisionId, username, positionName, educationDegreeName, divisionName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDto> showByPage(int page) {
        List<EmployeeDto> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BY_PAGE);
            preparedStatement.setInt(1, (page - 1) * 5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthdayString = resultSet.getString("employee_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate employeeBirthday = LocalDate.parse(employeeBirthdayString, formatter);
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                EmployeeDto employee = new EmployeeDto(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId,
                        divisionId, username, positionName, educationDegreeName, divisionName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDto> searchAll(String keyword) {
        List<EmployeeDto> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthdayString = resultSet.getString("employee_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate employeeBirthday = LocalDate.parse(employeeBirthdayString, formatter);
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                EmployeeDto employee = new EmployeeDto(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId,
                        divisionId, username, positionName, educationDegreeName, divisionName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDto> searchByPage(int page, String keyword) {
        List<EmployeeDto> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_PAGE);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setInt(2, (page - 1) * 5);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthdayString = resultSet.getString("employee_birthday");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate employeeBirthday = LocalDate.parse(employeeBirthdayString, formatter);
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                String positionName = resultSet.getString("position_name");
                String educationDegreeName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                EmployeeDto employee = new EmployeeDto(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId,
                        divisionId, username, positionName, educationDegreeName, divisionName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public boolean add(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthdayStringSql());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean addWithNullUserName(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_WITH_NULL_USERNAME);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthdayStringSql());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int employeeId) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, employeeId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(int employeeId, Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthdayStringSql());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employeeId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean updateWithNullUserName(int employeeId, Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WITH_NULL_USERNAME);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthdayStringSql());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, employeeId);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
