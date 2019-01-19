/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CostController
 * Author:   猫熊小才天
 * Date:     2018/10/23 13:07
 * Description: 客户Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Controller;

import com.mxxd.SCM.Entity.IncomeEntity;
import com.mxxd.SCM.Entity.OutListEntity;
import com.mxxd.SCM.Service.IncomeService;
import com.mxxd.SCM.Service.OutListService;
import com.mxxd.SCM.Utils.CalendarTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收入Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */

@Controller
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private OutListService outListService;

    @RequestMapping("/queryIncome")
    public ModelAndView queryIncome(String outList_timestamp,String date_lower,String date_upper,String is_income_complete){
        IncomeEntity income = new IncomeEntity();
        if(outList_timestamp != null && outList_timestamp !=""){
            income.setOutlist_timestamp(outList_timestamp);
        }
        if(date_lower != null && date_lower !=""){
            income.setDate_lower(date_lower);
        }
        if(date_upper != null && date_upper !=""){
            income.setDate_upper(date_upper);
        }
        if(is_income_complete != null && is_income_complete !=""){
            income.setIs_income_complete(Integer.valueOf(is_income_complete));
        }
        ArrayList<IncomeEntity> incomes = incomeService.queryIncome(income);
        ModelAndView mv = new ModelAndView();
        if (incomes == null || incomes.size() <= 0) {
            mv.addObject("message", "无此收入！");
            mv.setViewName("redirect:queryIncome");
        } else {
            mv.addObject("incomes", incomes);
            mv.setViewName("Income_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(IncomeEntity incomeEntity){
        boolean result = incomeService.insert(incomeEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新收入失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "添加新收入成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(IncomeEntity incomeEntity){
        boolean result = incomeService.update(incomeEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "收入信息更新失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "收入信息更新成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = incomeService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "收入删除失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "已删除此收入！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/detailIncome")
    public ModelAndView detailIncome(int id) {
        IncomeEntity income = new IncomeEntity();
        income.setId(id);
        ArrayList<IncomeEntity> incomeEntities = incomeService.queryIncome(income);
        income = incomeEntities.get(0);

        OutListEntity outListEntity = new OutListEntity();
        outListEntity.setOut_timestamp(income.getOutlist_timestamp());
        ArrayList<OutListEntity> outListEntities = outListService.queryOutList(outListEntity);
        outListEntity = outListEntities.get(0);

        ModelAndView mv = new ModelAndView();
        mv.addObject("income", income);
        mv.addObject("outList", outListEntity);
        mv.setViewName("Income_Detail");
        return mv;
    }

    @RequestMapping("/check")
    public ModelAndView check(int id) {
        IncomeEntity income = new IncomeEntity();
        income.setId(id);
        ArrayList<IncomeEntity> incomeEntities = incomeService.queryIncome(income);
        income = incomeEntities.get(0);
        income.setIs_income_complete(1);
        boolean result = incomeService.update(income);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "收入结算失败！");
            mv.setViewName("redirect:queryIncome");
        } else {
            mv.addObject("message", "收入结算成功！");
            mv.setViewName("redirect:queryIncome");
        }
        return mv;
    }

    @RequestMapping("/uncheck")
    public ModelAndView uncheck(int id) {
        IncomeEntity income = new IncomeEntity();
        income.setId(id);
        ArrayList<IncomeEntity> incomeEntities = incomeService.queryIncome(income);
        income = incomeEntities.get(0);
        income.setIs_income_complete(2);
        boolean result = incomeService.update(income);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "收入取消结算失败！");
            mv.setViewName("redirect:queryIncome");
        } else {
            mv.addObject("message", "收入取消结算成功！");
            mv.setViewName("redirect:queryIncome");
        }
        return mv;
    }

    @RequestMapping("/month_income")
    @ResponseBody
    public int month_income(){
        CalendarTime cTime = new CalendarTime();
        String out_date = cTime.getMonthTime();
        String num = incomeService.month_income(out_date);
        if(num == null || num == ""){
            return 0;
        }else {
            int count = Integer.valueOf(num);
            return count;
        }
    }
}