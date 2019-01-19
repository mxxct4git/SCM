/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: InListEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:55
 * Description: 入库单实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈入库单实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class InListEntity {
    private int id; // 入库单ID
    private String in_timestamp; // 入库时间戳
    private int factory_id; // 工厂ID 外键
    private String factory_name; // 工厂名称
    private int repository_id; // 仓库ID 外键
    private String repository_name; // 仓库名称
    private String in_date; // 入库时间 yyyy-mm-dd
    private String product_main_code; // 商品主编码
    private String product_code; // 商品编码
    private String product_color; // 商品颜色
    private String product_size; // 商品尺寸
    private String product_density; // 商品密度
    private int product_makou; // 商品码口
    private int product_mashu; // 商品码数
    private int product_price; // 商品单价
    private int total_price; // 入库合计金额
    private int is_callback; // 是否退货标识 1 退货 2 未退货 默认2
    private String comment; // 备注

    public InListEntity() {
        super();
    }

    @Override
    public String toString() {
        return "InListEntity{" +
                "id=" + id +
                ", in_timestamp='" + in_timestamp + '\'' +
                ", factory_id=" + factory_id +
                ", factory_name='" + factory_name + '\'' +
                ", repository_id=" + repository_id +
                ", repository_name='" + repository_name + '\'' +
                ", in_date='" + in_date + '\'' +
                ", product_main_code='" + product_main_code + '\'' +
                ", product_code='" + product_code + '\'' +
                ", product_color='" + product_color + '\'' +
                ", product_size='" + product_size + '\'' +
                ", product_density='" + product_density + '\'' +
                ", product_makou=" + product_makou +
                ", product_mashu=" + product_mashu +
                ", product_price=" + product_price +
                ", total_price=" + total_price +
                ", is_callback=" + is_callback +
                ", comment='" + comment + '\'' +
                '}';
    }

    public InListEntity(int id, String in_timestamp, int factory_id, String factory_name, int repository_id, String repository_name, String in_date, String product_main_code, String product_code, String product_color, String product_size, String product_density, int product_makou, int product_mashu, int product_price, int total_price, int is_callback, String comment) {
        this.id = id;
        this.in_timestamp = in_timestamp;
        this.factory_id = factory_id;
        this.factory_name = factory_name;
        this.repository_id = repository_id;
        this.repository_name = repository_name;
        this.in_date = in_date;
        this.product_main_code = product_main_code;
        this.product_code = product_code;
        this.product_color = product_color;
        this.product_size = product_size;
        this.product_density = product_density;
        this.product_makou = product_makou;
        this.product_mashu = product_mashu;
        this.product_price = product_price;
        this.total_price = total_price;
        this.is_callback = is_callback;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIn_timestamp() {
        return in_timestamp;
    }

    public void setIn_timestamp(String in_timestamp) {
        this.in_timestamp = in_timestamp;
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

    public String getIn_date() {
        return in_date;
    }

    public void setIn_date(String in_date) {
        this.in_date = in_date;
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

    public int getProduct_mashu() {
        return product_mashu;
    }

    public void setProduct_mashu(int product_mashu) {
        this.product_mashu = product_mashu;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getIs_callback() {
        return is_callback;
    }

    public void setIs_callback(int is_callback) {
        this.is_callback = is_callback;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}