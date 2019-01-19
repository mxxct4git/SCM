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

import com.mxxd.SCM.Dao.OutListMapper;
import com.mxxd.SCM.Entity.OutListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈出库Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Service
public class OutListService {

    @Autowired
    private OutListMapper outListMapper;

    public ArrayList<OutListEntity> queryOutList(OutListEntity outListEntity){
        ArrayList<OutListEntity> outLists = outListMapper.queryOutList(outListEntity);
        return outLists;
    }

    public boolean insert(OutListEntity outListEntity){
        boolean result = outListMapper.insert(outListEntity);
        return result;
    }

    public boolean update(OutListEntity outListEntity){
        boolean result = outListMapper.update(outListEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = outListMapper.delete(id);
        return result;
    }

    public int today_outList(String out_date){
        int count = outListMapper.today_outList(out_date);
        return count;
    }

}