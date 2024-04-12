package com.omasystem.omas.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    Map<String, Object> reservationResponse = new HashMap<String, Object>();
    public Map<String, Object> getAllReservations()

    {
        try {
            List<TimetableModel> reservations = timetableDao.getAllReservations();

            if (reservations.size() == 0) {
                reservationResponse.put("message", "No reservations.");
            } else {
                List<Map<String, Object>> stringList = new ArrayList<>();

                for (TimetableModel reservation : reservations) {
                    Map<String, Object> reservationMap = new HashMap<>();
                    reservationMap.put("reservation_id", reservation.getReservation_id());
                    reservationMap.put("seat_id", reservation.getSeat_id());
                    reservationMap.put("reservation_start_date", reservation.getStart_date());
                    reservationMap.put("reservation_end_date", reservation.getEnd_date());
                    reservationMap.put("project", reservation.getProject_name());
                    reservationMap.put("client", reservation.getClient_name());
                    reservationMap.put("note", reservation.getNote());

                    stringList.add(reservationMap);
                }

                reservationResponse.put("message", stringList);
            }
        } catch (Exception e) {
            reservationResponse.put("message", e.getMessage());
        }
        return reservationResponse;
    }

    // Get the list of reserved seats based on a specific time range
    public Map<String, Object> getAllReservationPerTimeslot(Map<String, String> parameters) {
        Map<String, Object> timeRangeResponse = new HashMap<>();
        try {
            List<TimetableModel> slotReservations = timetableDao.getAllReservationPerTimeslot(parameters);
            if (slotReservations.isEmpty()) {
                timeRangeResponse.put("message", "No reservations found.");
            } else {
                List<Map<String, Object>> stringList = new ArrayList<>();
                for (TimetableModel slotReservation : slotReservations) {
                    Map<String, Object> slotReservationMap = new HashMap<>();
                    slotReservationMap.put("reservation_id", slotReservation.getReservation_id());
                    slotReservationMap.put("seat_id", slotReservation.getSeat_id());
                    slotReservationMap.put("reservation_start_date", slotReservation.getStart_date());
                    slotReservationMap.put("reservation_end_date", slotReservation.getEnd_date());
                    slotReservationMap.put("project", slotReservation.getProject_name());
                    slotReservationMap.put("client", slotReservation.getClient_name());
                    slotReservationMap.put("note", slotReservation.getNote());
                    stringList.add(slotReservationMap);
                }
                timeRangeResponse.put("reservations", stringList);
            }
        } catch (Exception e) {
            timeRangeResponse.put("message", e.getMessage());
        }
        return timeRangeResponse;
    }
    

    // Get the list of reserved seat based on its start date & seat id
    Map<String, Object> startResponse = new HashMap<String, Object>();

    public Map<String, Object> getAllReservationStartDate(String startDate, int seatId) {
        try {
            List<TimetableModel> startReservations = timetableDao.getAllReservationStartDate(startDate, seatId);
    
            if (startReservations.size() == 0) {
                startResponse.put("message", "No reservations.");
            } else {
                List<Map<String, Object>> stringList = new ArrayList<>();
    
                for (TimetableModel startReservation : startReservations) {
                    Map<String, Object> startReservationMap = new HashMap<>();
                    startReservationMap.put("reservation_id", startReservation.getReservation_id());
                    startReservationMap.put("seat_id", startReservation.getSeat_id());
                    startReservationMap.put("reservation_start_date", startReservation.getStart_date());
                    startReservationMap.put("reservation_end_date", startReservation.getEnd_date());
                    startReservationMap.put("project", startReservation.getProject_name());
                    startReservationMap.put("client", startReservation.getClient_name());
                    startReservationMap.put("note", startReservation.getNote());
    
                    stringList.add(startReservationMap);
                }
    
                startResponse.put("message", stringList);
            }
        } catch (Exception e) {
            startResponse.put("message", e.getMessage());
        }
        return startResponse;
    }
    

    // Get all seats based on a reservation
    public Map<String, Object> getAllSeatsInReservation(Long parameter) {
        Map<String, Object> seatResponse = new HashMap<>();
        {
            try {
                List<SeatModel> seatReservations = timetableDao.getAllSeatsInReservation(parameter);
        
                if(seatReservations.size() == 0)
                {
                    seatResponse.put("message", "No reservations.");
                }
                else
                {
                    List<Map<String, Object>> stringList = new ArrayList<>();
        
                    for (SeatModel seatReservation: seatReservations) {
                        Map<String, Object> startReservationMap = new HashMap<>();
                        startReservationMap.put("seat_id", seatReservation.getSeat_id());
                        startReservationMap.put("seat_status", seatReservation.getSeat_status());
                        startReservationMap.put("department_id", seatReservation.getDept_id());
                        startReservationMap.put("project_id", seatReservation.getProj_id());
                        startReservationMap.put("registration_date", seatReservation.getReg_date());
                        startReservationMap.put("registration_id", seatReservation.getReg_id());
                        startReservationMap.put("total_seats_reserved", seatReservation.getTotalSeatsReserved());
                        stringList.add(startReservationMap);
                    }
        
                    seatResponse.put("message", stringList);
                }
            } catch (Exception e) {
                seatResponse.put("message", e.getMessage());
            }
            return seatResponse;
        }        
    }
}