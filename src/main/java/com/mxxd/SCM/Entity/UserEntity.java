/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 12:23
 * Description: 用户实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */

public class UserEntity {
    private int id; // 用户ID
    private String username; // 用户的用户名
    private String password; // 用户的密码
    private String name; // 用户的姓名
    private String phone; // 用户电话
    private String email; // 用户邮箱
    private String address; // 用户地址
    private int authority; // 用户权限 1 管理员 2 普通用户
    private int is_login; // 登录标识

    public UserEntity() {
        super();
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", authority=" + authority +
                ", is_login='" + is_login + '\'' +
                '}';
    }

    public UserEntity(int id, String username, String password, String name, String phone, String email, String address, int authority, int is_login) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.authority = authority;
        this.is_login = is_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public int getIs_login() {
        return is_login;
    }

    public void setIs_login(int is_login) {
        this.is_login = is_login;
    }
}