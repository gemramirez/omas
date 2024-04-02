package com.omasystem.omas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Seat {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long SeatId;
private String AvailableSeat;//  ENUM
private String OccupiedSeat;//ENUM
private String UnderRepairSeat;//ENUM
private int SeatRow;


//possible foreignkey
//project id
//reservation id
//user id
//Position




    public Long getSeatId() {
        return this.SeatId;
    }

    public void setSeatId(Long SeatId) {
        this.SeatId = SeatId;
    }

    public Seat SeatId(Long SeatId) {
        setSeatId(SeatId);
        return this;
    }

    public String getAvailableSeat() {
        return this.AvailableSeat;
    }

    public void setAvailableSeat(String AvailableSeat) {
        this.AvailableSeat = AvailableSeat;
    }

    public Seat AvailableSeat(String AvailableSeat) {
        setAvailableSeat(AvailableSeat);
        return this;
    }

    public String getOccupiedSeat() {
        return this.OccupiedSeat;
    }

    public void setOccupiedSeat(String OccupiedSeat) {
        this.OccupiedSeat = OccupiedSeat;
    }

    public Seat OccupiedSeat(String OccupiedSeat) {
        setOccupiedSeat(OccupiedSeat);
        return this;
    }

    public String getUnderRepairSeat() {
        return this.UnderRepairSeat;
    }

    public void setUnderRepairSeat(String UnderRepairSeat) {
        this.UnderRepairSeat = UnderRepairSeat;
    }

    public Seat UnderRepairSeat(String UnderRepairSeat) {
        setUnderRepairSeat(UnderRepairSeat);
        return this;
    }

    public int getSeatRow() {
        return this.SeatRow;
    }

    public void setSeatRow(int SeatRow) {
        this.SeatRow = SeatRow;
    }

    public Seat SeatRow(int SeatRow) {
        setSeatRow(SeatRow);
        return this;
    }

    
}

