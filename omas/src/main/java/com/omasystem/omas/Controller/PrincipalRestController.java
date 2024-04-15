package com.omasystem.omas.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Dao.UserDao;
import com.omasystem.omas.Model.PrincipalModel;
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

    /*Gets the logged in user's info */
    @GetMapping("/info")
    public Map<String, Object> getPrincipalInfo() {
        return principalService.getPrincipalInfo();
    }

    /*Gets the list of users *For admin* */
    @GetMapping("/all")
    public ResponseEntity<List<PrincipalModel>> getAllPrincipalUsers() {
        return principalService.getAllPrincipalUsers();
    }

    @GetMapping("/reservation")
    public List<ReservationModel> getPrincipalReservation() {
        String session = getCurrentSession(); // Get the current session
        if (session == null || session.isEmpty()) {
            // Handle the case where session is empty or null, such as returning an error
            // response
            return null;
        }

        UserModel currentUser = userDao.getPrincipal(session);

        if (currentUser == null) {
            return null;
        }

        String empId = currentUser.getEmp_id();

        return reservationService.getReservationByEmpId(empId);
    }

    /*Gets the logged in user's reservation by reservation id */
    @PutMapping("/reservation/{reservationId}")
    public ResponseEntity<Map<String, Object>> updateReservation(@PathVariable Long reservationId,
            @RequestBody ReservationInputBodyModel body) {
        // Retrieve the current user based on the session
        UserModel currentUser = userDao.getPrincipal(getCurrentSession());

        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "User not authenticated"));
        }

        // Retrieve the reservation to be updated
        ReservationModel reservation = reservationService.getReservationById(reservationId);

        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Reservation not found"));
        }

        // Check if the reservation belongs to the current user
        if (!reservation.getEmp_id().equals(currentUser.getEmp_id())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", "You are not authorized to update this reservation"));
        }

        // Update the reservation
        Map<String, Object> updateResult = reservationService.updateReservation(reservationId, body);

        if (updateResult.containsKey("error")) {
            // If there's an error during the update operation
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(updateResult);
        }

        // Return success response
        return ResponseEntity.ok(updateResult);
    }

}
