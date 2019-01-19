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
import com.mxxd.SCM.Entity.RepositoryEntity;
import com.mxxd.SCM.Entity.StorageEntity;
import com.mxxd.SCM.Service.InListService;
import com.mxxd.SCM.Service.StorageService;
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
import java.util.Enumeration;

/**
 * 〈一句话功能简述〉<br>
 * 〈入库Controller〉
 *
 * @author 猫熊小才天
 * @create 2018/10/25
 * @since 1.0.0
 */
@Controller
@SessionAttributes("inList")
@RequestMapping("/inList")
public class InListController {

    @Autowired
    private InListService inListService;

    @Autowired
    private StorageService storageService;

    @RequestMapping("/queryInList")
    public ModelAndView queryInList(String in_timestamp,String factory_id, String repository_id, String product_main_code, String product_code, String in_date, String is_callback) {
        InListEntity inListEntity = new InListEntity();
        if (in_timestamp != null && in_timestamp != "")
            inListEntity.setIn_timestamp(in_timestamp);
        if (factory_id != null && factory_id != "" && !factory_id.equals('0'))
            inListEntity.setFactory_id(Integer.valueOf(factory_id));
        if (repository_id != null && repository_id != "" && !repository_id.equals('0'))
            inListEntity.setRepository_id(Integer.valueOf(repository_id));
        if (product_main_code != null && product_main_code != "")
            inListEntity.setProduct_main_code(product_main_code);
        if (product_code != null && product_code != "")
            inListEntity.setProduct_code(product_code);
        if (in_date != null && in_date != "")
            inListEntity.setIn_date(in_date);
        if (is_callback != null && is_callback != "" && !is_callback.equals('0'))
            inListEntity.setIs_callback(Integer.valueOf(is_callback));
        ArrayList<InListEntity> inLists = inListService.queryInList(inListEntity);
        ModelAndView mv = new ModelAndView();
        if (inLists == null || inLists.size() <= 0) {
            mv.addObject("message", "无此入库记录！");
            mv.setViewName("redirect:queryInList");
        } else {
            mv.addObject("inLists", inLists);
            mv.setViewName("InList_Management");
        }
        return mv;
    }

