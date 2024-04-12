package com.omasystem.omas.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Entity.AuthenticationRequest;
import com.omasystem.omas.Entity.AuthenticationResponse;
import com.omasystem.omas.Entity.RegisterRequest;
import com.omasystem.omas.Entity.tbl_personal_info;
import com.omasystem.omas.Entity.tbl_user;
import com.omasystem.omas.Repo.tbl_personal_infoRepo;
import com.omasystem.omas.Repo.tbl_userRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final tbl_userRepo tbl_userRepository;
    private final tbl_personal_infoRepo tbl_personal_infoRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    //Logic for emp_id
    private String generateEmpId() {
        // Get the count of existing entries
        long existingEntriesCount = tbl_userRepository.count();
        // Increment the count by 100 and convert it to a string
        return String.valueOf(existingEntriesCount + 100);
    }

    public AuthenticationResponse register(RegisterRequest request) {
        String empId = generateEmpId();

        var user = tbl_user.builder()
                .emp_id(empId)
                .username(request.getUsername())
                .position_id(1)
                .section_id(1)
                .dept_id(1)
                .status_code("TRA")
                .role_id(1)
                .img_src("Default")
                .password(passwordEncoder.encode(request.getPassword()))
                // .role(Role.USER)
                .build();
        
        if (user != null) {
            tbl_userRepository.save(user);
        }

        var personal_info = tbl_personal_info.builder()
                .emp_id(empId)
                .fname(request.getFirstname())
                .lname(request.getLastname())
                .mname(request.getMiddlename())
                .email(request.getEmail())
                .build();

        if(personal_info != null) {
            tbl_personal_infoRepo.save(personal_info);
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        var user = tbl_userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
