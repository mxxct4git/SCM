package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.CostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CostMapper {

    public ArrayList<CostEntity> queryCost(CostEntity costEntity);

    public boolean insert(CostEntity costEntity);

    public boolean update(CostEntity costEntity);

    public boolean delete(int id);

    public boolean deleteByTime(String inList_timestamp);

    public String month_cost(String in_date);
}
