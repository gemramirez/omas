package com.omasystem.omas.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProjectModel {
    private Long upid;
    private String emp_id, reg_id, update_id;
    private int proj_id, del_flag;
    private Timestamp reg_date, update_date;
}
