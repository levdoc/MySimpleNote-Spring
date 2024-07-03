package com.levdoc.medhapp.service;

import com.levdoc.medhapp.model.drugsinfo.DrugInfoModel;
import com.levdoc.medhapp.repository.DrugInfoModelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class DrugInfoService {
    private final DrugInfoModelRepository drugInfoModelRepository;

    public DrugInfoService(DrugInfoModelRepository drugInfoModelRepository) {
        this.drugInfoModelRepository = drugInfoModelRepository;
    }

    public List<DrugInfoModel> getDrugList() {
        List<DrugInfoModel> resultList = drugInfoModelRepository.findAll();
        return resultList == null ? Collections.emptyList() : resultList;
    }

    public void addDrugInfo(DrugInfoModel drugInfoModel)  {
        drugInfoModel.setCreatedWhen(LocalDateTime.now());
        drugInfoModelRepository.save(drugInfoModel);
    }

    public DrugInfoModel getOneDrugInfo(Long id) {
        return drugInfoModelRepository.findOneById(id);
    }
}
