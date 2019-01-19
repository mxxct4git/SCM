package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.FactoryEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FactoryMapper {

    public ArrayList<FactoryEntity> queryFactory(FactoryEntity factoryEntity);

    public boolean insert(FactoryEntity factoryEntity);

    public boolean update(FactoryEntity factoryEntity);

    public boolean delete(int id);

    public ArrayList<FactoryEntity> ajax_queryFactory();

    public ArrayList<FactoryEntity> ajax_queryMainFactory();

    public ArrayList<FactoryEntity> ajax_queryOtherFactory();

}
