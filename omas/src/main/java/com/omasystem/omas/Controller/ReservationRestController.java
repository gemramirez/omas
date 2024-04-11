package com.omasystem.omas.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.ReservationInputBodyModel;
import com.omasystem.omas.Model.ReservationModel;
import com.omasystem.omas.Model.ReservationPerSeatModel;
import com.omasystem.omas.Service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationRestController {
    
    @Autowired
    private ReservationService reservationService;

    /*get reservation thru calling seat_id*/
    @GetMapping("/{seat_id}")
    public Map<String, Object> getAllReservationPerSeat(@PathVariable Long seat_id)
    {
        return reservationService.getAllReservationPerSeat(seat_id);
    }

    /*adding reservation to desire seat id*/
    @PostMapping("/{seat_id}/add")
    public Map<String, Object> insertReservation(@PathVariable Long seat_id, @RequestBody ReservationInputBodyModel body)
    {
        return reservationService.insertReservation(seat_id, body);
    }

    /*update seat's status into restoration*/
    @PutMapping("/{seat_id}/repair-seat")
    public Map<String, Object> underRepairing( @PathVariable Long seat_id,
    @RequestBody ReservationInputBodyModel body)
   {
        return reservationService.underRepairing(seat_id, body);
    }

    @GetMapping("/all")
    public List<ReservationModel> getAllReservation()  {
        return reservationService.getAllReservation();
    }

    @GetMapping("/allReservationWithUserInfo")
    public List<ReservationPerSeatModel> getAllReservationWithUserInfo() {
        return reservationService.getAllReservationWithUserInfo();
    }

    
    


}
