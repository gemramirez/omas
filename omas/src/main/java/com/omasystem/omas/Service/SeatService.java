package com.omasystem.omas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.SeatDao;
import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Model.Enum.SeatStatus;



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

    
        public List<SeatModel> getAvailableSeat() {
            // Assuming SeatStatus.AVAILABLE represents the available seats
            return seatDao.getSeatStatus(SeatStatus.available);
        }

        public List<SeatModel> getOccupiedSeat() {
            // Assuming SeatStatus.AVAILABLE represents the available seats
            return seatDao.getSeatStatus(SeatStatus.occupied);
        }

        public List<SeatModel> getRepairingSeat() {
            // Assuming SeatStatus.REPAIRING represents the seats that are under repair
            return seatDao.getSeatStatus(SeatStatus.repairing);
        }

        public ResponseEntity<List<SeatModel>> getTotalSeatsByProject(Long projectId) {
            try {
                List<SeatModel> seatsByProject = seatDao.getTotalSeatsByProject(projectId);
                return ResponseEntity.ok(seatsByProject);
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
}
