package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.FactoryEntity;
import com.mxxd.SCM.Entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductMapper {

    public ArrayList<ProductEntity> queryProduct(ProductEntity productEntity);

    public boolean insert(ProductEntity productEntity);

    public boolean update(ProductEntity productEntity);

    public boolean delete(int id);

    public ArrayList<ProductEntity> queryCodes(ProductEntity productEntity);

    public boolean insert_main_code_update(ProductEntity productEntity);

    public boolean delete_main_code_update(int id);

    public ArrayList<ProductEntity> ajax_queryMainCode();

    public ArrayList<ProductEntity> ajax_queryMainCode_id(int id);

    public ArrayList<ProductEntity> ajax_queryCodes();

    public ArrayList<ProductEntity> ajax_queryCodes_id(int id);

    public ArrayList<ProductEntity> ajax_queryCodes_MCode(String main_code);

}
