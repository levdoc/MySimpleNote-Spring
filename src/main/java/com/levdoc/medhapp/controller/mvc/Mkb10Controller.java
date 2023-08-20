package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.dto.Mkb10Dto;
import com.levdoc.medhapp.service.Mkb10Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("mkb10")
public class Mkb10Controller {

    private final Mkb10Service mkb10Service;

    public Mkb10Controller(Mkb10Service mkb10Service) {
        this.mkb10Service = mkb10Service;
    }

    @GetMapping
    public String getAllMkb10 (@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "50") int size,
                               Model model) {

        PageRequest pageRequest = PageRequest.of(page-1, size);
        Page<Mkb10Dto> mkb10Dtos = mkb10Service.getAllMkbCodePageable(pageRequest);
        model.addAttribute("mkb10code", mkb10Dtos);
        return "/mkb/indexMKB10";
    }

}
