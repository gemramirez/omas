package com.omasystem.omas.Model;

import java.sql.Timestamp;

import com.omasystem.omas.Model.Enum.SeatStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatModel {

    
        private int seat_id;
        @Enumerated(EnumType.STRING)
        private SeatStatus seat_status;  
        private int del_flag;
        private int dept_id;
        private int proj_id;
        private String reg_id;
        private String proj_name;
        private Timestamp reg_date;
        private String update_id;
        private Timestamp update_date;
        private int totalSeatsReserved;
    
        public int getTotalSeatsReserved() {
                return totalSeatsReserved;
            }
        
            public void setTotalSeatsReserved(int totalSeatsReserved) {
                this.totalSeatsReserved = totalSeatsReserved;
            }      
    
    
    
}
