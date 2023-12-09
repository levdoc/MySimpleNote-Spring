package com.levdoc.medhapp.model.notification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(name = "created_when")
    private LocalDateTime createdWhen;

    @Column(name = "send_when")
    private LocalDateTime sendWhen;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "emergency_notification_id")
    @Column(name = "patient_list")
    private List<Patient> patientList;

}
