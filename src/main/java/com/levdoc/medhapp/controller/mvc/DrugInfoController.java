package com.levdoc.medhapp.controller.mvc;

import com.levdoc.medhapp.model.drugsinfo.DrugInfoModel;
import com.levdoc.medhapp.repository.DrugInfoModelRepository;
import com.levdoc.medhapp.service.DrugInfoService;
import groovy.util.logging.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j
@RequestMapping("/drugs/info")
public class DrugInfoController {
    private final DrugInfoService drugInfoService;

    public DrugInfoController(DrugInfoService drugInfoService,
                              DrugInfoModelRepository drugInfoModelRepository) {
        this.drugInfoService = drugInfoService;
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
        drugInfoModel.setIsActive(true);
        drugInfoModel.setIsDeleted(false);
        drugInfoService.addDrugInfo(drugInfoModel);
        return "redirect:/drugs/info";
    }

    @GetMapping("/view/{id}")
    public String getOneDrugInfo(@PathVariable Long id, Model model) {
        model.addAttribute("drugInfo", drugInfoService.getOneDrugInfo(id));
        return "drugsinfo/viewDrugInfo";
    }


}
