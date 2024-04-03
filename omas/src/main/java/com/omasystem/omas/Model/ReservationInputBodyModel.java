package com.omasystem.omas.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationInputBodyModel {
    private String emp_id, note;
    private int seat_id, proj_id;
    private Timestamp start_date, end_date;
}
