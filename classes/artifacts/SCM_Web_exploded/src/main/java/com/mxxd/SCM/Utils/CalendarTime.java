/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CalendarTime
 * Author:   猫熊小才天
 * Date:     2018/11/12 15:42
 * Description: 获取时间类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Utils;

import java.util.Calendar;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取时间类〉
 *
 * @author 猫熊小才天
 * @create 2018/11/12
 * @since 1.0.0
 */
public class CalendarTime {
    public String getTodayTime(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        month = month + 1;
        String today = year + "-";
        if(month < 10){
            today = today + "0" + month + "-";
        }else{
            today = today + month + "-";
        }
        if(date < 10){
            today = today + "0" + date;
        }else{
            today = today + date;
        }
        return today;
    }

    public String getMonthTime(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;
        String today = year + "-";
        if(month < 10){
            today = today + "0" + month;
        }else{
            today = today + month;
        }
        return today;
    }
}