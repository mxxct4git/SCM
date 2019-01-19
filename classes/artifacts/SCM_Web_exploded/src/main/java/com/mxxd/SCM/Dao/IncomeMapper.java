package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.IncomeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IncomeMapper {

    public ArrayList<IncomeEntity> queryIncome(IncomeEntity incomeEntity);

    public boolean insert(IncomeEntity incomeEntity);

    public boolean update(IncomeEntity incomeEntity);

    public boolean delete(int id);

    public boolean deleteByTime(String outList_timestamp);

    public String month_income(String out_date);
}
