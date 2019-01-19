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

import com.mxxd.SCM.Dao.FactoryMapper;
import com.mxxd.SCM.Entity.FactoryEntity;
import com.mxxd.SCM.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工厂Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Service
public class FactoryService {

    @Autowired
    private FactoryMapper factoryMapper;

    public ArrayList<FactoryEntity> queryFactory(FactoryEntity factoryEntity){
        ArrayList<FactoryEntity> factorys = factoryMapper.queryFactory(factoryEntity);
        return factorys;
    }

    public boolean insert(FactoryEntity factoryEntity){
        boolean result = factoryMapper.insert(factoryEntity);
        return result;
    }

    public boolean update(FactoryEntity factoryEntity){
        boolean result = factoryMapper.update(factoryEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = factoryMapper.delete(id);
        return result;
    }

    public ArrayList<FactoryEntity> ajax_queryFactory(){
        ArrayList<FactoryEntity> factorys = factoryMapper.ajax_queryFactory();
        return factorys;
    }

    public ArrayList<FactoryEntity> ajax_queryMainFactory(){
        ArrayList<FactoryEntity> factorys = factoryMapper.ajax_queryMainFactory();
        return factorys;
    }

    public ArrayList<FactoryEntity> ajax_queryOtherFactory(){
        ArrayList<FactoryEntity> factorys = factoryMapper.ajax_queryOtherFactory();
        return factorys;
    }

}