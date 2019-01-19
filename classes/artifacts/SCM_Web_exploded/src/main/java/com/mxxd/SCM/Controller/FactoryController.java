/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FactoryController
 * Author:   猫熊小才天
 * Date:     2018/10/22 14:48
 * Description: 工厂controller类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Controller;

import com.mxxd.SCM.Entity.FactoryEntity;
import com.mxxd.SCM.Service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工厂Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Controller
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    @RequestMapping("/queryFactory")
    public ModelAndView queryFactory(String name,String manager,String manager_phone,String is_main_factory){
        FactoryEntity factoryEntity = new FactoryEntity();
        if(name!=null&&name!="")
            factoryEntity.setName(name);
        if(manager!=null&&name!="")
            factoryEntity.setManager(manager);
        if(manager_phone!=null&&manager_phone!="")
            factoryEntity.setManager_phone(manager_phone);
        if(is_main_factory!=null&&is_main_factory!="")
            factoryEntity.setIs_main_factory(Integer.valueOf(is_main_factory));
        ArrayList<FactoryEntity> factoryList = factoryService.queryFactory(factoryEntity);
        ModelAndView mv = new ModelAndView();
        if (factoryList == null || factoryList.size() <= 0) {
            mv.addObject("message", "无此工厂！");
            mv.setViewName("redirect:queryFactory");
        } else {
            mv.addObject("factorys", factoryList);
            mv.setViewName("Factory_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(FactoryEntity factoryEntity) {
        boolean result = factoryService.insert(factoryEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新工厂失败！");
            mv.setViewName("redirect:queryFactory");
        } else {
            mv.addObject("message", "添加新工厂成功！");
            mv.setViewName("redirect:queryFactory");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(FactoryEntity factoryEntity) {
        boolean result = factoryService.update(factoryEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "工厂信息更新失败！");
            mv.setViewName("redirect:queryFactory");
        } else {
            mv.addObject("message", "工厂信息更新成功！");
            mv.setViewName("redirect:queryFactory");
        }
        return mv;
    }

    @RequestMapping("/setMainFac")
    public ModelAndView setMainFac(int id) {
        FactoryEntity factoryEntity = new FactoryEntity();
        factoryEntity.setId(id);
        ArrayList<FactoryEntity> factoryEntities = factoryService.queryFactory(factoryEntity);
        factoryEntity = factoryEntities.get(0);
        factoryEntity.setIs_main_factory(2);
        boolean result = factoryService.update(factoryEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "设置主工厂信息失败！");
            mv.setViewName("redirect:queryFactory");
        } else {
            mv.addObject("message", "设置主工厂信息成功！");
            mv.setViewName("redirect:queryFactory");
        }
        return mv;
    }

    @RequestMapping("/cancelSetMainFac")
    public ModelAndView cancelSetMainFac(int id) {
        FactoryEntity factoryEntity = new FactoryEntity();
        factoryEntity.setId(id);
        ArrayList<FactoryEntity> factoryEntities = factoryService.queryFactory(factoryEntity);
        factoryEntity = factoryEntities.get(0);
        factoryEntity.setIs_main_factory(3);
        boolean result = factoryService.update(factoryEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "取消主工厂信息失败！");
            mv.setViewName("redirect:queryFactory");
        } else {
            mv.addObject("message", "取消主工厂信息成功！");
            mv.setViewName("redirect:queryFactory");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = factoryService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "工厂删除失败！");
            mv.setViewName("redirect:queryFactory");
        } else {
            mv.addObject("message", "已删除此工厂！");
            mv.setViewName("redirect:queryFactory");
        }
        return mv;
    }

    @RequestMapping("/editFactory")
    public ModelAndView editFactory(int id) {
        FactoryEntity tmp = new FactoryEntity();
        tmp.setId(id);
        ArrayList<FactoryEntity> factorys = factoryService.queryFactory(tmp);
        tmp = factorys.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("factory", tmp);
        mv.setViewName("Factory_Modify");
        return mv;
    }

    @RequestMapping("/insertFactory")
    public String insertFactory() {
        return "Factory_Insert";
    }

    @RequestMapping("/ajax_queryFactory")
    @ResponseBody
    public ArrayList<FactoryEntity> ajax_queryFactory(){
        return factoryService.ajax_queryFactory();
    }

    @RequestMapping("/ajax_queryMainFactory")
    @ResponseBody
    public ArrayList<FactoryEntity> ajax_queryMainFactory(){
        return factoryService.ajax_queryMainFactory();
    }

    @RequestMapping("/ajax_queryOtherFactory")
    @ResponseBody
    public ArrayList<FactoryEntity> ajax_queryOtherFactory(){
        return factoryService.ajax_queryOtherFactory();
    }

}