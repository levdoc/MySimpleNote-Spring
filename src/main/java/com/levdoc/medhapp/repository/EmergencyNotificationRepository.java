package com.levdoc.medhapp.repository;

import com.levdoc.medhapp.model.notification.EmergencyNotification;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyNotificationRepository
        extends GenericRepository<EmergencyNotification>{
}
