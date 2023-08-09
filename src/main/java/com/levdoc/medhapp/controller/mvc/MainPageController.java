package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.service.SimpleNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainPageController {
    private final SimpleNoteService simpleNoteService;

    public MainPageController(SimpleNoteService simpleNoteService) {
        this.simpleNoteService = simpleNoteService;
    }

    @GetMapping()
    public String index(Model model) {
        List<SimpleNoteDTO> notes = simpleNoteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "index";
    }

}
