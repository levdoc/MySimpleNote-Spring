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
        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        simpleNoteService.deleteNote(id);
        return "redirect:/notes";
    }

    @GetMapping()
    public String index(@RequestParam(required = false) String keyword,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "size", defaultValue = "5") int pageSize,
                        Model model) {

        try {
            PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
            Page<SimpleNoteDTO> notes;
            if (keyword == null) {
                notes = simpleNoteService.getAllNotePegable(pageRequest);
            } else {
                notes = simpleNoteService.findNotePegable(keyword, pageRequest);
            }
            model.addAttribute("notes", notes);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "note/index";
    }

    @GetMapping("/update/{id}")
    public String updateNote(@PathVariable Long id,
                             Model model) {
        try {
            model.addAttribute("note", simpleNoteService.getOneById(id));
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "note/updateNote";
    }

    @PostMapping("/update")
    public String updateNote(@ModelAttribute("updateNote") SimpleNoteDTO simpleNoteDTO) {
        simpleNoteService.updateNote(simpleNoteDTO);
        return "redirect:/em";
    }

}
