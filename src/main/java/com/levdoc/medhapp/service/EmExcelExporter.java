package com.levdoc.medhapp.service;

import groovy.util.logging.Log4j2;
import lombok.extern.log4j.Log4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service

public class EmExcelExporter {
    @Value("classpath:file/tmp/xlsxTemplateEm.xlsx")
    private Resource xlsxTemplateEm;
    private XSSFWorkbook workbook;

    public void testMethod() {

        try {
            workbook = new XSSFWorkbook(xlsxTemplateEm.getFile());
        } catch (IOException | InvalidFormatException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

        System.out.println(workbook.getNumberOfSheets());

        System.out.println(xlsxTemplateEm.isFile());
    }

}
