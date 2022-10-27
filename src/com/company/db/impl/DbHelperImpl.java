package com.company.db.impl;

import com.company.db.DbHelper;
import com.company.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHelperImpl implements DbHelper {
    @Override
    public void createSeller(Employee emp) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        try {
             ps=connection.prepareStatement("Insert into tb_employees (name) values (?)");
             ps.setString(1,emp.getName());
             ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> empList() {
        return null;
    }

    @Override
    public void updateSeller(int id) {

    }

    @Override
    public void deleteSeller(int id) {

    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:sqlite:C:\\DataBase\\shopDBS.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
