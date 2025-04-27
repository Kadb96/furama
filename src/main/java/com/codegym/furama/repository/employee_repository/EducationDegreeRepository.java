package com.codegym.furama.repository.employee_repository;

import com.codegym.furama.model.EducationDegree;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM education_degree";

    @Override
    public List<EducationDegree> showAll() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);
                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegreeList;
    }
}
