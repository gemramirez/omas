package com.omasystem.omas.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationPerSeatModel {
    private Long reservation_id;
    private String position_sn, first_name, middle_name, last_name, client_sn;
    private int seat_id;
    private Timestamp start_date, end_date;
}
