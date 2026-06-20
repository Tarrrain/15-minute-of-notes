package com.notein.demo.repository;

import com.notein.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // JpaRepository дает методы: save(), findAll(), findById(), deleteById() и др.
    List<Note> findByCreatedAtAfter(LocalDateTime date);
    List<Note> findByContentContaining(String keyword);
}