package com.omasystem.omas.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.TimetableDao;
import com.omasystem.omas.Model.TimetableModel;

@Service
public class TimetableService {

    @Autowired
    private TimetableDao timetableDao;
    
    // Get the list of reserved seats based on a specific time range
    public List<TimetableModel> getAllReservationPerTimeslot(Map<String, String> parameters) {
        return timetableDao.getAllReservationPerTimeslot(parameters);
    }

    // Get the list of reserved seat based on its start date
    public List<TimetableModel> getAllReservationStartDate(String parameter) {
        return timetableDao.getAllReservationStartDate(parameter);
    }
}