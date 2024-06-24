package com.levdoc.medhapp.service;

import com.levdoc.medhapp.model.notification.EmergencyNotification;
import com.levdoc.medhapp.model.notification.Patient;
import com.levdoc.medhapp.repository.EmergencyNotificationRepository;
import com.levdoc.medhapp.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.levdoc.medhapp.constants.EmergencyNotificationConstants.INN_MO;
import static com.levdoc.medhapp.constants.EmergencyNotificationConstants.NAME_MO;

@Service
public class EmergencyNotificationService {
    private final EmergencyNotificationRepository emergencyNotificationRepository;
    private final PatientRepository patientRepository;

    public EmergencyNotificationService(EmergencyNotificationRepository emergencyNotificationRepository,
                                        PatientRepository patientRepository) {
        this.emergencyNotificationRepository = emergencyNotificationRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * Метод получает все "пакеты" экстренных извещений из базы данных.
     * @return Возвращает коллекция List содержащую экстренные извещения, если записей нет, возвращает Collections.emptyList()
     */
    public List<EmergencyNotification> getAllEmergencyNotification() {
        List<EmergencyNotification> result = emergencyNotificationRepository.findAll();
        return result == null ? Collections.emptyList() : result;
    }

    /**
     * Метод сохраняет "пакет" экстренного извещения в базе данных.
     *
     */
    public void createEmergencyNotification(EmergencyNotification emergencyNotification) {
        EmergencyNotification em = emergencyNotification;
        em.setCreatedWhen(LocalDateTime.now());
        em.setInnMo(INN_MO);
        em.setMoName(NAME_MO);
        em.setDeleted(false);
        em.setIsSend(false);
        emergencyNotificationRepository.save(em);
    }

    /**
     * Метод возвращает один "пакет" экстренного извещения по его ID
     * @param id - ID экстренного извещения
     * @return - возвращает emergencyNotification полученный по ID
     */
    public EmergencyNotification getOneById(Long id) {
        return emergencyNotificationRepository.getEmergencyNotificationById(id);
    }

    /**
     * Метод
     *
     */
    public void addPatientToEmergencyNotification(Patient patient) {
        EmergencyNotification em = emergencyNotificationRepository
                .getEmergencyNotificationById(patient.getIdOfEmergencyNotification());

        em.getPatientList().add(patientRepository.save(patient));
        emergencyNotificationRepository.save(em);
    }

    public void hardDeleteEm(Long id) {
        emergencyNotificationRepository.deleteById(id);
    }

    public void hardDeletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient getOnePatientById(Long id) {
        return patientRepository.getReferenceById(id);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

}
