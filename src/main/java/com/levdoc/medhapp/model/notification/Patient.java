package com.levdoc.medhapp.model.notification;

import com.levdoc.medhapp.model.GenericModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends GenericModel {

    @Column(name = "surname", nullable = false) // Фамилия
    private String surname;

    @Column(name = "name", nullable = false) // Имя
    private String name;

    @Column(name = "patronymic", nullable = false) // Отчество
    private String patronymic;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "sex", nullable = false)
    private SexEnum sex;

    @Column(name = "patient_phone_number")
    private String patientPhoneNumber;

    @Column(name = "municipality") // Мун образование / район города
    private String municipality;

    @Column(name = "community") // Населенный пункт
    private String community;

    @Column(name = "street") // Улица
    private String street;

    @Column(name = "house_number") // Дом
    private String houseNumber;

    @Column(name = "apartment_number") // Квартира
    private String apartmentNumber;

    @Column(name = "place_of_study") // Наименование места учебы / работы
    private String placeOfStudy;

    @Column(name = "social_group") // Социальная группу
    private SocialGroupEnum socialGroup;

    @Column(name = "date_of_school_visit") // Дата последненго посещения учебного заведения
    private LocalDate dateOfSchoolVisit;

    @Column(name = "type_of_disease", nullable = false)
    private TypeOfDiagnosisEnum typeOfDiagnosis;

    @Column(name = "mkb10_code_disease") //  Код МКБ-10 диагноза
    private String mkb10CodeOfDisease;

    @Column(name = "mkb10_code_disease_refined") //  Код МКБ-10 диагноза УТОЧНЕННЫЙ
    private String mkb10CodeOfDiseaseRefined;

    @Column(name = "date_of_diagnosis") // Дата установления диагноза
    private LocalDate dateOfDiagnosis;

    @Column(name = "date_of_confirmation_of_diagnosis") // Дата подтверждения диагноза
    private LocalDate dateOfConfirmationOfDiagnosis;

    @Column(name = "Diagnosis_confirmed_by_laboratory") // Диагноз подтвержден лабораторно?
    private LaboratoryConfirmationEnum diagnosisConfirmedByLaboratory;

    @Column(name = "date_of_withdrawal_of_the_diagnosis") // Дата отмены диагноза
    private LocalDate dateOfWithdrawalOfTheDiagnosis;

    @Column(name = "date_and_time_of_hospitalization") // Дата и время госпитализации (в формате ДД-ММ-ГГГГ ЧЧ:ММ) !!!!!!
    private LocalDateTime dateAndTimeOfHospitalization;

    @Column(name = "date_of_illness", nullable = false) //Дата заболевания (в формате ДД-ММ-ГГГГ)
    private LocalDate dateOfIllness;

    @Column(name = "date of the application", nullable = false) // Дата обращения (в формате ДД-ММ-ГГГГ)
    private LocalDate dateOfTheApplication;

    @Column(name="info_of_patient")
    private String infoOfPatient;


}
