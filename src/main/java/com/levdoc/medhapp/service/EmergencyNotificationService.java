package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.dto.PatientDTO;
import com.levdoc.medhapp.mapper.EmergencyNotificationMapper;
import com.levdoc.medhapp.mapper.PatientMapper;
import com.levdoc.medhapp.model.notification.EmergencyNotification;
import com.levdoc.medhapp.repository.EmergencyNotificationRepository;
import com.levdoc.medhapp.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmergencyNotificationService {
    private final EmergencyNotificationRepository emergencyNotificationRepository;
    private final EmergencyNotificationMapper emergencyNotificationMapper;
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    public EmergencyNotificationService(EmergencyNotificationRepository emergencyNotificationRepository,
                                        EmergencyNotificationMapper emergencyNotificationMapper,
                                        PatientMapper patientMapper,
                                        PatientRepository patientRepository) {
        this.emergencyNotificationRepository = emergencyNotificationRepository;
        this.emergencyNotificationMapper = emergencyNotificationMapper;
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    /**
     * Метод получает все "пакеты" экстренных извещений из базы данных.
     * @return Возвращает коллекция List содержащую экстренные извещения, если записей нет, возвращает Collections.emptyList()
     */
    public List<EmergencyNotificationDTO> getAllEmergencyNotification() {
        List<EmergencyNotificationDTO> result = emergencyNotificationMapper.
                modelsToDTOs(emergencyNotificationRepository.findAll());
        return result == null ? Collections.emptyList() : result;
    }

    /**
     * Метод сохраняет "пакет" экстренного извещения в базе данных.
     * @param emergencyNotificationDTO
     */
    public void createEmergencyNotification(EmergencyNotificationDTO emergencyNotificationDTO) {
        EmergencyNotification em = emergencyNotificationMapper.dtoToModel(emergencyNotificationDTO);
        em.setCreatedWhen(LocalDateTime.now());
        em.setInnMo(9102065701L);
        em.setMoName("ГБУЗРК \"РДИКБ\"");
        em.setDeleted(false);
        em.setIsSend(false);
        emergencyNotificationRepository.save(em);
    }

    /**
     * Метод возвращает один "пакет" экстренного извещения по его ID
     * @param id - ID экстренного извещения
     * @return - возвращает emergencyNotification полученный по ID
     */
    public EmergencyNotificationDTO getOneById (Long id) {
        return emergencyNotificationMapper.modelToDTO(
                emergencyNotificationRepository.getEmergencyNotificationById(id));
    }

    /**
     * Метод
     * @param patientDTO
     */
    public void addPatientToEmergencyNotification(PatientDTO patientDTO) {
        EmergencyNotification em = emergencyNotificationRepository
                .getEmergencyNotificationById(patientDTO.getIdOfEmergencyNotification());

        em.getPatientList().add(patientRepository.save(patientMapper.dtoToModel(patientDTO)));
        emergencyNotificationRepository.save(em);
    }

    public void hardDeleteEm(Long id) {
        emergencyNotificationRepository.deleteById(id);
    }

    public void hardDeletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientDTO getOnePatientById(Long id) {
        return patientMapper.modelToDto(patientRepository.getReferenceById(id));
    }

    public void updatePatient (PatientDTO patientDTO) {
        patientRepository.save(patientMapper.dtoToModel(patientDTO));
    }

}
