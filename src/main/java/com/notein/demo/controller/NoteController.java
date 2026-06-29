package com.notein.demo.controller;

import com.notein.demo.entity.Note;
import com.notein.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    
    // Создать запись: POST /api/notes
    @PostMapping  // ← ТОЛЬКО POST!
    public Note createNote(@RequestBody NoteRequest request) {
        return noteService.createNote(request.getContent());
    }
    
    // Получить все записи: GET /api/notes
    @GetMapping  // ← ДОБАВЬ ЭТОТ МЕТОД!
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
    
    // Получить одну запись: GET /api/notes/{id}
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }
    
    // Удалить запись: DELETE /api/notes/{id}
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}

// DTO для создания записи
class NoteRequest {
    private String content;
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
