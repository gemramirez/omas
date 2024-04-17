package com.omasystem.omas.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                    reservationMap.put("Reservation ID", reservation.getReservation_id());
                    reservationMap.put("Seat ID", reservation.getSeat_id());
                    reservationMap.put("Reservation Start Date", reservation.getStart_date());
                    reservationMap.put("Reservation End Date", reservation.getEnd_date());
                    reservationMap.put("Project", reservation.getProject_name());
                    reservationMap.put("Client", reservation.getClient_name());
                    reservationMap.put("Note", reservation.getNote());

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
                    slotReservationMap.put("Reservation ID", slotReservation.getReservation_id());
                    slotReservationMap.put("Seat ID", slotReservation.getSeat_id());
                    slotReservationMap.put("Reservation Start Date", slotReservation.getStart_date());
                    slotReservationMap.put("Reservation End Date", slotReservation.getEnd_date());
                    slotReservationMap.put("Project", slotReservation.getProject_name());
                    slotReservationMap.put("Client", slotReservation.getClient_name());
                    slotReservationMap.put("Note", slotReservation.getNote());
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
                    startReservationMap.put("Reservation ID", startReservation.getReservation_id());
                    startReservationMap.put("Seat ID", startReservation.getSeat_id());
                    startReservationMap.put("Reservation Start Date", startReservation.getStart_date());
                    startReservationMap.put("Reservation End Date", startReservation.getEnd_date());
                    startReservationMap.put("Project", startReservation.getProject_name());
                    startReservationMap.put("Client", startReservation.getClient_name());
                    startReservationMap.put("Note", startReservation.getNote());
    
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
                        startReservationMap.put("Seat ID", seatReservation.getSeat_id());
                        startReservationMap.put("Seat Status", seatReservation.getSeat_status());
                        startReservationMap.put("Department ID", seatReservation.getDept_id());
                        startReservationMap.put("Project ID", seatReservation.getProj_id());
                        startReservationMap.put("Registration Date", seatReservation.getReg_date());
                        startReservationMap.put("Registration ID", seatReservation.getReg_id());
                        startReservationMap.put("Total Seats Reserved", seatReservation.getTotalSeatsReserved());
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