package com.omasystem.omas.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.UserProjectModel;

@Mapper
public interface UserProjectDao {
    UserProjectModel getProjectInvolvedOfUser(String emp_id);
}
