/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IncomeEntity
 * Author:   猫熊小才天
 * Date:     2018/10/21 15:25
 * Description: 收入实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收入实体类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
public class IncomeEntity {
    private int id; // 收入ID
    private String outlist_timestamp; // 出库时间戳
    private String out_date; // 出库时间 yyyy-mm-dd 方便查询结果呈现
    private String date_lower; // 时间下限
    private String date_upper; // 时间上限
    private int income_total; // 收入合计
    private int is_income_complete; // 完成支付标识 1 完成 2 未完成

    public IncomeEntity() {
        super();
    }

    @Override
    public String toString() {
        return "IncomeEntity{" +
                "id=" + id +
                ", outlist_timestamp='" + outlist_timestamp + '\'' +
                ", out_date='" + out_date + '\'' +
                ", date_lower='" + date_lower + '\'' +
                ", date_upper='" + date_upper + '\'' +
                ", income_total=" + income_total +
                ", is_income_complete=" + is_income_complete +
                '}';
    }

    public IncomeEntity(int id, String outlist_timestamp, String out_date, String date_lower, String date_upper, int income_total, int is_income_complete) {
        this.id = id;
        this.outlist_timestamp = outlist_timestamp;
        this.out_date = out_date;
        this.date_lower = date_lower;
        this.date_upper = date_upper;
        this.income_total = income_total;
        this.is_income_complete = is_income_complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutlist_timestamp() {
        return outlist_timestamp;
    }

    public void setOutlist_timestamp(String outlist_timestamp) {
        this.outlist_timestamp = outlist_timestamp;
    }

    public String getOut_date() {
        return out_date;
    }

    public void setOut_date(String out_date) {
        this.out_date = out_date;
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

    public int getIncome_total() {
        return income_total;
    }

    public void setIncome_total(int income_total) {
        this.income_total = income_total;
    }

    public int getIs_income_complete() {
        return is_income_complete;
    }

    public void setIs_income_complete(int is_income_complete) {
        this.is_income_complete = is_income_complete;
    }
}