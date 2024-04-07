package com.omasystem.omas.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Service.SeatService;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SeatModel>> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/available")
    public List<SeatModel> getAvailableSeat(){
        return seatService.getAvailableSeat();
    }

    @GetMapping("/occupied")
    public List<SeatModel> getOccupiedSeat(){
        return seatService.getOccupiedSeat();
    }

    @GetMapping("/totalByProject")
    public ResponseEntity<List<SeatModel>> getTotalSeatsByProject(@RequestParam Long projectId) {
        return seatService.getTotalSeatsByProject(projectId);
    }
}
