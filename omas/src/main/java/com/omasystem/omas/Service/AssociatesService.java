package com.omasystem.omas.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.AssociatesDao;

@Service
public class AssociatesService {

    @Autowired
    private AssociatesDao associatesDao;

    // TOTAL ASSOCIATES
    public Map<String, Object> getTotalAssociates() {
        Map<String, Object> response = new HashMap<>();
        try {
            Long totalAssociates = associatesDao.getTotalAssociates();
            response.put("Total Associates", totalAssociates);
            response.put("Messages", "Total asssociates retrieved successfully");
        } catch (Exception e) {
            response.put("Messages", e.getMessage());
        }
        return response;
    }

    // TOTAL ASSIGNED SEATS
    public Map<String, Object> getTotalAssignedSeats() {
        Map<String, Object> response = new HashMap<>();
        try {
            Long assignedSeats = associatesDao.getTotalAssignedSeats();
            response.put("Total assigned seats", assignedSeats);
            response.put("Messages", "Total assigned seats retrieved successfully");
        } catch (Exception e) {
            response.put("Message", e.getMessage());
        }
        return response;
    }

    // TOTAL UNASSIGNED SEATS
    public Map<String, Object> getTotalUnassignedSeats() {
        Map<String, Object> response = new HashMap<>();
        try {
            Integer unassignedSeats = associatesDao.getTotalUnassignedSeats();
            response.put("Total unassigned seats", unassignedSeats);
            response.put("Messages", "Total unssigned seats retrieved successfully");
        } catch (Exception e) {
            response.put("Messages", e.getMessage());
        }
        return response;
    }

}