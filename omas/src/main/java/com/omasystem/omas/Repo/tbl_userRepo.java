package com.omasystem.omas.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omasystem.omas.Entity.tbl_user;

@Repository
public interface tbl_userRepo extends JpaRepository<tbl_user, String>{
    Optional<tbl_user> findByUsername(String username);
    
}
