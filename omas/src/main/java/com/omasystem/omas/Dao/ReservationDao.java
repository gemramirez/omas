package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.ReservationInputBodyModel;
import com.omasystem.omas.Model.ReservationModel;
import com.omasystem.omas.Model.ReservationPerSeatModel;

@Mapper
public interface ReservationDao {
    //get all reserved seat by caling seat id
    List<ReservationPerSeatModel> getAllReservationPerSeat(Long seat_id);
    // add seat reservation
    void insertReservation(ReservationInputBodyModel body);
    //get reservation using emp_id
    List<ReservationModel> findByEmpId(String emp_id);
    //get reservation using reservationId
    ReservationModel findById(Long reservationId);
    //update seatreservation
    void updateReservation(ReservationModel reservation);

}
