package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Model.Enum.SeatStatus;

@Mapper
public interface SeatDao {

    //get all seat using seat id
    List<SeatModel>getAllSeats();
    // get all seat by calling seat status(enum)
    List<SeatModel> getSeatStatus(@Param("seat_status") SeatStatus seatStatus);
    //get all seats by callinf projectId
    List<SeatModel> getTotalSeatsByProject(Long projectId);
    //add seat reservation
    void updateSeatStatus(@Param("seatId") Long seat_id, @Param("status") SeatStatus status);
     
    // SeatModel getSeat(int seat_id); 

    // List<SeatModel>getAllSeatsWithProjectName(Long proj_id);
    List<SeatModel> getAllSeatsWithProjectName(@Param("proj_id") Long proj_id);
}