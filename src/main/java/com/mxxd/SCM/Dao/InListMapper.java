package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.InListEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InListMapper {

    public ArrayList<InListEntity> queryInList(InListEntity inListEntity);

    public boolean insert(InListEntity inListEntity);

    public boolean update(InListEntity inListEntity);

    public boolean delete(int id);

    public int today_inList(String in_date);

}
