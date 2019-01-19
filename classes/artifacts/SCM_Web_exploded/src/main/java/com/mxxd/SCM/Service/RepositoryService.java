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

import com.mxxd.SCM.Dao.RepositoryMapper;
import com.mxxd.SCM.Entity.RepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈仓库Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Service
public class RepositoryService {

    @Autowired
    private RepositoryMapper repositoryMapper;

    public ArrayList<RepositoryEntity> queryRepository(RepositoryEntity repositoryEntity){
        ArrayList<RepositoryEntity> repositorys = repositoryMapper.queryRepository(repositoryEntity);
        return repositorys;
    }

    public boolean insert(RepositoryEntity repositoryEntity){
        boolean result = repositoryMapper.insert(repositoryEntity);
        return result;
    }

    public boolean update(RepositoryEntity repositoryEntity){
        boolean result = repositoryMapper.update(repositoryEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = repositoryMapper.delete(id);
        return result;
    }

    public ArrayList<RepositoryEntity> ajax_queryRepository(){
        ArrayList<RepositoryEntity> repositorys = repositoryMapper.ajax_queryRepository();
        return repositorys;
    }

    public ArrayList<RepositoryEntity> ajax_queryRepository_id(int id){
        ArrayList<RepositoryEntity> repositorys = repositoryMapper.ajax_queryRepository_id(id);
        return repositorys;
    }

}