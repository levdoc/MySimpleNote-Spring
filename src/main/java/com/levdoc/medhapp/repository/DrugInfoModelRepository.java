package com.levdoc.medhapp.repository;

import com.levdoc.medhapp.model.drugsinfo.DrugInfoModel;

public interface DrugInfoModelRepository
        extends GenericRepository<DrugInfoModel> {

    DrugInfoModel findOneById(Long id);

}
