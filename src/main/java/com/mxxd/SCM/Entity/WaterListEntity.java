/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WaterListEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:50
 * Description: 流水单实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈流水单实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class WaterListEntity {
    private int id;
    private int factory_id; // 工厂ID 外键
    private String factory_name; // 工厂名称
    private int repository_id; // 仓库ID 外键
    private String repository_name; // 仓库名称
    private String date_lower; // 时间下限
    private String date_upper; // 时间上限
    private String product_main_code; // 商品主编码
    private String product_code; // 商品编码
    private int in_or_out; // 出入库标识 1 入库 2 出库
    private String in_or_out_timestamp; // 出入库对应的时间戳
    private String in_or_out_date; // 出入库对应的时间

    public WaterListEntity() {
        super();
    }

    @Override
    public String toString() {
        return "WaterListEntity{" +
                "id=" + id +
                ", factory_id=" + factory_id +
                ", factory_name='" + factory_name + '\'' +
                ", repository_id=" + repository_id +
                ", repository_name='" + repository_name + '\'' +
                ", date_lower='" + date_lower + '\'' +
                ", date_upper='" + date_upper + '\'' +
                ", product_main_code='" + product_main_code + '\'' +
                ", product_code='" + product_code + '\'' +
                ", in_or_out=" + in_or_out +
                ", in_or_out_timestamp='" + in_or_out_timestamp + '\'' +
                ", in_or_out_date='" + in_or_out_date + '\'' +
                '}';
    }

    public WaterListEntity(int id, int factory_id, String factory_name, int repository_id, String repository_name, String date_lower, String date_upper, String product_main_code, String product_code, int in_or_out, String in_or_out_timestamp, String in_or_out_date) {
        this.id = id;
        this.factory_id = factory_id;
        this.factory_name = factory_name;
        this.repository_id = repository_id;
        this.repository_name = repository_name;
        this.date_lower = date_lower;
        this.date_upper = date_upper;
        this.product_main_code = product_main_code;
        this.product_code = product_code;
        this.in_or_out = in_or_out;
        this.in_or_out_timestamp = in_or_out_timestamp;
        this.in_or_out_date = in_or_out_date;
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

    public String getDate_lower() {
        return date_lower;
    }

    public void setDate_lower(String date_lower) {
        this.date_lower = date_lower;
    }

    public String getDate_upper() {
        return date_upper;
    }

    public void setDate_upper(String date_upper) {
        this.date_upper = date_upper;
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

    public int getIn_or_out() {
        return in_or_out;
    }

    public void setIn_or_out(int in_or_out) {
        this.in_or_out = in_or_out;
    }

    public String getIn_or_out_timestamp() {
        return in_or_out_timestamp;
    }

    public void setIn_or_out_timestamp(String in_or_out_timestamp) {
        this.in_or_out_timestamp = in_or_out_timestamp;
    }

    public String getIn_or_out_date() {
        return in_or_out_date;
    }

    public void setIn_or_out_date(String in_or_out_date) {
        this.in_or_out_date = in_or_out_date;
    }
}