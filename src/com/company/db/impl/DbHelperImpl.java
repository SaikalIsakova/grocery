package com.company.db.impl;

import com.company.db.DbHelper;
import com.company.models.Employee;
import com.company.models.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DbHelperImpl implements DbHelper {
    @Override
    public void createSeller(Employee emp) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        try {
             ps=connection.prepareStatement("insert into tb_employees (name) values (?)");
             ps.setString(1,emp.getName());
             ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> empList() {
        try {
        Connection connection=getConnection();
        PreparedStatement ps=connection.prepareStatement("select * from tb_employees");
             ResultSet rs= ps.executeQuery();
        List<Employee>list=new ArrayList<>();
             while (rs.next()){
                 Employee emp=new Employee();
                 emp.setId(rs.getInt("id"));
                 emp.setName(rs.getString("name"));
                 emp.setAge(rs.getInt("age"));
//                 emp.setShopId((Shop) rs.getObject("shop_id"));
                 emp.setNumber(rs.getInt("number"));
                 list.add(emp);
             }
             return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSeller(int id) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите имя...");
        String name=sc.next();
    Connection connection=getConnection();
        PreparedStatement ps= null;
        try {
            ps = connection.prepareStatement("Update tb_employees set name=? where id=?");
        ps.setString(1,name);
        ps.setInt(2,id);
        ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSeller(int id) {
    Connection connection=getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("delete from tb_employees where id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void createShop(Shop shop) {
        Connection connection=getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("insert into tb_shop (name) values (?)");
            ps.setString(1,shop.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Shop> shopList() {
        try {
        Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from tb_shop");
            ResultSet rs=ps.executeQuery();
            List<Shop>list=new ArrayList<>();
            while(rs.next()){
                Shop shop=new Shop();
                shop.setId(rs.getInt("id"));
                shop.setName(rs.getString("name"));
                list.add(shop);

            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateShop(int id) {
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
    Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("Update tb_shop set name= ? where id=?");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteShop(int id) {
    Connection connection=getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("delete from tb_shop where id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:sqlite:C:\\DataBase\\shopDBS.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
