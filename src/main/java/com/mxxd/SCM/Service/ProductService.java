/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserService
 * Author:   猫熊小才天
 * Date:     2018/10/22 8:53
 * Description: 用户Service类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Service;

import com.mxxd.SCM.Dao.ProductMapper;
import com.mxxd.SCM.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/22
 * @since 1.0.0
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public ArrayList<ProductEntity> queryProduct(ProductEntity productEntity){
        ArrayList<ProductEntity> products = productMapper.queryProduct(productEntity);
        return products;
    }

    public boolean insert(ProductEntity productEntity){
        boolean result = productMapper.insert(productEntity);
        return result;
    }

    public boolean update(ProductEntity productEntity){
        boolean result = productMapper.update(productEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = productMapper.delete(id);
        return result;
    }

    public ArrayList<ProductEntity> queryCodes(ProductEntity productEntity){
        ArrayList<ProductEntity> products = productMapper.queryCodes(productEntity);
        return products;
    }

    public boolean insert_main_code_update(ProductEntity productEntity){
        boolean result = productMapper.insert_main_code_update(productEntity);
        return result;
    }

    public boolean delete_main_code_update(int id){
        boolean result = productMapper.delete_main_code_update(id);
        return result;
    }

    public ArrayList<ProductEntity> ajax_queryMainCode(){
        ArrayList<ProductEntity> products = productMapper.ajax_queryMainCode();
        return products;
    }

    public ArrayList<ProductEntity> ajax_queryMainCode_id(int id){
        ArrayList<ProductEntity> products = productMapper.ajax_queryMainCode_id(id);
        return products;
    }

    public ArrayList<ProductEntity> ajax_queryCodes(){
        ArrayList<ProductEntity> products = productMapper.ajax_queryCodes();
        return products;
    }

    public ArrayList<ProductEntity> ajax_queryCodes_id(int id){
        ArrayList<ProductEntity> products = productMapper.ajax_queryCodes_id(id);
        return products;
    }

    public ArrayList<ProductEntity> ajax_queryCodes_MCode(String main_code){
        ArrayList<ProductEntity> products = productMapper.ajax_queryCodes_MCode(main_code);
        return products;
    }
}