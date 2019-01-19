package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.WaterListEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WaterListMapper {

    public ArrayList<WaterListEntity> queryWaterList(WaterListEntity waterListEntity);

    public boolean insert(WaterListEntity waterListEntity);

    public boolean update(WaterListEntity waterListEntity);

    public boolean delete(int id);

    public boolean deleteByTime(String in_or_out_timestamp);

}
