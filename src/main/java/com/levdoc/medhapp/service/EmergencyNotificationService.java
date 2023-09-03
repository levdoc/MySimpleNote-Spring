package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.mapper.EmergencyNotificationMapper;
import com.levdoc.medhapp.model.notification.EmergencyNotification;
import com.levdoc.medhapp.repository.EmergencyNotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmergencyNotificationService {
    private final EmergencyNotificationRepository emergencyNotificationRepository;
    private final EmergencyNotificationMapper emergencyNotificationMapper;

    public EmergencyNotificationService(EmergencyNotificationRepository emergencyNotificationRepository,
                                        EmergencyNotificationMapper emergencyNotificationMapper) {
        this.emergencyNotificationRepository = emergencyNotificationRepository;
        this.emergencyNotificationMapper = emergencyNotificationMapper;
    }

    public List<EmergencyNotificationDTO> getAllEmergencyNotification() {
        List<EmergencyNotificationDTO> result = emergencyNotificationMapper.
                modelsToDTOs(emergencyNotificationRepository.findAll());
        return result == null ? Collections.emptyList() : result;
    }

    public void createEmergencyNotification(EmergencyNotificationDTO emergencyNotificationDTO) {
        EmergencyNotification em = emergencyNotificationMapper.dtoToModel(emergencyNotificationDTO);
        em.setCreatedWhen(LocalDateTime.now());
        em.setInnMo(9102065701L);
        em.setMoName("ГБУЗРК \"РДИКБ\"");
        em.setIsSend(false);
        em.setIsDownload(false);
        emergencyNotificationRepository.save(em);
    }

    public EmergencyNotificationDTO getOneById (Long id) {
        return emergencyNotificationMapper.modelToDTO(
                emergencyNotificationRepository.getEmergencyNotificationById(id));
    }

}
