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

import com.mxxd.SCM.Entity.CostEntity;
import com.mxxd.SCM.Entity.InListEntity;
import com.mxxd.SCM.Service.CostService;
import com.mxxd.SCM.Service.InListService;
import com.mxxd.SCM.Utils.CalendarTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈成本Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */

@Controller
@RequestMapping("/cost")
public class CostController {

    @Autowired
    private CostService costService;

    @Autowired
    private InListService inListService;

    @RequestMapping("/queryCost")
    public ModelAndView queryCost(String inList_timestamp,String date_lower,String date_upper,String is_cost_complete){
        CostEntity cost = new CostEntity();
        if(inList_timestamp != null && inList_timestamp !=""){
            cost.setInlist_timestamp(inList_timestamp);
        }
        if(date_lower != null && date_lower !=""){
            cost.setDate_lower(date_lower);
        }
        if(date_upper != null && date_upper !=""){
            cost.setDate_upper(date_upper);
        }
        if(is_cost_complete != null && is_cost_complete !=""){
            cost.setIs_cost_complete(Integer.valueOf(is_cost_complete));
        }
        ArrayList<CostEntity> costs = costService.queryCost(cost);
        ModelAndView mv = new ModelAndView();
        if (costs == null || costs.size() <= 0) {
            mv.addObject("message", "无此成本！");
            mv.setViewName("redirect:queryCost");
        } else {
            mv.addObject("costs", costs);
            mv.setViewName("Cost_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(CostEntity costEntity){
        boolean result = costService.insert(costEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新成本失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "添加新成本成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(CostEntity costEntity){
        boolean result = costService.update(costEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "成本信息更新失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "成本信息更新成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = costService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "成本删除失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "已删除此成本！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/detailCost")
    public ModelAndView detailCost(int id) {
        CostEntity tmp = new CostEntity();
        tmp.setId(id);
        ArrayList<CostEntity> costs = costService.queryCost(tmp);
        tmp = costs.get(0);

        InListEntity inListEntity = new InListEntity();
        inListEntity.setIn_timestamp(tmp.getInlist_timestamp());
        ArrayList<InListEntity> inListEntities = inListService.queryInList(inListEntity);
        inListEntity = inListEntities.get(0);

        ModelAndView mv = new ModelAndView();
        mv.addObject("cost", tmp);
        mv.addObject("inList", inListEntity);
        mv.setViewName("Cost_Detail");
        return mv;
    }

    @RequestMapping("/check")
    public ModelAndView check(int id) {
        CostEntity cost = new CostEntity();
        cost.setId(id);
        ArrayList<CostEntity> costEntities = costService.queryCost(cost);
        cost = costEntities.get(0);
        cost.setIs_cost_complete(1);
        boolean result = costService.update(cost);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "成本结算失败！");
            mv.setViewName("redirect:queryCost");
        } else {
            mv.addObject("message", "成本结算成功！");
            mv.setViewName("redirect:queryCost");
        }
        return mv;
    }

    @RequestMapping("/uncheck")
    public ModelAndView uncheck(int id) {
        CostEntity cost = new CostEntity();
        cost.setId(id);
        ArrayList<CostEntity> costEntities = costService.queryCost(cost);
        cost = costEntities.get(0);
        cost.setIs_cost_complete(2);
        boolean result = costService.update(cost);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "成本取消结算失败！");
            mv.setViewName("redirect:queryCost");
        } else {
            mv.addObject("message", "成本取消结算成功！");
            mv.setViewName("redirect:queryCost");
        }
        return mv;
    }

    @RequestMapping("/month_cost")
    @ResponseBody
    public int month_cost(){
        CalendarTime cTime = new CalendarTime();
        String in_date = cTime.getMonthTime();
        String num = costService.month_cost(in_date);
        if(num == null || num == ""){
            return 0;
        }else {
            int count = Integer.valueOf(num);
            return count;
        }
    }
}