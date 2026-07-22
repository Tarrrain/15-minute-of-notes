package com.notein.demo.repository;

import com.notein.demo.entity.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest  // Поднимает только JPA, не весь контекст
class NoteRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldSaveNote() {
        // given
        Note note = new Note("Test content");

        // when
        Note saved = noteRepository.save(note);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getContent()).isEqualTo("Test content");
        assertThat(saved.getCreatedAt()).isNotNull();
    }

    @Test
    void shouldFindAllNotes() {
        // given
        Note note1 = new Note("Note 1");
        Note note2 = new Note("Note 2");
        entityManager.persist(note1);
        entityManager.persist(note2);
        entityManager.flush();

        // when
        List<Note> notes = noteRepository.findAll();

        // then
        assertThat(notes).hasSize(2);
        assertThat(notes).extracting(Note::getContent)
                .containsExactlyInAnyOrder("Note 1", "Note 2");
    }

    @Test
    void shouldFindNoteById() {
        // given
        Note note = new Note("Find me");
        entityManager.persist(note);
        entityManager.flush();

        // when
        Note found = noteRepository.findById(note.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getContent()).isEqualTo("Find me");
    }

    @Test
    void shouldDeleteNote() {
        // given
        Note note = new Note("Delete me");
        Note saved = noteRepository.save(note);

        // when
        noteRepository.deleteById(saved.getId());

        // then
        assertThat(noteRepository.findById(saved.getId())).isEmpty();
    }

    @Test
    void shouldFindByContentContaining() {
        // given
        Note note1 = new Note("Important meeting");
        Note note2 = new Note("Buy milk");
        entityManager.persist(note1);
        entityManager.persist(note2);
        entityManager.flush();

        // when
        List<Note> results = noteRepository.findByContentContaining("Important");

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getContent()).isEqualTo("Important meeting");
    }

    @Test
    void shouldFindByCreatedAtAfter() {
        // given
        LocalDateTime now = LocalDateTime.now();
        Note oldNote = new Note("Old");
        oldNote.setCreatedAt(now.minusDays(10));
        Note newNote = new Note("New");
        newNote.setCreatedAt(now.plusDays(1));
        entityManager.persist(oldNote);
        entityManager.persist(newNote);
        entityManager.flush();

        // when
        List<Note> results = noteRepository.findByCreatedAtAfter(now);

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getContent()).isEqualTo("New");
    }
}