/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: AttachedFunc
 * Author:   猫熊小才天
 * Date:     2018/11/1 8:50
 * Description: 出入库操作过程中的伴随函数变化
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Utils;

import com.mxxd.SCM.Entity.*;
import com.mxxd.SCM.Service.CostService;
import com.mxxd.SCM.Service.IncomeService;
import com.mxxd.SCM.Service.StorageService;
import com.mxxd.SCM.Service.WaterListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈出入库操作过程中的伴随函数变化〉
 *
 * @author 猫熊小才天
 * @create 2018/11/1
 * @since 1.0.0
 */

@Controller
public class AttachedFunc {
    @Autowired
    private StorageService storageService;
    @Autowired
    private WaterListService waterListService;
    @Autowired
    private CostService costService;
    @Autowired
    private IncomeService incomeService;

    /*
    * 更新入库表的时候更新库存表
    * 首先是将旧的库存记录更新
    * */
    public void inList_Update_Storage_part1(InListEntity history_inList){
        // 修改工厂/仓库，更新库存表
        StorageEntity old_storage = new StorageEntity();
        // 旧入库表对某个商品有一定数量 先获取旧的库存记录，将数量减去
        old_storage.setFactory_id(history_inList.getFactory_id());
        old_storage.setRepository_id(history_inList.getRepository_id());
        old_storage.setProduct_main_code(history_inList.getProduct_main_code());
        old_storage.setProduct_code(history_inList.getProduct_code());
        old_storage.setProduct_color(history_inList.getProduct_color());
        old_storage.setProduct_size(history_inList.getProduct_size());
        old_storage.setProduct_density(history_inList.getProduct_density());
        old_storage.setProduct_makou(history_inList.getProduct_makou());

        ArrayList<StorageEntity> old_storages = storageService.queryStorage(old_storage);
        old_storage = old_storages.get(0);
        old_storage.setQuantity(old_storage.getQuantity() - history_inList.getProduct_mashu());

        // 接着先更新旧的库存记录
        storageService.update(old_storage);
    }

    /*
    * 然后查询是否之前库存表里是否有记录，如果没有的话就重新插入
    * */
    public void inList_Update_Storage_part2(InListEntity inListEntity){
        // 再插入新的库存记录：先查询是否之前有记录，如果有的话就增加数量，没有的话就插入
        StorageEntity new_storage = new StorageEntity();
        new_storage.setFactory_id(inListEntity.getFactory_id());
        new_storage.setRepository_id(inListEntity.getRepository_id());
        new_storage.setProduct_main_code(inListEntity.getProduct_main_code());
        new_storage.setProduct_code(inListEntity.getProduct_code());
        new_storage.setProduct_color(inListEntity.getProduct_color());
        new_storage.setProduct_size(inListEntity.getProduct_size());
        new_storage.setProduct_density(inListEntity.getProduct_density());
        new_storage.setProduct_makou(inListEntity.getProduct_makou());
        ArrayList<StorageEntity> new_storages = storageService.queryStorage(new_storage);
        if(new_storages != null || new_storages.size() > 0){
            // 之前存在库存记录，获取之后添加新的数量
            new_storage = new_storages.get(0);
            new_storage.setQuantity(new_storage.getQuantity() + inListEntity.getProduct_mashu());
            // 再次更新库存表
            storageService.update(new_storage);
        }else {
            // 无记录 插入新的库存记录
            new_storage.setQuantity(inListEntity.getProduct_mashu());
            storageService.insert(new_storage);
        }
    }

    public void inList_Update_Cost(InListEntity inListEntity){
        // 获取旧的成本记录
        CostEntity old_cost = new CostEntity();
        old_cost.setInlist_timestamp(inListEntity.getIn_timestamp());
        ArrayList<CostEntity> costs = costService.queryCost(old_cost);
        old_cost = costs.get(0);

        // 更新成本合计
        old_cost.setCost_total(inListEntity.getTotal_price());
        costService.update(old_cost);
    }

    public void inList_Update_WaterList(InListEntity inListEntity){
        // 获取旧的流水单记录
        WaterListEntity old_waterList = new WaterListEntity();
        old_waterList.setIn_or_out_timestamp(inListEntity.getIn_timestamp());
        ArrayList<WaterListEntity> waterListEntities = waterListService.queryWaterList(old_waterList);
        old_waterList = waterListEntities.get(0);

        // 更新流水单记录
        old_waterList.setFactory_id(inListEntity.getFactory_id());
        old_waterList.setRepository_id(inListEntity.getRepository_id());
        old_waterList.setProduct_main_code(inListEntity.getProduct_main_code());
        old_waterList.setProduct_code(inListEntity.getProduct_code());
        old_waterList.setIn_or_out(1);
        old_waterList.setIn_or_out_timestamp(inListEntity.getIn_timestamp());
        old_waterList.setIn_or_out_date(inListEntity.getIn_date());
        waterListService.update(old_waterList);
    }

