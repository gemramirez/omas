package com.omasystem.omas.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableModel {
    private Long reservation_id;
    private int seat_id;
    private Timestamp start_date, end_date;
    private String note, first_name, middle_name, last_name, client_sn;
}