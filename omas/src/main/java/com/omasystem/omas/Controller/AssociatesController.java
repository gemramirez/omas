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

    @GetMapping("/total")
    public Map<String, Object> getTotalAssociates() {
        return associatesService.getTotalAssociates();
    }

    @GetMapping("/assigned")
    public Map<String, Object> getTotalAssignedSeats() {
        return associatesService.getTotalAssignedSeats();
    }

    @GetMapping("/unassigned")
    public Map<String, Object> getTotalUnassignedSeats() {
        return associatesService.getTotalUnassignedSeats();
    }
    
    
    
}