package com.omasystem.omas.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.SeatDao;
import com.omasystem.omas.Dao.TimetableDao;
import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Model.TimetableModel;

@Service
public class TimetableService {

    @Autowired
    private TimetableDao timetableDao;
    
    // Get the list of all reservations
    public List<TimetableModel> getAllReservations() {
        return timetableDao.getAllReservations();
    }
    
    // Get the list of reserved seats based on a specific time range
    public List<TimetableModel> getAllReservationPerTimeslot(Map<String, String> parameters) {
        return timetableDao.getAllReservationPerTimeslot(parameters);
    }

    // Get the list of reserved seat based on its start date & seat id
    public List<TimetableModel> getAllReservationStartDate(String startDate, int seatId) {
        return timetableDao.getAllReservationStartDate(startDate, seatId);
    }

    // Get all seats based on a reservation 
    public List<SeatModel> getAllSeatsInReservation(Long parameter) {
        return timetableDao.getAllSeatsInReservation(parameter);
    }
}