package com.omasystem.omas.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationModel {

    private Long reservation_id;
    private String emp_id, note, reg_id, update_id;
    private int seat_id, proj_id, del_flag;
    private Timestamp start_date, end_date, reg_date, update_date;
    
}
