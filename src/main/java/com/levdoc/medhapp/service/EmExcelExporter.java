package com.levdoc.medhapp.service;

import groovy.util.logging.Log4j2;
import lombok.extern.log4j.Log4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
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

    private XSSFWorkbook openTemplateFileEM() {

        try {
            workbook = new XSSFWorkbook(xlsxTemplateEm.getFile());
        } catch (IOException | InvalidFormatException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

        System.out.println(workbook.getNumberOfSheets());

        System.out.println(xlsxTemplateEm.isFile());

        return workbook;
    }

    private Sheet openSheetTemplate (XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);

        System.out.println("Лист Excel 0 открыт удачно");

        return sheet;
    }

    public void createXlsxEmFile() {
        openSheetTemplate(openTemplateFileEM());

        System.out.println("Удачно!!!!!");
    }

}
