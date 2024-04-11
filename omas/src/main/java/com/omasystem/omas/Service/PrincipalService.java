package com.omasystem.omas.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.PrincipalDao;

@Service
public class PrincipalService {
    @Autowired
    private PrincipalDao principalDao;

    Map<String, Object> response = new HashMap<String, Object>();

    public Map<String, Object> getPrincipalInfo()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated())
        try {
            response.put("message", authentication.getPrincipal());
        } catch (Exception e) {
            response.put("message", e.getMessage());
        }

        return response;
    }
}
