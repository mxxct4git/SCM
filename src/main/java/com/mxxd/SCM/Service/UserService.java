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

import com.mxxd.SCM.Dao.UserMapper;
import com.mxxd.SCM.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity login(String username, String password){
        UserEntity user = userMapper.login(username,password);
        return user;
    }

    public ArrayList<UserEntity> queryUser(UserEntity user){
        ArrayList<UserEntity> users = userMapper.queryUser(user);
        return users;
    }

    public boolean insert(UserEntity user){
        boolean result = userMapper.insert(user);
        return result;
    }

    public boolean update(UserEntity user){
        boolean result = userMapper.update(user);
        return result;
    }

    public boolean delete(int id){
        boolean result = userMapper.delete(id);
        return result;
    }

}