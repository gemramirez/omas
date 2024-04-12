package com.omasystem.omas.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Model.TimetableModel;
import com.omasystem.omas.Service.TimetableService;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    @Autowired
    private final TimetableService timetableService;
    
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    /* Get the list of all reservations */
    @GetMapping("/reservations")
    public Map<String, Object> getAllReservations()
    {
        return timetableService.getAllReservations();
    }

    /* Get the list of reserved seats based on a specific time range */
    @GetMapping("/reservation")
    public Map<String, Object> getAllReservationPerTimeslot(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate) {
        Map<String, String> params = new HashMap<>();
        params.put("start_date", startDate);
        params.put("end_date", endDate);

        return timetableService.getAllReservationPerTimeslot(params);
    }


    /* Get the list of reserved seats based on its start date and seat id */
    @GetMapping("/reservation/start")
    public Map<String, Object> getAllReservationStartDate(@RequestParam("startDate") String startDate, @RequestParam("seatId") int seatId) {
        return timetableService.getAllReservationStartDate(startDate, seatId);
    }
    

    /* Get all seats based on a reservation */
    @GetMapping("/reservations/seat")
    public Map<String, Object> getAllSeatsInReservation(@RequestParam Long reservationId) {
        Map<String, Object> response = new HashMap<>();
    
        try {
            Map<String, Object> seatsResponse = timetableService.getAllSeatsInReservation(reservationId);
            response.put("message", seatsResponse.get("message"));
        } catch (Exception e) {
            response.put("message", e.getMessage());
        }
    
        return response;
    }
    
        
}