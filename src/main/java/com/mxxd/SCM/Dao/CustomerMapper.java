package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerMapper {

    public ArrayList<CustomerEntity> queryCustomer(CustomerEntity customerEntity);

    public boolean insert(CustomerEntity customerEntity);

    public boolean update(CustomerEntity customerEntity);

    public boolean delete(int id);

    public ArrayList<CustomerEntity> ajax_queryCustomer();

}
