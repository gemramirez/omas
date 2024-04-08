package com.omasystem.omas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.ReservationInputBodyModel;
import com.omasystem.omas.Service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationRestController {
    
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{seat_id}")
    public Map<String, Object> getAllReservationPerSeat(@PathVariable Long seat_id)
    {
        return reservationService.getAllReservationPerSeat(seat_id);
    }

    @PostMapping("/{seat_id}/add")
    public Map<String, Object> insertReservation(@PathVariable int seat_id, @RequestBody ReservationInputBodyModel body)
    {
        return reservationService.insertReservation(seat_id, body);
    }
}
