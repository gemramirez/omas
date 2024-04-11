package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.ReservationInputBodyModel;
import com.omasystem.omas.Model.ReservationModel;
import com.omasystem.omas.Model.ReservationPerSeatModel;

@Mapper
public interface ReservationDao {
    List<ReservationPerSeatModel> getAllReservationPerSeat(Long seat_id);
    void insertReservation(ReservationInputBodyModel body);
    List<ReservationModel> findByEmpId(String emp_id);
    ReservationModel findById(Long reservationId);
    ReservationModel updateReservation(ReservationModel reservation);

}
