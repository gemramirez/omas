package com.omasystem.omas.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omasystem.omas.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    // @Query("Select u FROM tbl_user u WHERE u.course.course_id = :course_id")
    Optional<User> findByUsername(String username);
}
