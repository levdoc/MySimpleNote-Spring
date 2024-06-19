package com.levdoc.medhapp.service;

import com.levdoc.medhapp.model.mkb.Mkb10Model;
import com.levdoc.medhapp.repository.Mkb10Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mkb10Service {
    private final Mkb10Repository mkb10Repository;

    public Mkb10Service(Mkb10Repository mkb10Repository) {
        this.mkb10Repository = mkb10Repository;
    }

    public Page<Mkb10Model> getAllMkbCodePageable (Pageable pageable) {
        Page<Mkb10Model> mkbPaginated = mkb10Repository.findAll(pageable);
        List<Mkb10Model> allMkbCode = mkbPaginated.getContent();
        return new PageImpl<>(allMkbCode,pageable,mkbPaginated.getTotalElements());
    }

}
