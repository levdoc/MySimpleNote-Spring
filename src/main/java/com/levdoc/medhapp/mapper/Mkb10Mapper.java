package com.levdoc.medhapp.mapper;

import com.levdoc.medhapp.dto.Mkb10Dto;
import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.model.Mkb10Model;
import com.levdoc.medhapp.model.SimpleNoteModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Mkb10Mapper {

    Mkb10Mapper MKB_10_MAPPER_MAPPER = Mappers.getMapper(Mkb10Mapper.class);

    Mkb10Dto modelToDto (Mkb10Model mkb10Model);
    Mkb10Model DtoToModel (Mkb10Dto mkb10Dto);
    List<Mkb10Dto> modelsToDtos (List<Mkb10Model> mkb10ModelList);
    List<Mkb10Model> DtosToModels (List<Mkb10Dto> mkb10DtoList);

}
