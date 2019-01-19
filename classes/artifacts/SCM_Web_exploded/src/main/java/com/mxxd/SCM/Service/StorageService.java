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

import com.mxxd.SCM.Dao.StorageMapper;
import com.mxxd.SCM.Entity.StorageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈库存Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Service
public class StorageService {

    @Autowired
    private StorageMapper storageMapper;

    public ArrayList<StorageEntity> queryStorage(StorageEntity storageEntity){
        ArrayList<StorageEntity> storages = storageMapper.queryStorage(storageEntity);
        return storages;
    }

    public boolean insert(StorageEntity storageEntity){
        boolean result = storageMapper.insert(storageEntity);
        return result;
    }

    public boolean update(StorageEntity storageEntity){
        boolean result = storageMapper.update(storageEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = storageMapper.delete(id);
        return result;
    }

}