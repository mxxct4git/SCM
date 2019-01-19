/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:28
 * Description: 商品实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class ProductEntity {
    private int id; // 商品ID
    private int factory_id; // 工厂ID 外键
    private String factory_name; // 工厂名称
    private String main_code; // 商品主编码
    private String code; // 商品编码
    private String name; // 商品名称
    private String comment; // 备注

    public ProductEntity() {
        super();
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", factory_id=" + factory_id +
                ", factory_name='" + factory_name + '\'' +
                ", main_code='" + main_code + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public ProductEntity(int id, int factory_id, String factory_name, String main_code, String code, String name, String comment) {
        this.id = id;
        this.factory_id = factory_id;
        this.factory_name = factory_name;
        this.main_code = main_code;
        this.code = code;
        this.name = name;
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

    public String getMain_code() {
        return main_code;
    }

    public void setMain_code(String main_code) {
        this.main_code = main_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}