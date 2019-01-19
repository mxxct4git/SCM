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
import com.mxxd.SCM.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/queryProduct")
    public ModelAndView queryProduct(String main_code,String code,String name,String factory_id){
        ProductEntity productEntity = new ProductEntity();
        if(name!=null&&name!="")
            productEntity.setName(name);
        if(main_code!=null&&main_code!="")
            productEntity.setMain_code(main_code);
        if(code!=null&&code!="")
            productEntity.setCode(code);
        if(factory_id!=null&&factory_id!="")
            productEntity.setFactory_id(Integer.valueOf(factory_id));
        ArrayList<ProductEntity> productList = productService.queryProduct(productEntity);
        ModelAndView mv = new ModelAndView();
        if (productList == null || productList.size() <= 0) {
            mv.addObject("message", "无此商品！");
            mv.setViewName("redirect:queryProduct");
        } else {
            mv.addObject("products", productList);
            mv.setViewName("Product_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(ProductEntity productEntity) {
        boolean result = productService.insert(productEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新商品失败！");
            mv.setViewName("redirect:queryProduct");
        } else {
            mv.addObject("message", "添加新商品成功！");
            mv.setViewName("redirect:queryProduct");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(ProductEntity productEntity) {
        boolean result = productService.update(productEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "商品信息更新失败！");
            mv.setViewName("redirect:queryProduct");
        } else {
            mv.addObject("message", "商品信息更新成功！");
            mv.setViewName("redirect:queryProduct");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = productService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "商品删除失败！");
            mv.setViewName("redirect:queryProduct");
        } else {
            mv.addObject("message", "已删除此商品！");
            mv.setViewName("redirect:queryProduct");
        }
        return mv;
    }

    @RequestMapping("/editProduct")
    public ModelAndView editProduct(int id) {
        ProductEntity tmp = new ProductEntity();
        tmp.setId(id);
        ArrayList<ProductEntity> products = productService.queryProduct(tmp);
        tmp = products.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", tmp);
        mv.setViewName("Product_Modify");
        return mv;
    }

    @RequestMapping("/insertProduct")
    public String insertProduct() {
        return "Product_Insert";
    }

    @RequestMapping("/queryCodes")
    public ModelAndView queryCodes(String main_code,String code,String factory_id){
        ProductEntity productEntity = new ProductEntity();
        if(main_code!=null&&main_code!="")
            productEntity.setMain_code(main_code);
        if(code!=null&&code!="")
            productEntity.setCode(code);
        if(factory_id!=null&&factory_id!="")
            productEntity.setFactory_id(Integer.valueOf(factory_id));
        ArrayList<ProductEntity> productList = productService.queryProduct(productEntity);
        ModelAndView mv = new ModelAndView();
        mv.addObject("products",productList);
        mv.setViewName("Code_Management");
        return mv;
    }

    @RequestMapping("/insert_main_code_update")
    public ModelAndView insert_main_code_update(String main_code,String code,String factory_id) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setMain_code(main_code);
        productEntity.setCode(code);
        productEntity.setFactory_id(Integer.valueOf(factory_id));
        boolean result = productService.insert_main_code_update(productEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "商品插入主编码失败！");
            mv.setViewName("redirect:queryCodes");
        } else {
            mv.addObject("message", "商品插入主编码成功！");
            mv.setViewName("redirect:queryCodes");
        }
        return mv;
    }

    @RequestMapping("/delete_main_code_update")
    public ModelAndView delete_main_code_update(String id) {
        boolean result = productService.delete_main_code_update(Integer.valueOf(id));
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "商品删除主编码失败！");
            mv.setViewName("redirect:queryCodes");
        } else {
            mv.addObject("message", "商品删除主编码成功！");
            mv.setViewName("redirect:queryCodes");
        }
        return mv;
    }

    @RequestMapping("/ajax_queryMainCode")
    @ResponseBody
    public ArrayList<ProductEntity> ajax_queryMainCode(String id) {
        if(id==null||id==""){
            return productService.ajax_queryMainCode();
        }else {
            return productService.ajax_queryMainCode_id(Integer.valueOf(id));
        }
    }

    @RequestMapping("/ajax_queryCodes")
    @ResponseBody
    public ArrayList<ProductEntity> ajax_queryCodes(String id) {
        if(id==null||id==""){
            return productService.ajax_queryCodes();
        }else {
            return productService.ajax_queryCodes_id(Integer.valueOf(id));
        }
    }

    @RequestMapping("/ajax_queryCodes_MCode")
    @ResponseBody
    public ArrayList<ProductEntity> ajax_queryCodes_MCode(String main_code) {
        if(main_code==null||main_code==""){
            return productService.ajax_queryCodes();
        }else {
            return productService.ajax_queryCodes_MCode(main_code);
        }
    }
}