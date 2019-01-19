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
import com.mxxd.SCM.Service.DeployService;
import com.mxxd.SCM.Service.RepositoryService;
import com.mxxd.SCM.Service.StorageService;
import com.mxxd.SCM.Utils.AttachedFunc;
import com.mxxd.SCM.Utils.DeployComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈调配Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("/deploy")
public class DeployController {

    @Autowired
    private DeployService deployService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private StorageService storageService;

    @RequestMapping("/queryDeploy")
    public ModelAndView queryDeploy(String factory_id, String repository_id, String product_main_code, String product_code, String deploy_date, String in_out) {
        DeployEntity deployEntityIn = new DeployEntity();
        DeployEntity deployEntityOut = new DeployEntity();
        if (factory_id != null && factory_id.equals("")) {
            deployEntityIn.setAim_factory_id(Integer.valueOf(factory_id));
            deployEntityOut.setSource_factory_id(Integer.valueOf(factory_id));
        }
        if (repository_id != null && repository_id.equals("")) {
            deployEntityIn.setAim_repository_id(Integer.valueOf(repository_id));
            deployEntityOut.setSource_repository_id(Integer.valueOf(repository_id));
        }
        if (product_main_code != null && product_main_code.equals("")) {
            deployEntityIn.setAim_product_main_code(product_main_code);
            deployEntityOut.setSource_product_main_code(product_main_code);
        }
        if (product_code != null && product_code.equals("")) {
            deployEntityIn.setAim_product_code(product_code);
            deployEntityOut.setSource_product_code(product_code);
        }
        if (deploy_date != null && deploy_date.equals("")) {
            deployEntityIn.setDeploy_date(deploy_date);
            deployEntityOut.setDeploy_date(deploy_date);
        }
        ArrayList<DeployEntity> deploysIn = new ArrayList<DeployEntity>();
        ArrayList<DeployEntity> deploysOut = new ArrayList<DeployEntity>();

        List<DeployEntity> deployList = new ArrayList<DeployEntity>();
        List<Integer> tmpIn = new ArrayList<Integer>();

        if (in_out == null || in_out.equals("") || in_out.equals("全部")) {
            deploysIn = deployService.queryDeployIn(deployEntityIn);
            for (int i = 0; i < deploysIn.size(); i++) {
                deployList.add(deploysIn.get(i));
                tmpIn.add(deploysIn.get(i).getId());
            }
            deploysOut = deployService.queryDeployOut(deployEntityIn);
            for (int i = 0; i < deploysOut.size(); i++) {
                if (!tmpIn.contains(deploysOut.get(i).getId())) {
                    deployList.add(deploysOut.get(i));
                }
            }
            /*for (int i = 0; i < deployList.size(); i++) {
                System.out.println(deployList.get(i));
            }*/
            Collections.sort(deployList, new DeployComparator());
            //System.out.println("####");
            /*for (int i = 0; i < deployList.size(); i++) {
                System.out.println(deployList.get(i));
            }*/
        } else if (in_out.equals("调入")) {
            deploysIn = deployService.queryDeployIn(deployEntityIn);
            deployList.addAll(deploysIn);
        } else if (in_out.equals("调出")) {
            deploysOut = deployService.queryDeployOut(deployEntityIn);
            deployList.addAll(deploysOut);
        }

        RepositoryEntity repositoryEntity = new RepositoryEntity();
        ArrayList<RepositoryEntity> repositoryEntities = repositoryService.queryRepository(repositoryEntity);
        for (int i = 0; i < deployList.size(); i++) {
            for (int j = 0; j < repositoryEntities.size(); j++) {
                if (deployList.get(i).getSource_factory_id() == repositoryEntities.get(j).getFactory_id()) {
                    deployList.get(i).setSource_factory_name(repositoryEntities.get(j).getFactory_name());
                }
                if (deployList.get(i).getAim_factory_id() == repositoryEntities.get(j).getFactory_id()) {
                    deployList.get(i).setAim_factory_name(repositoryEntities.get(j).getFactory_name());
                }
                if (deployList.get(i).getSource_repository_id() == repositoryEntities.get(j).getId()) {
                    deployList.get(i).setSource_repository_name(repositoryEntities.get(j).getName());
                }
                if (deployList.get(i).getAim_repository_id() == repositoryEntities.get(j).getId()) {
                    deployList.get(i).setAim_repository_name(repositoryEntities.get(j).getName());
                }
            }
        }

        ModelAndView mv = new ModelAndView();
        if (deployList == null || deployList.size() <= 0) {
            mv.addObject("message", "无此调配记录");
            mv.setViewName("redirect:queryDeploy");
        } else {
            mv.addObject("deploys", deployList);
            mv.setViewName("Deploy_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(DeployEntity deployEntity) {
        // 减少原厂商品的库存
        AttachedFunc attachedFunc = new AttachedFunc();
        attachedFunc.deploy_insert_source_storage(deployEntity, "minus");

        // 增加目标工厂商品的库存
        attachedFunc.deploy_insert_aim_storage(deployEntity, "plus");

        boolean result = deployService.insert(deployEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新调配失败！");
            mv.setViewName("redirect:queryDeploy");
        } else {
            mv.addObject("message", "添加新调配成功！");
            mv.setViewName("redirect:queryDeploy");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(DeployEntity deployEntity) {
        AttachedFunc attachedFunc = new AttachedFunc();
        DeployEntity oldDeploy = new DeployEntity();
        oldDeploy.setId(deployEntity.getId());
        ArrayList<DeployEntity> oldDeploys = deployService.queryDeployIn(oldDeploy);
        oldDeploy = oldDeploys.get(0);

        // 先增加旧的原厂商品数量
        attachedFunc.deploy_insert_source_storage(oldDeploy, "plus");

        // 减少旧的目标工厂商品数量
        attachedFunc.deploy_insert_aim_storage(oldDeploy, "minus");

        // 再减少新的原厂商品数量
        attachedFunc.deploy_insert_source_storage(deployEntity, "minus");

        // 增加新的目标工厂商品数量
        attachedFunc.deploy_insert_aim_storage(deployEntity, "plus");

        boolean result = deployService.update(deployEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "调配信息更新失败！");
            mv.setViewName("redirect:queryDeploy");
        } else {
            mv.addObject("message", "调配信息更新成功！");
            mv.setViewName("redirect:queryDeploy");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        DeployEntity deployEntity = new DeployEntity();
        deployEntity.setId(id);
        ArrayList<DeployEntity> deployEntities = deployService.queryDeployIn(deployEntity);
        deployEntity = deployEntities.get(0);

        AttachedFunc attachedFunc = new AttachedFunc();

        // 减少目标工厂商品的库存
        attachedFunc.deploy_insert_aim_storage(deployEntity, "minus");

        // 增加原厂商品的库存
        attachedFunc.deploy_insert_source_storage(deployEntity, "plus");

        boolean result = deployService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "调配删除失败！");
            mv.setViewName("redirect:queryDeploy");
        } else {
            mv.addObject("message", "已删除此调配！");
            mv.setViewName("redirect:queryDeploy");
        }
        return mv;
    }

    @RequestMapping("/detailDeploy")
    public ModelAndView detailDeploy(String id) {
        DeployEntity deployEntity = new DeployEntity();
        deployEntity.setId(Integer.valueOf(id));
        ArrayList<DeployEntity> deployEntities = deployService.queryDeployIn(deployEntity);
        deployEntity = deployEntities.get(0);

        RepositoryEntity repositoryEntity = new RepositoryEntity();
        ArrayList<RepositoryEntity> repositoryEntities = repositoryService.queryRepository(repositoryEntity);
        for (int j = 0; j < repositoryEntities.size(); j++) {
            if (deployEntity.getSource_factory_id() == repositoryEntities.get(j).getFactory_id()) {
                deployEntity.setSource_factory_name(repositoryEntities.get(j).getFactory_name());
            }
            if (deployEntity.getAim_factory_id() == repositoryEntities.get(j).getFactory_id()) {
                deployEntity.setAim_factory_name(repositoryEntities.get(j).getFactory_name());
            }
            if (deployEntity.getSource_repository_id() == repositoryEntities.get(j).getId()) {
                deployEntity.setSource_repository_name(repositoryEntities.get(j).getName());
            }
            if (deployEntity.getAim_repository_id() == repositoryEntities.get(j).getId()) {
                deployEntity.setAim_repository_name(repositoryEntities.get(j).getName());
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("deploy", deployEntity);
        mv.setViewName("Deploy_Detail");
        return mv;
    }

    @RequestMapping("/insertDeploy")
    public ModelAndView insertDeploy() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Deploy_Insert");
        return mv;
    }

    @RequestMapping("/editDeploy")
    public ModelAndView editDeploy(String id) {
        DeployEntity deployEntity = new DeployEntity();
        deployEntity.setId(Integer.valueOf(id));
        ArrayList<DeployEntity> deployEntities = deployService.queryDeployIn(deployEntity);
        deployEntity = deployEntities.get(0);

        RepositoryEntity repositoryEntity = new RepositoryEntity();
        ArrayList<RepositoryEntity> repositoryEntities = repositoryService.queryRepository(repositoryEntity);
        for (int j = 0; j < repositoryEntities.size(); j++) {
            if (deployEntity.getSource_factory_id() == repositoryEntities.get(j).getFactory_id()) {
                deployEntity.setSource_factory_name(repositoryEntities.get(j).getFactory_name());
            }
            if (deployEntity.getAim_factory_id() == repositoryEntities.get(j).getFactory_id()) {
                deployEntity.setAim_factory_name(repositoryEntities.get(j).getFactory_name());
            }
            if (deployEntity.getSource_repository_id() == repositoryEntities.get(j).getId()) {
                deployEntity.setSource_repository_name(repositoryEntities.get(j).getName());
            }
            if (deployEntity.getAim_repository_id() == repositoryEntities.get(j).getId()) {
                deployEntity.setAim_repository_name(repositoryEntities.get(j).getName());
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("deploy", deployEntity);
        mv.setViewName("Deploy_Modify");
        return mv;
    }
}