/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   猫熊小才天
 * Date:     2018/10/21 21:09
 * Description: 用户Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Controller;

import com.mxxd.SCM.Entity.*;
import com.mxxd.SCM.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈流水Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("/waterList")
public class WaterListController {

    @Autowired
    private WaterListService waterListService;

    @Autowired
    private InListService inListService;

    @Autowired
    private OutListService outListService;

    @Autowired
    private CostService costService;

    @Autowired
    private IncomeService incomeService;

    @RequestMapping("/queryWaterList")
    public ModelAndView queryWaterList(String factory_id,String repository_id,String product_main_code,String product_code,String date_lower,String date_upper,String in_or_out) {
        WaterListEntity waterListEntity = new WaterListEntity();
        if(factory_id != null && factory_id != ""){
            waterListEntity.setFactory_id(Integer.valueOf(factory_id));
        }
        if(repository_id != null && repository_id != ""){
            waterListEntity.setRepository_id(Integer.valueOf(repository_id));
        }
        if(in_or_out != null && in_or_out != ""){
            waterListEntity.setIn_or_out(Integer.valueOf(in_or_out));
        }
        if(product_main_code != null && product_main_code != ""){
            waterListEntity.setProduct_main_code(product_main_code);
        }
        if(product_code != null && product_code != ""){
            waterListEntity.setProduct_code(product_code);
        }
        if(date_lower != null && date_lower != ""){
            waterListEntity.setDate_lower(date_lower);
        }
        if(date_upper != null && date_upper != ""){
            waterListEntity.setDate_upper(date_upper);
        }

        ArrayList<WaterListEntity> waterLists = waterListService.queryWaterList(waterListEntity);
        ModelAndView mv = new ModelAndView();
        if (waterLists == null || waterLists.size() <= 0) {
            mv.addObject("message", "无此流水记录！");
            mv.setViewName("redirect:queryWaterList");
        } else {
            mv.addObject("waterLists", waterLists);
            mv.setViewName("WaterList_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(WaterListEntity waterListEntity) {
        boolean result = waterListService.insert(waterListEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新流水失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "添加新流水成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(WaterListEntity waterListEntity) {
        boolean result = waterListService.update(waterListEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "流水信息更新失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "流水信息更新成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = waterListService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "流水删除失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "已删除此流水！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/detailWaterList")
    public ModelAndView detailCost(String timestamp,int in_or_out) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("in_or_out", in_or_out);
        if(in_or_out == 1){ // 入库
            CostEntity cost = new CostEntity();
            cost.setInlist_timestamp(timestamp);
            ArrayList<CostEntity> costEntities = costService.queryCost(cost);
            cost = costEntities.get(0);

            InListEntity inListEntity = new InListEntity();
            inListEntity.setIn_timestamp(timestamp);
            ArrayList<InListEntity> inListEntities = inListService.queryInList(inListEntity);
            inListEntity = inListEntities.get(0);
            mv.addObject("inList", inListEntity);
            mv.addObject("cost", cost);
            mv.setViewName("WaterList_Detail_In");
        }else {
            IncomeEntity income = new IncomeEntity();
            income.setOutlist_timestamp(timestamp);
            ArrayList<IncomeEntity> incomeEntities = incomeService.queryIncome(income);
            income = incomeEntities.get(0);

            OutListEntity outListEntity = new OutListEntity();
            outListEntity.setOut_timestamp(timestamp);
            ArrayList<OutListEntity> outListEntities = outListService.queryOutList(outListEntity);
            outListEntity = outListEntities.get(0);
            mv.addObject("outList", outListEntity);
            mv.addObject("income", income);
            mv.setViewName("WaterList_Detail_Out");
        }
        return mv;
    }
}