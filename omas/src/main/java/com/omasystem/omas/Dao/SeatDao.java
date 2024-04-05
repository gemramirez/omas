package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.SeatModel;

@Mapper
public interface SeatDao {

    List<SeatModel>getAllSeats();
}