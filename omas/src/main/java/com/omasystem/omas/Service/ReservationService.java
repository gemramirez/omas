package com.omasystem.omas.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.PrincipalDao;
import com.omasystem.omas.Dao.ReservationDao;
import com.omasystem.omas.Dao.UserDao;
import com.omasystem.omas.Dao.UserProjectDao;
import com.omasystem.omas.Model.PrincipalModel;
import com.omasystem.omas.Model.ReservationInputBodyModel;
import com.omasystem.omas.Model.ReservationPerSeatModel;
import com.omasystem.omas.Model.UserModel;
import com.omasystem.omas.Model.UserProjectModel;
import com.omasystem.omas.Repo.tbl_userRepo;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private UserProjectDao userProjectDao;

    @Autowired
    private UserDao userDao;

    Map<String, Object> response = new HashMap<String, Object>();

    // ** sample data for emp_id until the implementation of session using spring
    // security.
    public static final String EMP_ID = "101";

    // retrieves all reservation per seat and data are converted to string.
    public Map<String, Object> getAllReservationPerSeat(Long seat_id) {

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

    // saves reservation to database.
    public Map<String, Object> insertReservation(Long seat_id, ReservationInputBodyModel body) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        ReservationInputBodyModel bodyContainer = new ReservationInputBodyModel();

        System.out.println(authentication.getName());

        UserModel principal = userDao.getPrincipal(authentication.getName());

        UserProjectModel currentProjectOfUser = userProjectDao
                .getProjectInvolvedOfUser(String.valueOf(principal.getEmp_id()));

        if(currentProjectOfUser != null)
        {
            bodyContainer.setProj_id(currentProjectOfUser.getProj_id());
        }
        else
        {
            bodyContainer.setProj_id(1);
        }

        try {
            bodyContainer.setEmp_id(String.valueOf(principal.getEmp_id()));
            bodyContainer.setSeat_id(Integer.parseInt(seat_id.toString()));
            bodyContainer.setStart_date(body.getStart_date());
            bodyContainer.setEnd_date(body.getEnd_date());
            bodyContainer.setNote(body.getNote());

            reservationDao.insertReservation(bodyContainer);

            response.put("message", "Reservation Added Successfully");
        } catch (Exception e) {
            response.put("message", e.getMessage());
        }
        return response;
    }
}
