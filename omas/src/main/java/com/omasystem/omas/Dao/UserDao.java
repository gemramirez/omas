package com.omasystem.omas.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.UserModel;

@Mapper
public interface UserDao {
    UserModel getPrincipal(String session);
}
