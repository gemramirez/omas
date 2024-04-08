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
@RequestMapping("/api/seats") /*changed from /seat to /api/seats */
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/all") /*changed from getAll to all */
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

    @GetMapping("/repairing")
    public List<SeatModel> getRepairingSeat(){
        return seatService.getRepairingSeat();
    }

    @GetMapping("/project") /*changed from totalByProject to project */
    public ResponseEntity<List<SeatModel>> getTotalSeatsByProject(@RequestParam Long projectId) {
        return seatService.getTotalSeatsByProject(projectId);
    }
}
