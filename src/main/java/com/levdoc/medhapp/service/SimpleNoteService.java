package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.mapper.SimpleNoteMapper;
import com.levdoc.medhapp.model.simplenote.SimpleNoteModel;
import com.levdoc.medhapp.repository.SimpleNoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class SimpleNoteService {
    private final SimpleNoteRepository simpleNoteRepository;
    private final SimpleNoteMapper simpleNoteMapper;


    public SimpleNoteService(SimpleNoteRepository simpleNoteRepository,
                             SimpleNoteMapper simpleNoteMapper) {
        this.simpleNoteRepository = simpleNoteRepository;
        this.simpleNoteMapper = simpleNoteMapper;
    }

    public void createNote (SimpleNoteDTO simpleNoteDTO) {
        SimpleNoteModel simpleNoteModel = simpleNoteMapper.DToToModel(simpleNoteDTO);
        simpleNoteModel.setPublishDate(LocalDate.now());

        simpleNoteRepository.save(simpleNoteModel);
    }

    public List<SimpleNoteDTO> getAllNotes() {
        List<SimpleNoteDTO> allNotes = simpleNoteMapper.modelsToDTOs(simpleNoteRepository.findAll());
        return allNotes == null ? Collections.emptyList() : allNotes;
    }

    public Page<SimpleNoteDTO> getAllNotePegable (Pageable pageable) {
        Page<SimpleNoteModel> notesPagineted = simpleNoteRepository.findAll(pageable);
        List<SimpleNoteDTO> allNotes = simpleNoteMapper.modelsToDTOs(notesPagineted.getContent());
        return new PageImpl<>(allNotes, pageable, notesPagineted.getTotalElements());
    }

    public Page<SimpleNoteDTO> findNotePegable (String keyword, Pageable pageable) {
        Page<SimpleNoteModel> notesPagineted = simpleNoteRepository.findByMainTextContainingIgnoreCase(keyword, pageable);
        List<SimpleNoteDTO> notes = simpleNoteMapper.modelsToDTOs(notesPagineted.getContent());
        return new PageImpl<>(notes, pageable, notesPagineted.getTotalElements());
    }

    public void deleteNote (Long id) {
        simpleNoteRepository.deleteById(id);
    }

    public void updateNote (SimpleNoteDTO simpleNoteDTO) {
        simpleNoteRepository.save(simpleNoteMapper.DToToModel(simpleNoteDTO));
    }

    public SimpleNoteDTO getOneById (Long id) {
        return simpleNoteMapper.modelToDTO(simpleNoteRepository.findSimpleNoteModelById(id));
    }
}
