package com.omasystem.omas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.SeatDao;
import com.omasystem.omas.Model.SeatModel;



@Service
public class SeatService {
    
    @Autowired
        SeatDao seatDao;
        
    public ResponseEntity<List<SeatModel>> getAllSeats(){ 
        try {
            List<SeatModel> seats = seatDao.getAllSeats();
            if (seats != null && !seats.isEmpty()) {
                return ResponseEntity.ok(seats);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }};

}
