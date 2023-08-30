package com.levdoc.medhapp.model.notification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "emergency_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyNotification {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "inn_mo")
    private Long innMo;

    @Column(name = "mo_name")
    private String moName;

    @Column(name = "doc_fio")
    private String docFio;

    @Column(name = "doc_phone_pumber")
    private String docPhoneNumber;

    @Column(name = "is_send")
    private Boolean isSend;

    @Column(name = "is_download")
    private Boolean isDownload;

    @OneToMany
    @Column(name = "patient_list")
    private List<Patient> patientList;

}
