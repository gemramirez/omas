package com.omasystem.omas.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Service.NoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteRestController {
    
    @Autowired
    private NoteService noteService;

    /*Gets all notes from reservations */
    @GetMapping("/all")
    public Map<String, Object> getAllNotes()
    {
        return noteService.getAllNotes();
    }
}
