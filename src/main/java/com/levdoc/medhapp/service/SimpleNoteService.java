package com.levdoc.medhapp.service;

import com.levdoc.medhapp.model.simplenote.SimpleNoteModel;
import com.levdoc.medhapp.repository.SimpleNoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SimpleNoteService {
    private final SimpleNoteRepository simpleNoteRepository;

    public SimpleNoteService(SimpleNoteRepository simpleNoteRepository) {
        this.simpleNoteRepository = simpleNoteRepository;
    }

    public void createNote (SimpleNoteModel simpleNoteModel) {
        simpleNoteModel.setPublishDate(LocalDate.now());
        simpleNoteRepository.save(simpleNoteModel);
    }

    public Page<SimpleNoteModel> getAllNotePegable (Pageable pageable) {
        Page<SimpleNoteModel> notesPagineted = simpleNoteRepository.findAll(pageable);
        List<SimpleNoteModel> allNotes = notesPagineted.getContent();
        return new PageImpl<>(allNotes, pageable, notesPagineted.getTotalElements());
    }

    public Page<SimpleNoteModel> findNotePegable (String keyword, Pageable pageable) {
        Page<SimpleNoteModel> notesPagineted = simpleNoteRepository.findByMainTextContainingIgnoreCase(keyword, pageable);
        List<SimpleNoteModel> notes = notesPagineted.getContent();
        return new PageImpl<>(notes, pageable, notesPagineted.getTotalElements());
    }

    public void deleteNote (Long id) {
        simpleNoteRepository.deleteById(id);
    }

    public void updateNote (SimpleNoteModel simpleNoteModel) {
        simpleNoteRepository.save(simpleNoteModel);
    }

    public SimpleNoteModel getOneById (Long id) {
        return simpleNoteRepository.findSimpleNoteModelById(id);
    }
}
