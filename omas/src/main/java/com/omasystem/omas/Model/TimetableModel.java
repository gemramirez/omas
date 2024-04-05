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
    private String note, project_name, client_name;
}