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

import com.mxxd.SCM.Dao.InListMapper;
import com.mxxd.SCM.Entity.InListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈入库Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Service
public class InListService {

    @Autowired
    private InListMapper inListMapper;

    public ArrayList<InListEntity> queryInList(InListEntity inListEntity){
        ArrayList<InListEntity> inLists = inListMapper.queryInList(inListEntity);
        return inLists;
    }

    public boolean insert(InListEntity inListEntity){
        boolean result = inListMapper.insert(inListEntity);
        return result;
    }

    public boolean update(InListEntity inListEntity){
        boolean result = inListMapper.update(inListEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = inListMapper.delete(id);
        return result;
    }

    public int today_inList(String in_date){
        int count = inListMapper.today_inList(in_date);
        return count;
    }

}