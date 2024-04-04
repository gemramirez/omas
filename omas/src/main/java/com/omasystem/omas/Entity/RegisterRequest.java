package com.omasystem.omas.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String emp_id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String username;
    private String password; 
}
