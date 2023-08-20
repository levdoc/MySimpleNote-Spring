package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.service.SimpleNoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
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

    @GetMapping("/delete/{id}")
    public String deleteNote (@PathVariable Long id) {
        simpleNoteService.deleteNote(id);
        return "redirect:/";
    }

    @GetMapping()
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "size", defaultValue = "5") int pageSize,
                        Model model) {
        PageRequest pageRequest = PageRequest.of(page-1, pageSize);
        Page<SimpleNoteDTO> notes = simpleNoteService.getAllNotePegable(pageRequest);
        model.addAttribute("notes", notes);
        return "index";
    }

    @GetMapping("/update/{id}")
    public String updateNote (@PathVariable Long id,
                              Model model) {
        model.addAttribute("note", simpleNoteService.getOneById(id));
        return "note/updateNote";
    }

    @PostMapping("/update")
    public String updateNote (@ModelAttribute("updateNote") SimpleNoteDTO simpleNoteDTO) {
        simpleNoteService.updateNote(simpleNoteDTO);
        return "redirect:/";
    }

}
