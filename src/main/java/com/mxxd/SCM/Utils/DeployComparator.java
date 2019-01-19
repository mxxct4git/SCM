/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DeployComparator
 * Author:   猫熊小才天
 * Date:     2018/11/10 16:22
 * Description: 调配记录类的排序器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mxxd.SCM.Utils;

import com.mxxd.SCM.Entity.DeployEntity;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈调配记录类的排序器〉
 *
 * @author 猫熊小才天
 * @create 2018/11/10
 * @since 1.0.0
 */
public class DeployComparator implements Comparator<DeployEntity> {
    @Override
    public int compare(DeployEntity s1, DeployEntity s2) {

        if(s1.getId() > s2.getId()){
            return 1;
        }else {
            return -1;
        }
    }
}