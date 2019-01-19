package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.RepositoryEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositoryMapper {

    public ArrayList<RepositoryEntity> queryRepository(RepositoryEntity repositoryEntity);

    public boolean insert(RepositoryEntity repositoryEntity);

    public boolean update(RepositoryEntity repositoryEntity);

    public boolean delete(int id);

    public ArrayList<RepositoryEntity> ajax_queryRepository();

    public ArrayList<RepositoryEntity> ajax_queryRepository_id(int id);

}
