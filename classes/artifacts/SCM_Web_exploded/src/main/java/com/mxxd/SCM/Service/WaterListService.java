/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserService
 * Author:   猫熊小才天
 * Date:     2018/10/22 8:53
 * Description: 用户Service类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Service;

import com.mxxd.SCM.Dao.WaterListMapper;
import com.mxxd.SCM.Entity.WaterListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈流水Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Service
public class WaterListService {

    @Autowired
    private WaterListMapper waterListMapper;

    public ArrayList<WaterListEntity> queryWaterList(WaterListEntity waterListEntity){
        ArrayList<WaterListEntity> waterLists = waterListMapper.queryWaterList(waterListEntity);
        return waterLists;
    }

    public boolean insert(WaterListEntity waterListEntity){
        boolean result = waterListMapper.insert(waterListEntity);
        return result;
    }

    public boolean update(WaterListEntity waterListEntity){
        boolean result = waterListMapper.update(waterListEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = waterListMapper.delete(id);
        return result;
    }

    public boolean deleteByTime(String in_or_out_timestamp){
        boolean result = waterListMapper.deleteByTime(in_or_out_timestamp);
        return result;
    }

}