    public void inList_Insert_Cost(InListEntity inListEntity){
        CostEntity cost = new CostEntity();
        cost.setInlist_timestamp(inListEntity.getIn_timestamp());
        cost.setIn_date(inListEntity.getIn_date());
        cost.setCost_total(inListEntity.getTotal_price());
        cost.setIs_cost_complete(2);// 未完成支付标志
        // 插入成本表
        costService.insert(cost);
    }

    public void inList_Insert_WaterList(InListEntity inListEntity){
        WaterListEntity waterList = new WaterListEntity();
        waterList.setIn_or_out(1);// 进货标识
        waterList.setIn_or_out_timestamp(inListEntity.getIn_timestamp());
        waterList.setFactory_id(inListEntity.getFactory_id());
        waterList.setRepository_id(inListEntity.getRepository_id());
        waterList.setProduct_main_code(inListEntity.getProduct_main_code());
        waterList.setProduct_code(inListEntity.getProduct_code());
        waterList.setIn_or_out_date(inListEntity.getIn_date());
        // 插入流水表
        waterListService.insert(waterList);
    }

    public void inList_Delete_Cost(String in_timestamp){
        costService.deleteByTime(in_timestamp);
    }

    public void inList_Delete_WaterList(String in_timestamp){
        waterListService.deleteByTime(in_timestamp);
    }

    public void outList_Update_Storage_part1(OutListEntity history_outList){
        // 修改工厂/仓库，更新库存表
        StorageEntity old_storage = new StorageEntity();
        // 旧入库表对某个商品有一定数量 先获取旧的库存记录，将数量加上
        old_storage.setFactory_id(history_outList.getFactory_id());
        old_storage.setRepository_id(history_outList.getRepository_id());
        old_storage.setProduct_main_code(history_outList.getProduct_main_code());
        old_storage.setProduct_code(history_outList.getProduct_code());
        old_storage.setProduct_color(history_outList.getProduct_color());
        old_storage.setProduct_size(history_outList.getProduct_size());
        old_storage.setProduct_density(history_outList.getProduct_density());
        old_storage.setProduct_makou(history_outList.getProduct_makou());

        ArrayList<StorageEntity> old_storages = storageService.queryStorage(old_storage);
        old_storage = old_storages.get(0);
        old_storage.setQuantity(old_storage.getQuantity() + history_outList.getProduct_mashu());

        // 接着先更新旧的库存记录
        storageService.update(old_storage);
    }

    public void outList_Update_Storage_part2(OutListEntity outList){
        // 更新库存表
        StorageEntity new_storage = new StorageEntity();
        new_storage.setFactory_id(outList.getFactory_id());
        new_storage.setRepository_id(outList.getRepository_id());
        new_storage.setProduct_main_code(outList.getProduct_main_code());
        new_storage.setProduct_code(outList.getProduct_code());
        new_storage.setProduct_color(outList.getProduct_color());
        new_storage.setProduct_size(outList.getProduct_size());
        new_storage.setProduct_density(outList.getProduct_density());
        new_storage.setProduct_makou(outList.getProduct_makou());
        ArrayList<StorageEntity> new_storages = storageService.queryStorage(new_storage);
        new_storage = new_storages.get(0);
        new_storage.setQuantity(new_storage.getQuantity() - outList.getProduct_mashu());
        storageService.update(new_storage);
    }

    public void outList_Update_Income(OutListEntity outListEntity){
        // 获取旧的收入记录
        IncomeEntity old_income = new IncomeEntity();
        old_income.setOutlist_timestamp(outListEntity.getOut_timestamp());
        ArrayList<IncomeEntity> incomes = incomeService.queryIncome(old_income);
        old_income = incomes.get(0);

        // 更新收入合计
        old_income.setIncome_total(outListEntity.getTotal_price());
        incomeService.update(old_income);
    }

