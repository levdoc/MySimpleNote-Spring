package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.service.EmergencyNotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addEm")
    public String createNote() {
        return "em/addEm";
    }

    @PostMapping("/addEm")
    public String createNote(@ModelAttribute("emForm") EmergencyNotificationDTO emergencyNotificationDTO) {
        emergencyNotificationService.createEmergencyNotification(emergencyNotificationDTO);
        return "redirect:/em";
    }

    @GetMapping("/patient/list/{id}")
    public String getEmPatientList (@PathVariable Long id,
                                    Model model) {
        model.addAttribute("em", emergencyNotificationService.getOneById(id));
        return "em/patient/index";
    }

    /*
    Реализовать контролер добавления пациента
    Реализовать сервис работы с пациентами (добавить, удалить, редактировать)
    Реализовать страницы добавления пациента, редактирования пациента
     */

}
