/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: StorageEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:45
 * Description: 存储实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈存储实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class StorageEntity {
    private int id; // 存储ID
    private int factory_id; // 工厂ID 外键
    private String factory_name; // 工厂名称
    private int repository_id; // 仓库ID 外键
    private String repository_name; // 仓库名称
    private String product_main_code; // 商品主编码
    private String product_code; // 商品编码
    private String product_color; // 商品颜色
    private String product_size; // 商品尺寸
    private String product_density; // 商品密度
    private int product_makou; // 商品码口
    private int quantity; // 数量
    private int quantity_lower; // 数量下限
    private int quantity_upper; // 数量上限

    public StorageEntity() {
        super();
    }

    @Override
    public String toString() {
        return "StorageEntity{" +
                "id=" + id +
                ", factory_id=" + factory_id +
                ", factory_name='" + factory_name + '\'' +
                ", repository_id=" + repository_id +
                ", repository_name='" + repository_name + '\'' +
                ", product_main_code='" + product_main_code + '\'' +
                ", product_code='" + product_code + '\'' +
                ", product_color='" + product_color + '\'' +
                ", product_size='" + product_size + '\'' +
                ", product_density='" + product_density + '\'' +
                ", product_makou=" + product_makou +
                ", quantity=" + quantity +
                ", quantity_lower='" + quantity_lower + '\'' +
                ", quantity_upper='" + quantity_upper + '\'' +
                '}';
    }

    public StorageEntity(int id, int factory_id, String factory_name, int repository_id, String repository_name, String product_main_code, String product_code, String product_color, String product_size, String product_density, int product_makou, int quantity, int quantity_lower, int quantity_upper) {
        this.id = id;
        this.factory_id = factory_id;
        this.factory_name = factory_name;
        this.repository_id = repository_id;
        this.repository_name = repository_name;
        this.product_main_code = product_main_code;
        this.product_code = product_code;
        this.product_color = product_color;
        this.product_size = product_size;
        this.product_density = product_density;
        this.product_makou = product_makou;
        this.quantity = quantity;
        this.quantity_lower = quantity_lower;
        this.quantity_upper = quantity_upper;
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

    public int getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(int repository_id) {
        this.repository_id = repository_id;
    }

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }

    public String getProduct_main_code() {
        return product_main_code;
    }

    public void setProduct_main_code(String product_main_code) {
        this.product_main_code = product_main_code;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getProduct_density() {
        return product_density;
    }

    public void setProduct_density(String product_density) {
        this.product_density = product_density;
    }

    public int getProduct_makou() {
        return product_makou;
    }

    public void setProduct_makou(int product_makou) {
        this.product_makou = product_makou;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity_lower() {
        return quantity_lower;
    }

    public void setQuantity_lower(int quantity_lower) {
        this.quantity_lower = quantity_lower;
    }

    public int getQuantity_upper() {
        return quantity_upper;
    }

    public void setQuantity_upper(int quantity_upper) {
        this.quantity_upper = quantity_upper;
    }
}