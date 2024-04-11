package com.omasystem.omas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Service.AssociatesService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/associates") /*changed from /api/reservation */
public class AssociatesController {
    
    @Autowired
    private AssociatesService associatesService;

    /*Gets the total number of associates */
    @GetMapping("/total")
    public Map<String, Object> getTotalAssociates() {
        return associatesService.getTotalAssociates();
    }

    /*Gets the total number of assigned seats */
    @GetMapping("/assigned")
    public Map<String, Object> getTotalAssignedSeats() {
        return associatesService.getTotalAssignedSeats();
    }

    /*Gets the total nuber of unassigned seats */
    @GetMapping("/unassigned")
    public Map<String, Object> getTotalUnassignedSeats() {
        return associatesService.getTotalUnassignedSeats();
    }
    
}