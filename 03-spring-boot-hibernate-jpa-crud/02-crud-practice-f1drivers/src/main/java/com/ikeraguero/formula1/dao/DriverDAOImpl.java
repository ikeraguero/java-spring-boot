package com.ikeraguero.formula1.dao;

import com.ikeraguero.formula1.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DriverDAOImpl implements DriverDAO {

    private EntityManager entityManager;

    @Autowired
    public DriverDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Driver theDriver) {
        entityManager.persist(theDriver);
    }

    @Override
    public Driver findById(Integer id) {
        return entityManager.find(Driver.class, id);
    }

    @Override
    public List<Driver> findAll() {
        TypedQuery<Driver> theQuery = entityManager.createQuery("FROM Driver", Driver.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Driver> findByLastName(String lastName) {
        TypedQuery<Driver> theQuery = entityManager.createQuery("FROM Driver WHERE lastName=:theData", Driver.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Driver theDriver) {
        entityManager.merge(theDriver);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Driver theDriver = entityManager.find(Driver.class, id);
        entityManager.remove(theDriver);
    }

    @Override
    @Transactional
    public int deleteAll() {
       int numRowsDeleted = entityManager.createQuery("DELETE FROM Driver").executeUpdate();
       return numRowsDeleted;
    }
}
