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

import com.mxxd.SCM.Dao.CostMapper;
import com.mxxd.SCM.Entity.CostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈成本Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */
@Service
public class CostService {

    @Autowired
    private CostMapper costMapper;

    public ArrayList<CostEntity> queryCost(CostEntity costEntity){
        ArrayList<CostEntity> costs = costMapper.queryCost(costEntity);
        return costs;
    }

    public boolean insert(CostEntity costEntity){
        boolean result = costMapper.insert(costEntity);
        return result;
    }

    public boolean update(CostEntity costEntity){
        boolean result = costMapper.update(costEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = costMapper.delete(id);
        return result;
    }

    public boolean deleteByTime(String inList_timestamp){
        boolean result = costMapper.deleteByTime(inList_timestamp);
        return result;
    }

    public String month_cost(String in_date){
        String count = costMapper.month_cost(in_date);
        return count;
    }

}