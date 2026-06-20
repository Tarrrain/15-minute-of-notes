package com.notein.demo.service;

import com.notein.demo.entity.Note;
import com.notein.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    public Note createNote(String content){
        Note note = new Note(content);
        return noteRepository.save(note);
    }
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }
    public Note getNoteById(Long id){
        return noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }
     @GetMapping("/search")
    
    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }
}