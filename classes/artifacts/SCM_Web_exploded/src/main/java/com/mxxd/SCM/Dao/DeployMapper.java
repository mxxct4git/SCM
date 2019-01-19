package com.mxxd.SCM.Dao;

import com.mxxd.SCM.Entity.DeployEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DeployMapper {

    public ArrayList<DeployEntity> queryDeployIn(DeployEntity deployEntity);

    public ArrayList<DeployEntity> queryDeployOut(DeployEntity deployEntity);

    public boolean insert(DeployEntity deployEntity);

    public boolean update(DeployEntity deployEntity);

    public boolean delete(int id);

}
