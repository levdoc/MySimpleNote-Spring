package com.levdoc.medhapp.repository;

import com.levdoc.medhapp.model.SimpleNoteModel;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleNoteRepository
        extends GenericRepository<SimpleNoteModel> {

    SimpleNoteModel findSimpleNoteModelById(Long id);

}
