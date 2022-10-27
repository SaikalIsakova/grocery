package com.company.db;

import com.company.models.Employee;
import com.company.models.Shop;

import java.util.List;

public interface DbHelper {
    void createSeller(Employee emp);
    List<Employee>empList();
    void updateSeller(int id);
    void deleteSeller(int id);

    void createShop(Shop shop);
    List<Shop>shopList();
    void updateShop(int id);
    void deleteShop(int id);

}
