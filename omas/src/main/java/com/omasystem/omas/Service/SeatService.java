package com.omasystem.omas.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Map<String, Object> response = new HashMap<String, Object>();

    // <------------- GET ALL SEATS ---------->
    public ResponseEntity<List<SeatModel>> getAllSeats() {
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
        }
    };

    // GET ALL AVAILABLE SEATS
    public List<SeatModel> getAvailableSeat() {
        // Assuming SeatStatus.AVAILABLE represents the available seats
        return seatDao.getSeatStatus(SeatStatus.available);
    }

    // GET ALL OCCUPIED SEATS
    public List<SeatModel> getOccupiedSeat() {
        // Assuming SeatStatus.OCCUPIED represents the available seats
        return seatDao.getSeatStatus(SeatStatus.occupied);
    }

    // GET ALL REPAIRING SEAT
    public List<SeatModel> getRepairingSeat() {
        // Assuming SeatStatus.REPAIRING represents the seats that are under repair
        return seatDao.getSeatStatus(SeatStatus.repairing);
    }

    // GET ALL SEATS BY PROJECT
    public ResponseEntity<Map<String, Object>> getTotalSeatsByProject(Long projectId) {
        Map<String, Object> response = new HashMap<>();

        try {
            List<SeatModel> seatsByProject = seatDao.getTotalSeatsByProject(projectId);
            response.put("Number of seats occupied by project", seatsByProject);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            response.put("error", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    public List<SeatModel> getAllSeatsWithProjectName(Long proj_id){
        return seatDao.getAllSeatsWithProjectName(proj_id);

    }
}
