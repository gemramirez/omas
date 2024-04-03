package com.omasystem.omas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalModel {
    private Long emp_id;
    private String username, first_name, middle_name, last_name, position_name, project_name, img_src;
}
