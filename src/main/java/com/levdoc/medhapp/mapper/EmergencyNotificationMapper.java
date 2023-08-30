package com.levdoc.medhapp.mapper;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.model.notification.EmergencyNotification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmergencyNotificationMapper {

    EmergencyNotificationMapper EMERGENCY_NOTIFICATION_MAPPER = Mappers.getMapper(EmergencyNotificationMapper.class);

    EmergencyNotificationDTO modelToDTO (EmergencyNotification emergencyNotification);
    EmergencyNotification dtoToModel (EmergencyNotificationDTO emergencyNotificationDTO);
    List<EmergencyNotificationDTO> modelsToDTOs (List<EmergencyNotification> emergencyNotificationList);
    List<EmergencyNotification> dtosToModel (List<EmergencyNotificationDTO> emergencyNotificationDTOList);

}
