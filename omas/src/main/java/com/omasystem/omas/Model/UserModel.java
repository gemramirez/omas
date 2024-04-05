package com.omasystem.omas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String emp_id;
    private String username;
    private String password;
    private int position_id;
    private int dept_id;
    private int section_id;
    private String status_code;
    private int role_id;
    private String img_src;
}
