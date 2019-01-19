/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FactoryEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:21
 * Description: 工厂实体类哦
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工厂实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class FactoryEntity {
    private int id; // 工厂ID
    private String name; // 工厂名称
    private String address; // 工厂地址
    private String manager; // 工厂负责人
    private String manager_phone; // 工厂负责人电话
    private String manager_email; // 工厂负责人邮箱
    private int is_main_factory; // 主工厂标识 1 自己的工厂 2 主工厂 3 分工厂
    private String comment; // 备注

    public FactoryEntity() {
        super();
    }

    public FactoryEntity(int id, String name, String address, String manager, String manager_phone, String manager_email, int is_main_factory, String comment) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.manager_phone = manager_phone;
        this.manager_email = manager_email;
        this.is_main_factory = is_main_factory;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "FactoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manager='" + manager + '\'' +
                ", manager_phone=" + manager_phone +
                ", manager_email='" + manager_email + '\'' +
                ", is_main_factory=" + is_main_factory +
                ", comment='" + comment + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManager_phone() {
        return manager_phone;
    }

    public void setManager_phone(String manager_phone) {
        this.manager_phone = manager_phone;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public int getIs_main_factory() {
        return is_main_factory;
    }

    public void setIs_main_factory(int is_main_factory) {
        this.is_main_factory = is_main_factory;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}