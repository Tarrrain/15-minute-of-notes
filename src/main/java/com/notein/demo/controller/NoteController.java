package com.notein.demo.controller;

import com.notein.demo.entity.Note;
import com.notein.demo.repository.NoteRepository;
import com.notein.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping // Получить все записи: GET /api/notes
    public Note createNote(@RequestBody NoteRequest request) {
        //TODO: process POST request
        return noteService.createNote(request.getContent());
    }
    @GetMapping ("/{id}") // Получить одну запись: GET /api/notes/{id}
    public Note getNoteById(@PathVariable Long id){
        return noteService.getNoteById(id);
    }
    
    @DeleteMapping("/{id}") // Удалить запись: DELETE /api/notes/{id}
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
// DTO для создания записи
class NoteRequest {
    private String content;
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content;}
}

