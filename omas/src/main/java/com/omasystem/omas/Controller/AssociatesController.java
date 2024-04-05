package com.omasystem.omas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Service.AssociatesService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/reservation")
public class AssociatesController {
    
    @Autowired
    private AssociatesService associatesService;

    @GetMapping("/totalAssociates")
    public Map<String, Object> getTotalAssociates() {
        return associatesService.getTotalAssociates();
    }

    @GetMapping("/totalAssignedSeats")
    public Map<String, Object> getTotalAssignedSeats() {
        return associatesService.getTotalAssignedSeats();
    }

    @GetMapping("/totalUnassignedSeats")
    public Map<String, Object> getTotalUnassignedSeats() {
        return associatesService.getTotalUnassignedSeats();
    }
    
    
    
}