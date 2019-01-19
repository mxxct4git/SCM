/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CustomerEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 12:07
 * Description: 客户实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈客户实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class CustomerEntity {
    private int id; // 客户ID
    private String name; // 客户姓名
    private String phone; // 客户电话
    private String email; // 客户邮箱
    private String address; // 客户地址
    private int classify; // 客户分类
    private String comment; // 备注

    public CustomerEntity() {
        super();
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", classify=" + classify +
                ", comment='" + comment + '\'' +
                '}';
    }

    public CustomerEntity(int id, String name, String phone, String email, String address, int classify, String comment) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.classify = classify;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}