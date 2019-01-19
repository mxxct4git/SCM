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

import com.mxxd.SCM.Dao.DeployMapper;
import com.mxxd.SCM.Entity.DeployEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈调配Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Service
public class DeployService {

    @Autowired
    private DeployMapper deployMapper;

    public ArrayList<DeployEntity> queryDeployIn(DeployEntity deployEntity){
        ArrayList<DeployEntity> deploys = deployMapper.queryDeployIn(deployEntity);
        return deploys;
    }

    public ArrayList<DeployEntity> queryDeployOut(DeployEntity deployEntity){
        ArrayList<DeployEntity> deploys = deployMapper.queryDeployOut(deployEntity);
        return deploys;
    }

    public boolean insert(DeployEntity deployEntity){
        boolean result = deployMapper.insert(deployEntity);
        return result;
    }

    public boolean update(DeployEntity deployEntity){
        boolean result = deployMapper.update(deployEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = deployMapper.delete(id);
        return result;
    }

}