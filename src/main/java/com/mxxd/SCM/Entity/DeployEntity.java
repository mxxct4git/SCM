/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DeployEntity
 * Author:   猫熊小才天
 * Date:     2018/10/23 9:46
 * Description: 调配记录实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈调配记录实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */
public class DeployEntity{
    private int id;
    private int source_factory_id; // 原工厂ID
    private String source_factory_name; // 原工厂名称
    private int source_repository_id; // 原仓库ID
    private String source_repository_name; // 原仓库名称
    private String source_product_main_code; // 原商品主编码
    private String source_product_code; // 原商品编码
    private int aim_factory_id; // 目标工厂ID
    private String aim_factory_name; // 目标工厂名称
    private int aim_repository_id; // 目标仓库ID
    private String aim_repository_name; // 目标仓库名称
    private String aim_product_main_code; // 目标商品主编码
    private String aim_product_code; // 目标商品编码
    private String product_color; // 商品颜色
    private String product_size; // 商品尺寸
    private String product_density; // 商品密度
    private int product_makou; // 商品码口
    private int product_mashu; // 商品码数
    private int deploy_quantity; // 调配数量
    private String deploy_date; // 调配日期 yyyy-mm-dd
    private String comment; // 备注

    public boolean equals(DeployEntity obj) {
        if(this.getId() == obj.getId())
            return true;
        else
            return false;
    }

    public DeployEntity() {
        super();
    }

    @Override
    public String toString() {
        return "DeployEntity{" +
                "id=" + id +
                ", source_factory_id=" + source_factory_id +
                ", source_factory_name='" + source_factory_name + '\'' +
                ", source_repository_id=" + source_repository_id +
                ", source_repository_name='" + source_repository_name + '\'' +
                ", source_product_main_code='" + source_product_main_code + '\'' +
                ", source_product_code='" + source_product_code + '\'' +
                ", aim_factory_id=" + aim_factory_id +
                ", aim_factory_name='" + aim_factory_name + '\'' +
                ", aim_repository_id=" + aim_repository_id +
                ", aim_repository_name='" + aim_repository_name + '\'' +
                ", aim_product_main_code='" + aim_product_main_code + '\'' +
                ", aim_product_code='" + aim_product_code + '\'' +
                ", product_color='" + product_color + '\'' +
                ", product_size='" + product_size + '\'' +
                ", product_density='" + product_density + '\'' +
                ", product_makou=" + product_makou +
                ", product_mashu=" + product_mashu +
                ", deploy_quantity=" + deploy_quantity +
                ", deploy_date='" + deploy_date + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public DeployEntity(int id, int source_factory_id, String source_factory_name, int source_repository_id, String source_repository_name, String source_product_main_code, String source_product_code, int aim_factory_id, String aim_factory_name, int aim_repository_id, String aim_repository_name, String aim_product_main_code, String aim_product_code, String product_color, String product_size, String product_density, int product_makou, int product_mashu, int deploy_quantity, String deploy_date, String comment) {
        this.id = id;
        this.source_factory_id = source_factory_id;
        this.source_factory_name = source_factory_name;
        this.source_repository_id = source_repository_id;
        this.source_repository_name = source_repository_name;
        this.source_product_main_code = source_product_main_code;
        this.source_product_code = source_product_code;
        this.aim_factory_id = aim_factory_id;
        this.aim_factory_name = aim_factory_name;
        this.aim_repository_id = aim_repository_id;
        this.aim_repository_name = aim_repository_name;
        this.aim_product_main_code = aim_product_main_code;
        this.aim_product_code = aim_product_code;
        this.product_color = product_color;
        this.product_size = product_size;
        this.product_density = product_density;
        this.product_makou = product_makou;
        this.product_mashu = product_mashu;
        this.deploy_quantity = deploy_quantity;
        this.deploy_date = deploy_date;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource_factory_id() {
        return source_factory_id;
    }

    public void setSource_factory_id(int source_factory_id) {
        this.source_factory_id = source_factory_id;
    }

    public String getSource_factory_name() {
        return source_factory_name;
    }

    public void setSource_factory_name(String source_factory_name) {
        this.source_factory_name = source_factory_name;
    }

    public int getSource_repository_id() {
        return source_repository_id;
    }

    public void setSource_repository_id(int source_repository_id) {
        this.source_repository_id = source_repository_id;
    }

    public String getSource_repository_name() {
        return source_repository_name;
    }

    public void setSource_repository_name(String source_repository_name) {
        this.source_repository_name = source_repository_name;
    }

    public String getSource_product_main_code() {
        return source_product_main_code;
    }

    public void setSource_product_main_code(String source_product_main_code) {
        this.source_product_main_code = source_product_main_code;
    }

    public String getSource_product_code() {
        return source_product_code;
    }

    public void setSource_product_code(String source_product_code) {
        this.source_product_code = source_product_code;
    }

    public int getAim_factory_id() {
        return aim_factory_id;
    }

    public void setAim_factory_id(int aim_factory_id) {
        this.aim_factory_id = aim_factory_id;
    }

    public String getAim_factory_name() {
        return aim_factory_name;
    }

    public void setAim_factory_name(String aim_factory_name) {
        this.aim_factory_name = aim_factory_name;
    }

    public int getAim_repository_id() {
        return aim_repository_id;
    }

    public void setAim_repository_id(int aim_repository_id) {
        this.aim_repository_id = aim_repository_id;
    }

    public String getAim_repository_name() {
        return aim_repository_name;
    }

    public void setAim_repository_name(String aim_repository_name) {
        this.aim_repository_name = aim_repository_name;
    }

    public String getAim_product_main_code() {
        return aim_product_main_code;
    }

    public void setAim_product_main_code(String aim_product_main_code) {
        this.aim_product_main_code = aim_product_main_code;
    }

    public String getAim_product_code() {
        return aim_product_code;
    }

    public void setAim_product_code(String aim_product_code) {
        this.aim_product_code = aim_product_code;
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

    public int getDeploy_quantity() {
        return deploy_quantity;
    }

    public void setDeploy_quantity(int deploy_quantity) {
        this.deploy_quantity = deploy_quantity;
    }

    public String getDeploy_date() {
        return deploy_date;
    }

    public void setDeploy_date(String deploy_date) {
        this.deploy_date = deploy_date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}