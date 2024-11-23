package com.ikeraguero.formula1.dao;

import com.ikeraguero.formula1.entity.Driver;

import java.util.List;

public interface DriverDAO {

    void save(Driver theDriver);

    Driver findById(Integer id);

    List<Driver> findAll();

    List<Driver> findByLastName(String lastName);

    void update(Driver theDriver);

    void delete(Integer id);

    int deleteAll();

}
