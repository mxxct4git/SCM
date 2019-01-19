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

import com.mxxd.SCM.Entity.CustomerEntity;
import com.mxxd.SCM.Entity.StorageEntity;
import com.mxxd.SCM.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈库存Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/queryStorage")
    public ModelAndView queryStorage(String factory_id,String repository_id,String product_main_code,String product_code,String quantity_lower,String quantity_upper) {
        StorageEntity storageEntity = new StorageEntity();
        if(factory_id != null && factory_id != ""){
            storageEntity.setFactory_id(Integer.valueOf(factory_id));
        }
        if(repository_id != null && repository_id != ""){
            storageEntity.setRepository_id(Integer.valueOf(repository_id));
        }
        if(product_main_code != null && product_main_code != ""){
            storageEntity.setProduct_main_code(product_main_code);
        }
        if(product_code != null && product_code != ""){
            storageEntity.setProduct_code(product_code);
        }
        if(quantity_lower != null && quantity_lower != ""){
            storageEntity.setQuantity_lower(Integer.valueOf(quantity_lower));
        }
        if(quantity_upper != null && quantity_upper != ""){
            storageEntity.setQuantity_upper(Integer.valueOf(quantity_upper));
        }
        ArrayList<StorageEntity> storages = storageService.queryStorage(storageEntity);
        ModelAndView mv = new ModelAndView();
        if (storages == null || storages.size() <= 0) {
            mv.addObject("message", "无此库存！");
            mv.setViewName("redirect:queryStorage");
        } else {
            mv.addObject("storages", storages);
            mv.setViewName("Storage_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(StorageEntity storageEntity) {
        boolean result = storageService.insert(storageEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新库存失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "添加新库存成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(StorageEntity storageEntity) {
        boolean result = storageService.update(storageEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "库存信息更新失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "库存信息更新成功！");
            mv.setViewName("");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = storageService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "库存删除失败！");
            mv.setViewName("");
        } else {
            mv.addObject("message", "已删除此库存！");
            mv.setViewName("");
        }
        return mv;
    }
}