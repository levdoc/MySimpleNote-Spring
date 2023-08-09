package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.mapper.SimpleNoteMapper;
import com.levdoc.medhapp.model.SimpleNoteModel;
import com.levdoc.medhapp.repository.SimpleNoteRepository;
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

}
