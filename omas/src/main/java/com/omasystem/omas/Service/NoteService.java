package com.omasystem.omas.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omasystem.omas.Dao.NoteDao;
import com.omasystem.omas.Model.NoteModel;

@Service
public class NoteService {
    @Autowired
    private NoteDao noteDao;

    Map<String, Object> response = new HashMap<String, Object>();
    public Map<String, Object> getAllNotes()
    {
        try {
            List<NoteModel> notes = noteDao.getAllNote();

            if(notes.size() == 0)
            {
                response.put("message", "No notes yet.");
            }
            else
            {
                List<Map<String, Object>> stringList = new ArrayList<>();

                for (NoteModel note : notes) {
                    Map<String, Object> noteMap = new HashMap<>();
                    noteMap.put("emp_id", note.getEmp_id());
                    noteMap.put("username", note.getUsername());
                    noteMap.put("first_name", note.getFirst_name());
                    noteMap.put("middle_name", note.getMiddle_name());
                    noteMap.put("last_name", note.getLast_name());
                    noteMap.put("note", note.getNote());
                    noteMap.put("noted_at", note.getNoted_at());
                    noteMap.put("seat_id", String.valueOf(note.getSeat_id()));

                    stringList.add(noteMap);
                }

                response.put("message", stringList);
            }
            
        } catch (Exception e) {
            response.put("message", e.getMessage());
        }
        return response;
    }
}
