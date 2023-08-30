package com.levdoc.medhapp.mapper;

import com.levdoc.medhapp.dto.PatientDTO;
import com.levdoc.medhapp.model.notification.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientMapper PATIENT_MAPPER = Mappers.getMapper(PatientMapper.class);

    PatientDTO modelToDto (Patient patient);
    Patient dtoToModel (PatientDTO patientDTO);
    List<PatientDTO> modelsToDto (List<Patient> patientList);
    List<Patient> dtosToModels (List<PatientDTO> patientDTOList);

}
