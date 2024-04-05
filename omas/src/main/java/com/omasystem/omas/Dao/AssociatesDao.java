package com.omasystem.omas.Dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssociatesDao {

    Long getTotalAssociates();
    Long getTotalAssignedSeats();
    Integer getTotalUnassignedSeats();
}