package com.omasystem.omas.Entity;


import java.sql.Timestamp;

import com.omasystem.omas.Entity.Enum.SeatStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {

    private int seat_id;
    @Enumerated(EnumType.STRING)
    private SeatStatus seat_status;  
    private int del_flag;
    private String reg_id;
    private Timestamp reg_date;
    private String update_id;
    private Timestamp update_date;

  

}
