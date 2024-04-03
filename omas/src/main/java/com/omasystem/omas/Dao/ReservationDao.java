package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.ReservationPerSeatModel;

@Mapper
public interface ReservationDao {
    List<ReservationPerSeatModel> getAllReservationPerSeat(Long seat_id);
}
