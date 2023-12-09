package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.dto.PatientDTO;
import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.model.simplenote.TypeOfNote;
import com.levdoc.medhapp.service.EmExcelExporter;
import com.levdoc.medhapp.service.EmergencyNotificationService;
import jakarta.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/em")
public class EmergencyNotificationController {

    private final EmergencyNotificationService emergencyNotificationService;
    private final EmExcelExporter excelExporter;

    public EmergencyNotificationController(EmergencyNotificationService emergencyNotificationService,
                                           EmExcelExporter excelExporter) {
        this.emergencyNotificationService = emergencyNotificationService;
        this.excelExporter = excelExporter;
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
    public String getEmPatientList(@PathVariable Long id,
                                   Model model) {
        model.addAttribute("em", emergencyNotificationService.getOneById(id));
        return "em/patient/index";
    }

    @GetMapping("/patient/add/{idEm}")
    public String addPatientToEm(@PathVariable Long idEm,
                                 Model model) {
        model.addAttribute("em", emergencyNotificationService.getOneById(idEm).getId());
        return "em/patient/addPatient";
    }

    @PostMapping("/patient/add")
    public String addPatientToEm(@ModelAttribute PatientDTO patientDTO) {

        emergencyNotificationService.addPatientToEmergencyNotification(patientDTO);
        return "redirect:/em/patient/list/" + patientDTO.getIdOfEmergencyNotification();
    }

    @GetMapping("{emId}/patient/delete/{id}")
    public String deletePatientOfEm(@PathVariable Long emId,
                                    @PathVariable Long id) {
        emergencyNotificationService.hardDeletePatientById(id);
        return "redirect:/em/patient/list/" + emId;
    }

    @GetMapping("/delete/{id}")
    public String deleteEm(@PathVariable Long id) {
        emergencyNotificationService.hardDeleteEm(id);
        return "redirect:/em";
    }

    @GetMapping(value = "/export/excel/{id}/download", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadEMFile(@PathVariable Long id) {
        File resource;
        ByteArrayResource arrayResource;

        EmergencyNotificationDTO em = emergencyNotificationService.getOneById(id);

        resource = excelExporter.getEmExcleFile(em);

        Path path = resource.toPath();
        try {
            arrayResource = new ByteArrayResource(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok()
                .headers(createHeaders(path.getFileName().toString()))
                .contentLength(path.toFile().length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(arrayResource);
    }

    private HttpHeaders createHeaders(final String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name);
        headers.add("Cache-Control", "no-cache, no-store");
        headers.add("Expires", "0");
        return headers;
    }

    @GetMapping("/update/{id}")
    public String updatePatientEm(@PathVariable Long id,
                                  Model model) {
        model.addAttribute("patient", emergencyNotificationService.getOnePatientById(id));
        return "em/patient/updatePatient";
    }

    @PostMapping("/patient/update")
    public String updateNote(@ModelAttribute("patientForm") PatientDTO patientDTO,
                             Model model) {

        emergencyNotificationService.updatePatient(patientDTO);
        return "redirect:/em";
    }

}
