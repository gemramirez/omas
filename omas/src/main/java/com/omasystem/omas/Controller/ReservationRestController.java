package com.omasystem.omas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
