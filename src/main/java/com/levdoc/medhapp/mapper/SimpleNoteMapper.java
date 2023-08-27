package com.levdoc.medhapp.mapper;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.model.simplenote.SimpleNoteModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleNoteMapper {

    SimpleNoteMapper SIMPLE_NOTE_MAPPER = Mappers.getMapper(SimpleNoteMapper.class);

    SimpleNoteDTO modelToDTO (SimpleNoteModel simpleNoteModel);
    SimpleNoteModel DToToModel (SimpleNoteDTO simpleNoteDTO);
    List<SimpleNoteDTO> modelsToDTOs (List<SimpleNoteModel> simpleNoteModelList);
    List<SimpleNoteModel> DTOsToModels (List<SimpleNoteDTO> simpleNoteDTOList);
}
