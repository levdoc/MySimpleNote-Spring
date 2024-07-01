package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.model.drugsinfo.DrugInfoModel;
import com.levdoc.medhapp.repository.DrugInfoModelRepository;
import com.levdoc.medhapp.service.DrugInfoService;
import groovy.util.logging.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@Log4j
@RequestMapping("/drugs/info")
public class DrugInfoController {
    private final DrugInfoService drugInfoService;

    private final DrugInfoModelRepository drugInfoModelRepository;

    public DrugInfoController(DrugInfoService drugInfoService,
                              DrugInfoModelRepository drugInfoModelRepository) {
        this.drugInfoService = drugInfoService;
        this.drugInfoModelRepository = drugInfoModelRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("drugs", drugInfoService.getDrugList());
        return "drugsinfo/index";
    }

    @GetMapping("/add")
    public String addDrugs() {
        return "drugsinfo/addDrugInfo";
    }

    @PostMapping("/add")
    public String addDrugs(@ModelAttribute("drugForm") DrugInfoModel drugInfoModel) {
        drugInfoModel.setPublishDate(LocalDate.now());
        drugInfoModelRepository.save(drugInfoModel);
        return "redirect:/drugs/info";
    }


}
