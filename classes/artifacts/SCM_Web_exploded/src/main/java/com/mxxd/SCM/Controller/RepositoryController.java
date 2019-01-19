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

import com.mxxd.SCM.Entity.ProductEntity;
import com.mxxd.SCM.Entity.RepositoryEntity;
import com.mxxd.SCM.Service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈仓库Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Controller
@RequestMapping("/repository")
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/queryRepository")
    public ModelAndView queryRepository(String name,String manager,String manager_phone,String factory_id){
        RepositoryEntity repositoryEntity =  new RepositoryEntity();
        if(name!=null&&name!="")
            repositoryEntity.setName(name);
        if(manager!=null&&manager!="")
            repositoryEntity.setManager(manager);
        if(manager_phone!=null&&manager_phone!="")
            repositoryEntity.setManager_phone(manager_phone);
        if(factory_id!=null&&factory_id!="")
            repositoryEntity.setFactory_id(Integer.valueOf(factory_id));
        ArrayList<RepositoryEntity> repositoryList = repositoryService.queryRepository(repositoryEntity);
        ModelAndView mv = new ModelAndView();
        if (repositoryList == null || repositoryList.size() <= 0) {
            mv.addObject("message", "无此仓库！");
            mv.setViewName("redirect:queryRepository");
        } else {
            mv.addObject("repositorys", repositoryList);
            mv.setViewName("Repository_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(RepositoryEntity repositoryEntity) {
        boolean result = repositoryService.insert(repositoryEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新仓库失败！");
            mv.setViewName("redirect:queryRepository");
        } else {
            mv.addObject("message", "添加新仓库成功！");
            mv.setViewName("redirect:queryRepository");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(RepositoryEntity repositoryEntity) {
        boolean result = repositoryService.update(repositoryEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "仓库信息更新失败！");
            mv.setViewName("redirect:queryRepository");
        } else {
            mv.addObject("message", "仓库信息更新成功！");
            mv.setViewName("redirect:queryRepository");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = repositoryService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "仓库删除失败！");
            mv.setViewName("redirect:queryRepository");
        } else {
            mv.addObject("message", "已删除此仓库！");
            mv.setViewName("redirect:queryRepository");
        }
        return mv;
    }

    @RequestMapping("/editRepository")
    public ModelAndView editRepository(int id) {
        RepositoryEntity tmp = new RepositoryEntity();
        tmp.setId(id);
        ArrayList<RepositoryEntity> repositorys = repositoryService.queryRepository(tmp);
        tmp = repositorys.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("repository", tmp);
        mv.setViewName("Repository_Modify");
        return mv;
    }

    @RequestMapping("/insertRepository")
    public String insertRepository() {
        return "Repository_Insert";
    }

    @RequestMapping("/ajax_queryRepository")
    @ResponseBody
    public ArrayList<RepositoryEntity> ajax_queryRepository(String id) {
        if(id==null||id==""){
            return repositoryService.ajax_queryRepository();
        }else {
            return repositoryService.ajax_queryRepository_id(Integer.valueOf(id));
        }
    }

}