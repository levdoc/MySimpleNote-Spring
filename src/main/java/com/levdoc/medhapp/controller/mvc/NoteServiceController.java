package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.service.SimpleNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteServiceController {
    private final SimpleNoteService simpleNoteService;

    public NoteServiceController(SimpleNoteService simpleNoteService) {
        this.simpleNoteService = simpleNoteService;
    }

    @GetMapping("/add")
    public String createNote() {
        return "note/addNote";
    }

    @PostMapping("/add")
    public String createNote(@ModelAttribute("noteForm") SimpleNoteDTO simpleNoteDTO) {
        simpleNoteService.createNote(simpleNoteDTO);
        return "redirect:/";
    }

}
