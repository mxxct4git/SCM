/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CostService
 * Author:   猫熊小才天
 * Date:     2018/10/23 10:21
 * Description: 成本Service类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Service;

import com.mxxd.SCM.Dao.IncomeMapper;
import com.mxxd.SCM.Entity.IncomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收入Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */
@Service
public class IncomeService {

    @Autowired
    private IncomeMapper incomeMapper;

    public ArrayList<IncomeEntity> queryIncome(IncomeEntity incomeEntity){
        ArrayList<IncomeEntity> incomes = incomeMapper.queryIncome(incomeEntity);
        return incomes;
    }

    public boolean insert(IncomeEntity incomeEntity){
        boolean result = incomeMapper.insert(incomeEntity);
        return result;
    }

    public boolean update(IncomeEntity incomeEntity){
        boolean result = incomeMapper.update(incomeEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = incomeMapper.delete(id);
        return result;
    }

    public boolean deleteByTime(String outList_timestamp){
        boolean result = incomeMapper.deleteByTime(outList_timestamp);
        return result;
    }

    public String month_income(String out_date){
        String count = incomeMapper.month_income(out_date);
        return count;
    }

}