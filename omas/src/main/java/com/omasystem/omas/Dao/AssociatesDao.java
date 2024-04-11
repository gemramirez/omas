package com.omasystem.omas.Dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssociatesDao {

    //GET ALL ASSOCIATES
    Long getTotalAssociates();
    //GET ALL ASSIGNED SEATS
    Long getTotalAssignedSeats();
    //GET ALL UNSIGNED SEATS
    Integer getTotalUnassignedSeats();
}