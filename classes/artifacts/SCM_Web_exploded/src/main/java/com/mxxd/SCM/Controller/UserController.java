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

import com.mxxd.SCM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mxxd.SCM.Entity.UserEntity;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/21
 * @since 1.0.0
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(){
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(String username,String password) {
        UserEntity userEntity = userService.login(username, password);
        ModelAndView mv = new ModelAndView();
        if (userEntity == null) {
            mv.addObject("message", "用户名或密码错误，请重新输入！");
            mv.setViewName("login");
        } else {
            mv.addObject("user", userEntity);
            mv.setViewName("IntegratedPanel");
        }
        System.out.println(userEntity);
        return mv;
    }

    @RequestMapping("/queryUser")
    public ModelAndView queryUser(String username,String name,String phone) {
        UserEntity tmp = new UserEntity();
        if(username!=null&&username!="")
            tmp.setUsername(username);
        if(name!=null&&name!="")
            tmp.setName(name);
        if(phone!=null&&phone!="")
            tmp.setPhone(phone);
        ArrayList<UserEntity> users = userService.queryUser(tmp);
        ModelAndView mv = new ModelAndView();
        if (users == null || users.size() <= 0) {
            mv.addObject("message", "无此用户！");
            mv.setViewName("redirect:queryUser");
        } else {
            mv.addObject("users", users);
            mv.setViewName("User_Management");
        }
        System.out.println(users);
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(UserEntity user) {
        boolean result = userService.insert(user);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新用户失败！");
            mv.setViewName("redirect:queryUser");
        } else {
            mv.addObject("message", "添加新用户成功！");
            mv.setViewName("redirect:queryUser");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(UserEntity user) {
        boolean result = userService.update(user);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "用户信息更新失败！");
            mv.setViewName("redirect:queryUser");
        } else {
            mv.addObject("message", "用户信息更新成功！");
            mv.setViewName("redirect:queryUser");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        boolean result = userService.delete(id);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "用户删除失败！");
            mv.setViewName("redirect:queryUser");
        } else {
            mv.addObject("message", "已删除此用户！");
            mv.setViewName("redirect:queryUser");
        }
        return mv;
    }

    @RequestMapping("/editUser")
    public ModelAndView editUser(int id) {
        UserEntity tmp = new UserEntity();
        tmp.setId(id);
        ArrayList<UserEntity> users = userService.queryUser(tmp);
        tmp = users.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", tmp);
        mv.setViewName("User_Modify");
        return mv;
    }

    @RequestMapping("/insertUser")
    public String insertUser() {
        return "User_Insert";
    }
}