package com.levdoc.medhapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmergencyNotificationDTO extends GenericModelDTO{
    private Long innMo;
    private String moName;
    private String docFio;
    private String docPhoneNumber;
    private Boolean isSend;
    private List<PatientDTO> patientList;

}