    public void outList_Update_WaterList(OutListEntity outListEntity){
        // 获取旧的流水单记录
        WaterListEntity old_waterList = new WaterListEntity();
        old_waterList.setIn_or_out_timestamp(outListEntity.getOut_timestamp());
        ArrayList<WaterListEntity> waterListEntities = waterListService.queryWaterList(old_waterList);
        old_waterList = waterListEntities.get(0);

        // 更新流水单记录
        old_waterList.setFactory_id(outListEntity.getFactory_id());
        old_waterList.setRepository_id(outListEntity.getRepository_id());
        old_waterList.setProduct_main_code(outListEntity.getProduct_main_code());
        old_waterList.setProduct_code(outListEntity.getProduct_code());
        old_waterList.setIn_or_out(2);
        old_waterList.setIn_or_out_timestamp(outListEntity.getOut_timestamp());
        old_waterList.setIn_or_out_date(outListEntity.getOut_date());
        waterListService.update(old_waterList);
    }

    public void outList_Insert_Income(OutListEntity outListEntity){
        IncomeEntity income = new IncomeEntity();
        income.setOutlist_timestamp(outListEntity.getOut_timestamp());
        income.setOut_date(outListEntity.getOut_date());
        income.setIncome_total(outListEntity.getTotal_price());
        income.setIs_income_complete(2);// 未完成支付标志
        // 插入收入表
        incomeService.insert(income);
    }

    public void outList_Insert_WaterList(OutListEntity outListEntity){
        WaterListEntity waterList = new WaterListEntity();
        waterList.setIn_or_out(2);// 出货标识
        waterList.setIn_or_out_timestamp(outListEntity.getOut_timestamp());
        waterList.setFactory_id(outListEntity.getFactory_id());
        waterList.setRepository_id(outListEntity.getRepository_id());
        waterList.setProduct_main_code(outListEntity.getProduct_main_code());
        waterList.setProduct_code(outListEntity.getProduct_code());
        waterList.setIn_or_out_date(outListEntity.getOut_date());
        // 插入流水表
        waterListService.insert(waterList);
    }

    public void outList_Delete_Income(String out_timestamp){
        incomeService.deleteByTime(out_timestamp);
    }

    public void deploy_insert_source_storage(DeployEntity deployEntity,String math){
        StorageEntity storageEntity  = new StorageEntity();
        storageEntity.setFactory_id(deployEntity.getSource_factory_id());
        storageEntity.setRepository_id(deployEntity.getSource_repository_id());
        storageEntity.setProduct_main_code(deployEntity.getSource_product_main_code());
        storageEntity.setProduct_code(deployEntity.getSource_product_code());
        storageEntity.setProduct_color(deployEntity.getProduct_color());
        storageEntity.setProduct_size(deployEntity.getProduct_size());
        storageEntity.setProduct_density(deployEntity.getProduct_density());
        storageEntity.setProduct_makou(deployEntity.getProduct_makou());
        ArrayList<StorageEntity> storages = storageService.queryStorage(storageEntity);
        storageEntity = storages.get(0);
        if(math.equals("minus")){
            storageEntity.setQuantity(storageEntity.getQuantity() - deployEntity.getDeploy_quantity());
        }else if(math.equals("plus")){
            storageEntity.setQuantity(storageEntity.getQuantity() + deployEntity.getDeploy_quantity());
        }

        storageService.update(storageEntity);
    }

    public void deploy_insert_aim_storage(DeployEntity deployEntity,String math){
        StorageEntity storageEntity2  = new StorageEntity();
        storageEntity2.setFactory_id(deployEntity.getAim_factory_id());
        storageEntity2.setRepository_id(deployEntity.getAim_repository_id());
        storageEntity2.setProduct_main_code(deployEntity.getAim_product_main_code());
        storageEntity2.setProduct_code(deployEntity.getAim_product_code());
        storageEntity2.setProduct_color(deployEntity.getProduct_color());
        storageEntity2.setProduct_size(deployEntity.getProduct_size());
        storageEntity2.setProduct_density(deployEntity.getProduct_density());
        storageEntity2.setProduct_makou(deployEntity.getProduct_makou());
        ArrayList<StorageEntity> storages2 = storageService.queryStorage(storageEntity2);
        if(math.equals("plus")){
            if(storages2 == null || storages2.size() < 1){
                storageEntity2.setQuantity(deployEntity.getDeploy_quantity());
                storageService.insert(storageEntity2);
            }
            else {
                storageEntity2 = storages2.get(0);
                storageEntity2.setQuantity(storageEntity2.getQuantity() + deployEntity.getDeploy_quantity());
                storageService.update(storageEntity2);
            }
        }else if(math.equals("minus")){
            storageEntity2 = storages2.get(0);
            storageEntity2.setQuantity(storageEntity2.getQuantity() - deployEntity.getDeploy_quantity());
            storageService.update(storageEntity2);
        }

    }


}