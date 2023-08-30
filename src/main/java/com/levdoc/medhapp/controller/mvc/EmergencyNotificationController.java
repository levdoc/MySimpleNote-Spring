package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.service.EmergencyNotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/em")
public class EmergencyNotificationController {

    private final EmergencyNotificationService emergencyNotificationService;

    public EmergencyNotificationController(EmergencyNotificationService emergencyNotificationService) {
        this.emergencyNotificationService = emergencyNotificationService;
    }

    @GetMapping
    public String getAllEmergencyNotification(Model model) {
        List<EmergencyNotificationDTO> result = emergencyNotificationService.getAllEmergencyNotification();
        model.addAttribute("em", result);
        return "em/index";
    }

}
