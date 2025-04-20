package com.codegym.furama.repository;

import com.codegym.furama.model.Division;
import com.codegym.furama.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    //cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM division";

    @Override
    public List<Division> showAll() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                Division division = new Division(divisionId, divisionName);
                divisionList.add(division);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divisionList;
    }
}
