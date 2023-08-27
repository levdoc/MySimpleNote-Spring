package com.levdoc.medhapp.repository;

import com.levdoc.medhapp.model.simplenote.SimpleNoteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleNoteRepository
        extends GenericRepository<SimpleNoteModel> {

    SimpleNoteModel findSimpleNoteModelById(Long id);
    Page<SimpleNoteModel> findByMainTextContainingIgnoreCase (String keyword, Pageable pageable);

}
