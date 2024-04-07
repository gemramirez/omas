package com.omasystem.omas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Service.PrincipalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/principal")
@RequiredArgsConstructor
public class PrincipalRestController {
    @Autowired
    private PrincipalService principalService;

    @GetMapping("/info")
    public Map<String, Object> getPrincipalInfo()
    {
        return principalService.getPrincipalInfo();
    }
}
