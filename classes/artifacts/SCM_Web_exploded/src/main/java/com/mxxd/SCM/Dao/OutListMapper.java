package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.OutListEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OutListMapper {

    public ArrayList<OutListEntity> queryOutList(OutListEntity outListEntity);

    public boolean insert(OutListEntity outListEntity);

    public boolean update(OutListEntity outListEntity);

    public boolean delete(int id);

    public int today_outList(String out_date);

}