    /*
    * 插入入库表，同时需要插入成本表、库存表、流水表
    * */
    @RequestMapping("/insert")
    public ModelAndView insert(InListEntity inListEntity) {
        inListEntity.setIs_callback(2);
        boolean result = false;
        AttachedFunc attachedFunc = new AttachedFunc();
        // 插入库存表
        attachedFunc.inList_Update_Storage_part2(inListEntity);

        // 插入成本表
        attachedFunc.inList_Insert_Cost(inListEntity);

        // 插入流水表
        attachedFunc.inList_Insert_WaterList(inListEntity);

        // 插入入库表
        result = inListService.insert(inListEntity);

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "添加新入库失败！");
            mv.setViewName("redirect:queryInList");
        } else {
            mv.addObject("message", "添加新入库成功！");
            mv.setViewName("redirect:queryInList");
        }
        return mv;
    }

    /*
     * 0.同步更新入库表
     * 1.修改码数 ==> 修改库存表&成本表
     * 2.修改单价 ==> 修改成本表
     * 3.修改工厂/仓库 ==> 修改流水表&库存表
     * 4.修改商品详情 ==> 修改流水表&库存表
     * 5.修改入库时间 ==> 修改入库表&成本表
     *
     * */
    @RequestMapping("/update")
    public ModelAndView update(InListEntity inListEntity, HttpServletRequest request) {
        HttpSession session = request.getSession();
        InListEntity history_inList = (InListEntity) session.getAttribute("inList");
        System.out.println("########");
        System.out.println(history_inList);
        System.out.println(inListEntity);

        boolean result = false;
        AttachedFunc attachedFunc = new AttachedFunc();
        // 更新库存表
        attachedFunc.inList_Update_Storage_part1(history_inList);
        attachedFunc.inList_Update_Storage_part2(inListEntity);
        // 更新成本表
        attachedFunc.inList_Update_Cost(inListEntity);
        // 更新流水表
        attachedFunc.inList_Update_WaterList(inListEntity);
        // 更新入库表
        result = inListService.update(inListEntity);

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "入库信息更新失败！");
            mv.setViewName("redirect:queryInList");
        } else {
            mv.addObject("message", "入库信息更新成功！");
            mv.setViewName("redirect:queryInList");
        }
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String in_timestamp) {
        AttachedFunc attachedFunc = new AttachedFunc();
        boolean result = false;
        // 获取入库记录
        InListEntity inListEntity = new InListEntity();
        inListEntity.setIn_timestamp(in_timestamp);
        ArrayList<InListEntity> inLists = inListService.queryInList(inListEntity);
        inListEntity = inLists.get(0);

        // 删除成本表
        attachedFunc.inList_Delete_Cost(in_timestamp);

        // 删除流水表
        attachedFunc.inList_Delete_WaterList(in_timestamp);

        // 删除库存表
        attachedFunc.inList_Update_Storage_part1(inListEntity);

        // 删除入库表
        result = inListService.delete(inListEntity.getId());

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "入库删除失败！");
            mv.setViewName("redirect:queryInList");
        } else {
            mv.addObject("message", "已删除此入库！");
            mv.setViewName("redirect:queryInList");
        }
        return mv;
    }

    @RequestMapping("/detailInList")
    public ModelAndView detailInList(int id) {
        InListEntity tmp = new InListEntity();
        tmp.setId(id);
        ArrayList<InListEntity> inLists = inListService.queryInList(tmp);
        tmp = inLists.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("inList", tmp);
        mv.setViewName("InList_Detail");
        return mv;
    }

    @RequestMapping("/editInList")
    public ModelAndView editInList(int id) {
        InListEntity tmp = new InListEntity();
        tmp.setId(id);
        ArrayList<InListEntity> inLists = inListService.queryInList(tmp);
        tmp = inLists.get(0);
        ModelAndView mv = new ModelAndView();
        mv.addObject("inList", tmp);
        mv.setViewName("InList_Modify");
        return mv;
    }

    @RequestMapping("/insertInList")
    public ModelAndView insertInList() {
        ModelAndView mv = new ModelAndView();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        mv.addObject("timeStamp", timeStamp);
        mv.setViewName("InList_Insert");
        return mv;
    }

    @RequestMapping("/callback")
    public ModelAndView callback(int id) {
        InListEntity tmp = new InListEntity();
        tmp.setId(id);
        ArrayList<InListEntity> inLists = inListService.queryInList(tmp);
        tmp = inLists.get(0);
        tmp.setIs_callback(1);
        boolean result = inListService.update(tmp);

        AttachedFunc attachedFunc = new AttachedFunc();

        // 删除成本表
        attachedFunc.inList_Delete_Cost(tmp.getIn_timestamp());

        // 删除流水表
        attachedFunc.inList_Delete_WaterList(tmp.getIn_timestamp());

        // 删除库存表
        attachedFunc.inList_Update_Storage_part1(tmp);

        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "退货失败！");
            mv.setViewName("redirect:queryInList");
        } else {
            mv.addObject("message", "退货成功！");
            mv.setViewName("redirect:queryInList");
        }
        return mv;
    }

    @RequestMapping("/uncallback")
    public ModelAndView uncallback(int id) {
        InListEntity tmp = new InListEntity();
        tmp.setId(id);
        ArrayList<InListEntity> inLists = inListService.queryInList(tmp);
        tmp = inLists.get(0);
        tmp.setIs_callback(2);
        boolean result = inListService.update(tmp);
        ModelAndView mv = new ModelAndView();
        if (result == false) {
            mv.addObject("message", "取消退货失败！");
            mv.setViewName("redirect:queryInList");
        } else {
            mv.addObject("message", "取消退货成功！");
            mv.setViewName("redirect:queryInList");
        }
        return mv;
    }

    @RequestMapping("/today_inList")
    @ResponseBody
    public int today_inList(){
        CalendarTime cTime = new CalendarTime();
        String in_date = cTime.getTodayTime();
        return inListService.today_inList(in_date);
    }
}