package com.levdoc.medhapp.service;

import com.levdoc.medhapp.model.drugsinfo.DrugInfoModel;
import com.levdoc.medhapp.repository.DrugInfoModelRepository;
import org.springframework.stereotype.Service;

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

}
