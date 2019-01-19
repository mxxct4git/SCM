/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RepositoryEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:39
 * Description: 仓库实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈仓库实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class RepositoryEntity {
    private int id; // 仓库ID
    private int factory_id; // 工厂ID 外键
    private String factory_name; // 工厂名称
    private String name; // 仓库名称
    private String address; // 仓库地址
    private String manager; // 仓库负责人
    private String manager_phone; // 仓库负责人电话
    private String manager_email; // 仓库负责人邮箱
    private String volume; // 仓库最大容量
    private String comment; // 备注

    public RepositoryEntity() {
        super();
    }

    @Override
    public String toString() {
        return "RepositoryEntity{" +
                "id=" + id +
                ", factory_id=" + factory_id +
                ", factory_name='" + factory_name + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manager='" + manager + '\'' +
                ", manager_phone='" + manager_phone + '\'' +
                ", manager_email='" + manager_email + '\'' +
                ", volume=" + volume +
                ", comment='" + comment + '\'' +
                '}';
    }

    public RepositoryEntity(int id, int factory_id, String factory_name, String name, String address, String manager, String manager_phone, String manager_email, String volume, String comment) {
        this.id = id;
        this.factory_id = factory_id;
        this.factory_name = factory_name;
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.manager_phone = manager_phone;
        this.manager_email = manager_email;
        this.volume = volume;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}