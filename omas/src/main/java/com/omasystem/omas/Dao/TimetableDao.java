package com.omasystem.omas.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.TimetableModel;

@Mapper
public interface TimetableDao {
    List<TimetableModel> getAllReservationPerTimeslot(Map<String, String> parameters);
}
