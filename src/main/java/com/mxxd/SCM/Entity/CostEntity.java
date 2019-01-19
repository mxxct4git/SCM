/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CostEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:18
 * Description: 成本实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈成本实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class CostEntity {
    private int id; // 成本ID
    private String inlist_timestamp; // 入库时间戳
    private String in_date; // 入库时间 yyyy-mm-dd 方便查询结果呈现
    private String date_lower; // 时间下限
    private String date_upper; // 时间上限
    private int cost_total; // 成本合计
    private int is_cost_complete; // 完成支付标识 1 完成 2 未完成

    public CostEntity() {
        super();
    }

    @Override
    public String toString() {
        return "CostEntity{" +
                "id=" + id +
                ", inlist_timestamp='" + inlist_timestamp + '\'' +
                ", in_date='" + in_date + '\'' +
                ", date_lower='" + date_lower + '\'' +
                ", date_upper='" + date_upper + '\'' +
                ", cost_total=" + cost_total +
                ", is_cost_complete=" + is_cost_complete +
                '}';
    }

    public CostEntity(int id, String inlist_timestamp, String in_date, String date_lower, String date_upper, int cost_total, int is_cost_complete) {
        this.id = id;
        this.inlist_timestamp = inlist_timestamp;
        this.in_date = in_date;
        this.date_lower = date_lower;
        this.date_upper = date_upper;
        this.cost_total = cost_total;
        this.is_cost_complete = is_cost_complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInlist_timestamp() {
        return inlist_timestamp;
    }

    public void setInlist_timestamp(String inlist_timestamp) {
        this.inlist_timestamp = inlist_timestamp;
    }

    public String getIn_date() {
        return in_date;
    }

    public void setIn_date(String in_date) {
        this.in_date = in_date;
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

    public int getCost_total() {
        return cost_total;
    }

    public void setCost_total(int cost_total) {
        this.cost_total = cost_total;
    }

    public int getIs_cost_complete() {
        return is_cost_complete;
    }

    public void setIs_cost_complete(int is_cost_complete) {
        this.is_cost_complete = is_cost_complete;
    }
}