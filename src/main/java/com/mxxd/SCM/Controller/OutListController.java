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

import com.mxxd.SCM.Entity.InListEntity;
import com.mxxd.SCM.Entity.OutListEntity;
import com.mxxd.SCM.Service.OutListService;
import com.mxxd.SCM.Utils.AttachedFunc;
import com.mxxd.SCM.Utils.CalendarTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈出库Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Controller
@SessionAttributes("outList")
@RequestMapping("/outList")
public class OutListController {

    @Autowired
    private OutListService outListService;

    @RequestMapping("/queryOutList")
    public ModelAndView queryOutList(String out_timestamp,String customer_id,String factory_id, String repository_id, String product_main_code, String product_code, String out_date, String is_callback) {
        OutListEntity outListEntity = new OutListEntity();
        if(out_timestamp!=null && out_timestamp!=""){
            outListEntity.setOut_timestamp(out_timestamp);
        }
        if(customer_id!=null && customer_id!=""){
            outListEntity.setCustomer_id(Integer.valueOf(customer_id));
        }
        if(factory_id!=null && factory_id!=""){
            outListEntity.setFactory_id(Integer.valueOf(factory_id));
        }
        if(repository_id!=null && repository_id!=""){
            outListEntity.setRepository_id(Integer.valueOf(repository_id));
        }
        if(product_main_code!=null && product_main_code!=""){
            outListEntity.setProduct_main_code(product_main_code);
        }
        if(product_code!=null && product_code!=""){
            outListEntity.setProduct_code(product_code);
        }
        if(out_date!=null && out_date!=""){
            outListEntity.setOut_date(out_date);
        }if(is_callback!=null && is_callback!=""){
            outListEntity.setIs_callback(Integer.valueOf(is_callback));
        }
        ArrayList<OutListEntity> outLists = outListService.queryOutList(outListEntity);
        ModelAndView mv = new ModelAndView();
        if (outLists == null || outLists.size() <= 0) {
            mv.addObject("message", "无此出库记录！");
            mv.setViewName("redirect:queryOutList");
        } else {
            mv.addObject("outLists", outLists);
            mv.setViewName("OutList_Management");
        }
        return mv;
    }

    @RequestMapping("/insert")
    public ModelAndView insert(OutListEntity outListEntity) {
        outListEntity.setIs_callback(2);
        boolean result = false;
        AttachedFunc attachedFunc = new AttachedFunc();

        // 插入库存表
        attachedFunc.outList_Update_Storage_part2(outListEntity);

        // 插入收入表
        attachedFunc.outList_Insert_Income(outListEntity);

        // 插入流水表
        attachedFunc.outList_Insert_WaterList(outListEntity);

        result = outListService.insert(outListEntity);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新出库失败！");
            mv.setViewName("redirect:queryOutList");
        } else {
            mv.addObject("message", "添加新出库成功！");
            mv.setViewName("redirect:queryOutList");
        }
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView update(OutListEntity outListEntity, HttpServletRequest request) {
        HttpSession session = request.getSession();
        OutListEntity history_outList = (OutListEntity)session.getAttribute("outList");

        boolean result = false;
        AttachedFunc attachedFunc = new AttachedFunc();
        // 更新库存表
        attachedFunc.outList_Update_Storage_part1(history_outList);
        attachedFunc.outList_Update_Storage_part2(outListEntity);

        // 更新收入表
        attachedFunc.outList_Update_Income(outListEntity);

        // 更新流水表
        attachedFunc.outList_Update_WaterList(outListEntity);

        // 更新出库表
        result = outListService.update(outListEntity);

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "出库信息更新失败！");
            mv.setViewName("redirect:queryOutList");
        } else {
            mv.addObject("message", "出库信息更新成功！");
            mv.setViewName("redirect:queryOutList");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String out_timestamp) {
        AttachedFunc attachedFunc = new AttachedFunc();
        boolean result = false;

        // 获取出库记录
        OutListEntity outListEntity = new OutListEntity();
        outListEntity.setOut_timestamp(out_timestamp);
        ArrayList<OutListEntity> outListEntities = outListService.queryOutList(outListEntity);
        outListEntity = outListEntities.get(0);

        // 删除收入表
        attachedFunc.outList_Delete_Income(out_timestamp);

        // 删除流水表
        attachedFunc.inList_Delete_WaterList(out_timestamp);

        // 删除库存表
        attachedFunc.outList_Update_Storage_part1(outListEntity);

        // 删除收入表
        result = outListService.delete(outListEntity.getId());

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "出库删除失败！");
            mv.setViewName("redirect:queryOutList");
        } else {
            mv.addObject("message", "已删除此出库！");
            mv.setViewName("redirect:queryOutList");
        }
        return mv;
    }

    @RequestMapping("/detailOutList")
    public ModelAndView detailOutList(int id) {
        OutListEntity tmp = new OutListEntity();
        tmp.setId(id);
        ArrayList<OutListEntity> outLists = outListService.queryOutList(tmp);
        tmp = outLists.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("outList", tmp);
        mv.setViewName("OutList_Detail");
        return mv;
    }

    @RequestMapping("/editOutList")
    public ModelAndView editOutList(int id) {
        OutListEntity tmp = new OutListEntity();
        tmp.setId(id);
        ArrayList<OutListEntity> outLists = outListService.queryOutList(tmp);
        tmp = outLists.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("outList", tmp);
        mv.setViewName("OutList_Modify");
        return mv;
    }

    @RequestMapping("/insertOutList")
    public ModelAndView insertOutList() {
        ModelAndView mv = new ModelAndView();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        mv.addObject("timeStamp", timeStamp);
        mv.setViewName("OutList_Insert");
        return mv;
    }

    @RequestMapping("/callback")
    public ModelAndView callback(int id) {
        OutListEntity tmp = new OutListEntity();
        tmp.setId(id);
        ArrayList<OutListEntity> outLists = outListService.queryOutList(tmp);
        tmp = outLists.get(0);
        tmp.setIs_callback(1);
        boolean result = outListService.update(tmp);

        AttachedFunc attachedFunc = new AttachedFunc();

        // 删除收入表
        attachedFunc.outList_Delete_Income(tmp.getOut_timestamp());

        // 删除流水表
        attachedFunc.inList_Delete_WaterList(tmp.getOut_timestamp());

        // 删除库存表
        attachedFunc.outList_Update_Storage_part1(tmp);

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "退货失败！");
            mv.setViewName("redirect:queryOutList");
        } else {
            mv.addObject("message", "退货成功！");
            mv.setViewName("redirect:queryOutList");
        }
        return mv;
    }

    @RequestMapping("/today_outList")
    @ResponseBody
    public int today_outList(){
        CalendarTime cTime = new CalendarTime();
        String out_date = cTime.getTodayTime();
        return outListService.today_outList(out_date);
    }
}