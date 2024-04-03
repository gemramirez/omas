package com.omasystem.omas.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.ReservationDao;
import com.omasystem.omas.Model.ReservationPerSeatModel;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    //retrieves all reservation per seat and data are converted to string.
    public Map<String, Object> getAllReservationPerSeat(Long seat_id) {
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            List<ReservationPerSeatModel> reservationPerSeats = reservationDao.getAllReservationPerSeat(seat_id);

            if (reservationPerSeats.size() == 0) {
                response.put("message", "Free Space");
            } else {
                List<Map<String, Object>> stringList = new ArrayList<>();

                for (ReservationPerSeatModel reservation : reservationPerSeats) {
                    Map<String, Object> reservationMap = new HashMap<>();
                    reservationMap.put("reservation_id", String.valueOf(reservation.getReservation_id()));
                    reservationMap.put("seat_id", String.valueOf(reservation.getSeat_id()));
                    reservationMap.put("start_date", reservation.getStart_date());
                    reservationMap.put("end_date", reservation.getEnd_date());
                    reservationMap.put("position_sn", reservation.getPosition_sn());
                    reservationMap.put("first_name", reservation.getFirst_name());
                    reservationMap.put("middle_name", reservation.getMiddle_name());
                    reservationMap.put("last_name", reservation.getLast_name());
                    reservationMap.put("client_sn", reservation.getClient_sn());

                    stringList.add(reservationMap);
                }

                response.put("message", stringList);

            }
        } catch (Exception e) {
            response.put("message", e.getMessage());
        }
        return response;
    }
}
