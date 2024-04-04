package com.omasystem.omas.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteModel {
    private String emp_id, username, first_name, middle_name, last_name, note;
    private Timestamp noted_at;
    private int seat_id;
}
