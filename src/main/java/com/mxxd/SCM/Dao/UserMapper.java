package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {

    //@Select("SELECT * FROM `users` where user_username = #{username} and user_password = #{password}")
    public UserEntity login(String username, String password);

    public ArrayList<UserEntity> queryUser(UserEntity user);

    public boolean insert(UserEntity user);

    public boolean update(UserEntity user);

    public boolean delete(int id);

}
