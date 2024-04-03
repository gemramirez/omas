package com.omasystem.omas.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.PrincipalModel;

@Mapper
public interface PrincipalDao {
    PrincipalModel getPrincipal(String session);
}
