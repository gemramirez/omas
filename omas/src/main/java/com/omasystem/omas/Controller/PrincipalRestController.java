package com.omasystem.omas.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Dao.UserDao;
import com.omasystem.omas.Model.ReservationInputBodyModel;
import com.omasystem.omas.Model.ReservationModel;
import com.omasystem.omas.Model.UserModel;
import com.omasystem.omas.Service.PrincipalService;
import com.omasystem.omas.Service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/principal")
@RequiredArgsConstructor
public class PrincipalRestController {

    @Autowired
    private PrincipalService principalService;

    @Autowired 
    private ReservationService reservationService;

    @Autowired
    private UserDao userDao;

    private String getCurrentSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/info")
    public Map<String, Object> getPrincipalInfo()
    {
        return principalService.getPrincipalInfo();
    }

    // /*not yet tested*/
    // @GetMapping("/reservation")
    // public List<ReservationModel> getPrincipalReservation(String session) {
    //     UserModel currentUser = userDao.getPrincipal(session);
        
    //     if (currentUser == null) {
    //         return null;
    //     }
    
    //     String empId = currentUser.getEmp_id();
    
    //     return reservationService.getReservationByEmpId(empId);
    // }

    // /*not yet tested */
    // @PutMapping("/reservation/{reservationId}")
    // public Map<String, Object> updateReservation(@PathVariable Long reservationId, @RequestBody ReservationInputBodyModel body) {
    //     // Retrieve the current user based on the session
    //     UserModel currentUser = userDao.getPrincipal(getCurrentSession());
    
    //     if (currentUser == null) {
    //         return null;
    //     }
    
    //     // Retrieve the reservation to be updated
    //     ReservationModel reservation = reservationService.getReservationById(reservationId);
    
    //     if (reservation == null) {
    //         return null; // Handle case where reservation is not found
    //     }
    
    //     // Check if the reservation belongs to the current user
    //     if (!reservation.getEmp_id().equals(currentUser.getEmp_id())) {
    //         return null; // Handle case where the reservation doesn't belong to the current user
    //     }
    
    //     // Update the reservation
    //     return reservationService.updateReservation(reservationId, body);
    // }
    
    
}
