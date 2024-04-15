package com.omasystem.omas.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.PrincipalDao;
import com.omasystem.omas.Model.PrincipalModel;
import com.omasystem.omas.Model.UserModel;

@Service
public class PrincipalService {
    @Autowired
    private PrincipalDao principalDao;

    Map<String, Object> response = new HashMap<String, Object>();
    
    //GET ALL PRINCIPAL INFO

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

    /*GET ALL PRINCIPAL USERS */
    public ResponseEntity<List<PrincipalModel>> getAllPrincipalUsers() {
        try {
            List<PrincipalModel> principals = principalDao.getAllPrincipalUsers();
            if (principals != null && !principals.isEmpty()) {
                return ResponseEntity.ok(principals);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    };
}
