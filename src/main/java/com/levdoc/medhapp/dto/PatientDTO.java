package com.levdoc.medhapp.dto;

import com.levdoc.medhapp.model.notification.LaboratoryConfirmationEnum;
import com.levdoc.medhapp.model.notification.SexEnum;
import com.levdoc.medhapp.model.notification.SocialGroupEnum;
import com.levdoc.medhapp.model.notification.TypeOfDiagnosisEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PatientDTO extends GenericModelDTO {
    private String surname;

    private String name;

    private String patronymic;

    private LocalDate dateOfBirth;

    private SexEnum sex;

    private String patientPhoneNumber;

    // Мун образование / район города
    private String municipality;

    // Населенный пункт
    private String community;

    // Улица
    private String street;

    // Дом
    private String houseNumber;

    // Квартира
    private String apartmentNumber;

    // Наименование места учебы / работы
    private String placeOfStudy;

    // Социальная группу
    private SocialGroupEnum socialGroup;

    // Дата последненго посещения учебного заведения
    private LocalDate dateOfSchoolVisit;

    private TypeOfDiagnosisEnum typeOfDiagnosis;

    //  Код МКБ-10 диагноза
    private TypeOfDiagnosisEnum mkb10CodeOfDisease;

    //  Код МКБ-10 диагноза УТОЧНЕННЫЙ
    private TypeOfDiagnosisEnum mkb10CodeOfDiseaseRefined;

    // Дата установления диагноза
    private LocalDate dateOfDiagnosis;

    // Дата подтверждения диагноза
    private LocalDate dateOfConfirmationOfDiagnosis;

    // Диагноз подтвержден лабораторно?
    private LaboratoryConfirmationEnum diagnosisConfirmedByLaboratory;

    // Дата отмены диагноза
    private LocalDate dateOfWithdrawalOfTheDiagnosis;

    // Дата и время госпитализации (в формате ДД-ММ-ГГГГ ЧЧ:ММ) !!!!!!
    private LocalDateTime dateAndTimeOfHospitalization;

    //Дата заболевания (в формате ДД-ММ-ГГГГ)
    private LocalDate dateOfIllness;

    // Дата обращения (в формате ДД-ММ-ГГГГ)
    private LocalDate dateOfTheApplication;


}
