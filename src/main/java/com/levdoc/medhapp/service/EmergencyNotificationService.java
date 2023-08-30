package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.mapper.EmergencyNotificationMapper;
import com.levdoc.medhapp.repository.EmergencyNotificationRepository;
import org.springframework.stereotype.Service;

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

}
