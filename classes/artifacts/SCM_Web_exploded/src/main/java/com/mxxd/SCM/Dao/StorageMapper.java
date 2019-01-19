package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.StorageEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StorageMapper {

    public ArrayList<StorageEntity> queryStorage(StorageEntity storageEntity);

    public boolean insert(StorageEntity storageEntity);

    public boolean update(StorageEntity storageEntity);

    public boolean delete(int id);

}
