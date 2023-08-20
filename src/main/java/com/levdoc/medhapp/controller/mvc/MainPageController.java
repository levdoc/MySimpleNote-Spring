package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.SimpleNoteDTO;
import com.levdoc.medhapp.service.SimpleNoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping()
public class MainPageController {
    private final SimpleNoteService simpleNoteService;

    public MainPageController(SimpleNoteService simpleNoteService) {
        this.simpleNoteService = simpleNoteService;
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
}
