package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.Mkb10Dto;
import com.levdoc.medhapp.mapper.Mkb10Mapper;
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
    private final Mkb10Mapper mkb10Mapper;

    public Mkb10Service(Mkb10Repository mkb10Repository, Mkb10Mapper mkb10Mapper) {
        this.mkb10Repository = mkb10Repository;
        this.mkb10Mapper = mkb10Mapper;
    }

    public Page<Mkb10Dto> getAllMkbCodePageable (Pageable pageable) {
        Page<Mkb10Model> mkbPaginated = mkb10Repository.findAll(pageable);
        List<Mkb10Dto> allMkbCode = mkb10Mapper.modelsToDtos(mkbPaginated.getContent());
        return new PageImpl<>(allMkbCode,pageable,mkbPaginated.getTotalElements());
    }

}
