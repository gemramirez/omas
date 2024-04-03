package com.omasystem.omas.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.PrincipalDao;
import com.omasystem.omas.Model.PrincipalModel;

@Service
public class PrincipalService {
    @Autowired
    private PrincipalDao principalDao;

    //** sample session until the implementation of spring security session */
    public static final String SESSION = "rgalpo";

    Map<String, Object> response = new HashMap<String, Object>();

    public Map<String, Object> getPrincipalInfo()
    {
        try {
            PrincipalModel principal = principalDao.getPrincipal(SESSION);
            response.put("message", principal);
        } catch (Exception e) {
            response.put("message", e.getMessage());
        }

        return response;
    }
}
