package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.model.simplenote.SimpleNoteModel;
import com.levdoc.medhapp.model.simplenote.TypeOfNote;
import com.levdoc.medhapp.service.SimpleNoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@Slf4j
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
    public String createNote(@ModelAttribute("noteForm")SimpleNoteModel simpleNoteModel,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getNestedPath() + " -> Ошибка добавления заметки, не указан тип заметки! Установлен тип по умолчанию!");
            simpleNoteModel.setTypeOfNote(TypeOfNote.OTHER);
            model.addAttribute("note", simpleNoteModel);
            return "note/updateNote";
        }

        simpleNoteService.createNote(simpleNoteModel);
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
            Page<SimpleNoteModel> notes;
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
        model.addAttribute("note", simpleNoteService.getOneById(id));
        return "note/updateNote";
    }

    @PostMapping("/update")
    public String updateNote(@ModelAttribute("updateNote") SimpleNoteModel simpleNoteModel,
                             BindingResult bindingResult,
                             Model model) {

        simpleNoteModel.setPublishDate(LocalDate.now());

        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getNestedPath());
            simpleNoteModel.setTypeOfNote(TypeOfNote.OTHER);
            model.addAttribute("note", simpleNoteModel);
            return "note/updateNote";
        }

        simpleNoteService.updateNote(simpleNoteModel);
        return "redirect:/notes";
    }

}
