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
import com.mxxd.SCM.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈客户Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/queryCustomer")
    public ModelAndView queryCustomer(String name,String phone,String classify) {
        CustomerEntity tmp = new CustomerEntity();
        if(name!=null&&name!="")
            tmp.setName(name);
        if(phone!=null&&phone!="")
            tmp.setPhone(phone);
        if(classify!=null&&classify!="")
            tmp.setClassify(Integer.valueOf(classify));
        ArrayList<CustomerEntity> customers = customerService.queryCustomer(tmp);
        ModelAndView mv = new ModelAndView();
        if (customers == null || customers.size() <= 0) {
            mv.addObject("message", "无此客户！");
            mv.setViewName("redirect:queryCustomer");
        } else {
            mv.addObject("customers", customers);
            mv.setViewName("Customer_Management");
        }
        System.out.println(customers);
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(CustomerEntity customerEntity) {
        boolean result = customerService.insert(customerEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新客户失败！");
            mv.setViewName("redirect:queryCustomer");
        } else {
            mv.addObject("message", "添加新客户成功！");
            mv.setViewName("redirect:queryCustomer");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(CustomerEntity customerEntity) {
        boolean result = customerService.update(customerEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "客户信息更新失败！");
            mv.setViewName("redirect:queryCustomer");
        } else {
            mv.addObject("message", "客户信息更新成功！");
            mv.setViewName("redirect:queryCustomer");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = customerService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "客户删除失败！");
            mv.setViewName("redirect:queryCustomer");
        } else {
            mv.addObject("message", "已删除此客户！");
            mv.setViewName("redirect:queryCustomer");
        }
        return mv;
    }

    @RequestMapping("/editCustomer")
    public ModelAndView editCustomer(int id) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(id);
        ArrayList<CustomerEntity> customers = customerService.queryCustomer(customerEntity);
        ModelAndView mv = new ModelAndView();
        customerEntity = customers.get(0);
        mv.addObject("customer", customerEntity);
        mv.setViewName("Customer_Modify");
        return mv;
    }

    @RequestMapping("/insertCustomer")
    public String insertCustomer() {
        return "Customer_Insert";
    }

    @RequestMapping("/ajax_queryCustomer")
    @ResponseBody
    public ArrayList<CustomerEntity> ajax_queryCustomer(){
        return customerService.ajax_queryCustomer();
    }
}