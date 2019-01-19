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

import com.mxxd.SCM.Dao.CustomerMapper;
import com.mxxd.SCM.Dao.UserMapper;
import com.mxxd.SCM.Entity.CustomerEntity;
import com.mxxd.SCM.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈客户Service类〉
 *
 * @author 猫熊小才天
 * @create 2018/10/23
 * @since 1.0.0
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public ArrayList<CustomerEntity> queryCustomer(CustomerEntity customerEntity){
        ArrayList<CustomerEntity> customers = customerMapper.queryCustomer(customerEntity);
        return customers;
    }

    public boolean insert(CustomerEntity customerEntity){
        boolean result = customerMapper.insert(customerEntity);
        return result;
    }

    public boolean update(CustomerEntity customerEntity){
        boolean result = customerMapper.update(customerEntity);
        return result;
    }

    public boolean delete(int id){
        boolean result = customerMapper.delete(id);
        return result;
    }

    public ArrayList<CustomerEntity> ajax_queryCustomer(){
        ArrayList<CustomerEntity> customers = customerMapper.ajax_queryCustomer();
        return customers;
    }

}