package com.company.db;

import com.company.models.Employee;

import java.util.List;

public interface DbHelper {
    void createSeller(Employee emp);
    List<Employee>empList();
    void updateSeller(int id);
    void deleteSeller(int id);

}
