package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Entity.Seat;

@Mapper
public interface SeatDao {

    List<Seat>getAllSeats();
}