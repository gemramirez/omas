package com.omasystem.omas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.omasystem.omas.Entity.Seat;
import com.omasystem.omas.Repo.SeatRepository;

public class SeactService {
 
    @Autowired
        private SeatRepository seatRepository;
 
    public Seat saveSeat(@RequestBody Seat seat) { // Method signature to create a new course
        System.out.println("Seat ID: " + seat.getSeatId());
        System.out.println("Reserved for: " + seat.getUserFullname());
        System.out.println("Project: " + seat.getProjectName());
        System.out.println("reservation Code: " + seat.getReservationCode());
        System.out.println("Reservation Date: " + seat.getResrvationDate());
        System.out.println("Reservation Time in: " + seat.getResrvationTimein());
        System.out.println("Reservation Time out: " + seat.getReservationTimeout());
        return seatRepository.save(seat); // referring to save() method of CourseRepository interface
    }

    public List<Seat> getAllSeat(){
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById (Long SeatId){
        return seatRepository.findById(SeatId);
    }

    public Optional<Seat> updateSeat (@RequestBody Seat updatedSeat, @PathVariable Long SeatId){
        return seatRepository.findById(SeatId)
            .map(seat -> {
                seat.setUserFullName(updatedSeat.getUserFullname());

                return seatRepository.saveSeat(seat);
            });
    }

}

