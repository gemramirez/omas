package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Model.Enum.SeatStatus;

@Mapper
public interface SeatDao {

    List<SeatModel>getAllSeats();

    List<SeatModel> getSeatStatus(@Param("seat_status") SeatStatus seatStatus);

    List<SeatModel> getTotalSeatsByProject(Long projectId);

}