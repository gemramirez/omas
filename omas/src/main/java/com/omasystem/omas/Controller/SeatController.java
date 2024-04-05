package com.omasystem.omas.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Service.SeatService;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SeatModel>> getAllSeats() {
        return seatService.getAllSeats();
    }
}
