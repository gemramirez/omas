package com.omasystem.omas.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.NoteModel;

@Mapper
public interface NoteDao {
    List<NoteModel> getAllNote(); 
}
